package servlets;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import DAO.UsuarioDAO;
import dominio.Usuario;


public class Autenticacion extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String user =request.getParameter("usuario"); //name
        String password =request.getParameter("contrasena");

        Usuario usuario = new Usuario(user, password);

        try
        {
            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            boolean existe = usuarioDAO.usuarioExiste(usuario);
            HttpSession sesion = request.getSession();

            if(existe)
            {

                sesion.setAttribute("user", user);
                sesion.setAttribute("acceso", true);
                request.setAttribute("mensajeacceso", "");
                //sesion.setAttribute("mensajeacceso", "");
                //response.sendRedirect("GestorClases");
                request.getRequestDispatcher("/zona-clases").forward(request, response);
            }
            else
            {
                sesion.setAttribute("acceso", false);
                request.setAttribute("mensajeacceso", "Usuario o contrasena incorrectos");
                //sesion.setAttribute("mensajeacceso", "Usuario o contrasena incorrectos");
                request.getRequestDispatcher("/acceso").forward(request, response);
                //response.sendRedirect("error.html");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error en Autenticacion 51");
            e.printStackTrace();;
        }

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
