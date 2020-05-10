package servlets;

import DAO.ClasesAsignadasDAO;
import DAO.ProfesorDAO;
import Util.SecurityFilter;
import dominio.Alumno;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class GestionDashboardAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!SecurityFilter.CheckUserType(2,request) ){
            response.sendRedirect("index");
        }else{
            try{
                String submit = request.getParameter("asignar");
                if(submit != null){
                    asignarProfesor(request);
                }

                ClasesAsignadasDAO clasesAsignadasDAO = ClasesAsignadasDAO.getInstance();
                ProfesorDAO profesorDAO = ProfesorDAO.getInstance();

                ArrayList clasesSinAsignar = (ArrayList) clasesAsignadasDAO.obtenerTodasClasesSinAsignar();
                ArrayList clasesAsignadas = (ArrayList) clasesAsignadasDAO.obtenerTodasAsignadas();
                ArrayList profesores = (ArrayList) profesorDAO.obtenerCollectionProfesores();

                request.setAttribute("listaClasesSinAsignar", clasesSinAsignar);
                request.setAttribute("listaClasesAsignadas", clasesAsignadas);
                request.setAttribute("listaProfesores", profesores);
                request.getRequestDispatcher("dashboard-admin").forward(request,response);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void asignarProfesor(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        ClasesAsignadasDAO clasesAsignadasDAO = ClasesAsignadasDAO.getInstance();
        String idClase = (String) request.getParameter("clase-seleccionada");
        String userProf = (String) request.getParameter("profesor-seleccionado");

        clasesAsignadasDAO.asignarProfesorAClase(userProf, idClase);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
