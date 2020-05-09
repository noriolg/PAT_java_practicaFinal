package servlets;

import DAO.AccionDAO;
import DAO.ClasesOfrecidasDAO;
import DAO.ProfesorDAO;
import DAO.UsuarioDAO;
import Util.Constantes;
import Util.StringFormatter;
import dominio.Accion;
import dominio.ClaseProducto;
import dominio.Profesor;
import dominio.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class GestorPeticionBDAcciones extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            AccionDAO accionDAO = AccionDAO.getInstance();
            ArrayList acciones = (ArrayList) accionDAO.obtenerCollectionAcciones();
            request.setAttribute("listaAcciones", acciones);
        }

        catch(Exception e)
        {
            System.out.println("Error en InsercionAdmin 46");
            e.printStackTrace();;
        }
        request.getRequestDispatcher("log-acciones").forward(request,response);
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
