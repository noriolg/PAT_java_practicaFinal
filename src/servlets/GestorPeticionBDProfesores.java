package servlets;

import DAO.ProfesorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class GestorPeticionBDProfesores extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
            ArrayList profesores = (ArrayList) profesorDAO.obtenerCollectionProfesores();
            request.setAttribute("listaProfesores", profesores);
        }

        catch(Exception e)
        {
            System.out.println("Error en GestionPeticionBDProfesores 28");
            e.printStackTrace();;
        }
        request.getRequestDispatcher("profesores").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
