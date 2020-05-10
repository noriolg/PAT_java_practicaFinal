package servlets;

import DAO.AlumnoDAO;
import DAO.ClasesAsignadasDAO;
import DAO.ProfesorDAO;
import DAO.UsuarioDAO;
import Servicios.CarritoServicio;
import Util.Constantes;
import dominio.Alumno;
import dominio.Carrito;
import dominio.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FinalizarCompra extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){

        HttpSession session=request.getSession();
        Alumno usuario=(Alumno) session.getAttribute("objetoAlumno");
        Carrito carrito=(Carrito) session.getAttribute("carrito");

        try
        {
            ClasesAsignadasDAO clasesAsignadasDAO = ClasesAsignadasDAO.getInstance();
            boolean insercion=clasesAsignadasDAO.anadirClasesSinAsignar(usuario,carrito);
            if(insercion)
            {
                request.setAttribute("mensajeCompra","Se ha realizado la compra correctamente");
                RequestDispatcher rd=request.getRequestDispatcher("index");
                new CarritoServicio(request).vaciar();
                rd.forward(request,response);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error en FinalizarCompra 56");
            e.printStackTrace();;
        }

    }
}
