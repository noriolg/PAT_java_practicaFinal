package servlets;

import DAO.ClasesAsignadasDAO;
import DAO.UsuarioDAO;
import dominio.Alumno;
import dominio.Clase;
import dominio.Profesor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class GestionDashBoardAlumnoProfesor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int tipo= (int)session.getAttribute("usertype");
        if(tipo==0){
            try{
                Alumno alumno =(Alumno) session.getAttribute("objetoAlumno");
                ClasesAsignadasDAO bdclases = ClasesAsignadasDAO.getInstance();
                ArrayList<Clase> clases= bdclases.obtenerClasesAsignadas(alumno);
                for (Clase c:clases) {
                    System.out.println(c.getDescripcion());

                }
                session.setAttribute("misclases",clases);
                response.sendRedirect("dashboard");

            }catch (Exception e){
                System.out.println("Error en Dashboard alumno");
                e.printStackTrace();;
            }
        }else{
            try{
                Profesor profesor=(Profesor)session.getAttribute("objetoProfesor");
                ClasesAsignadasDAO bdclases = ClasesAsignadasDAO.getInstance();
                ArrayList<Clase> clases= bdclases.obtenerClasesAsignadas(profesor);
                session.setAttribute("misclases",clases);
                response.sendRedirect("dashboard");

            }catch (Exception e){
                System.out.println("Error Error en Dashboard profesor");
                e.printStackTrace();;
            }
        }
    }
}
