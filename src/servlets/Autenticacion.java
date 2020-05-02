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
        String user =request.getParameter("form_acceso_usuario_name");
        String password =request.getParameter("form_acceso_contrasena_name");

        Usuario usuario = new Usuario(user, password);

        try
        {
            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            boolean existe = usuarioDAO.usuarioExiste(usuario);

            if(existe)
            {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("user", user);
                response.sendRedirect("GestorGeneralClases");
                //request.getRequestDispatcher("/zonacompra.jsp").forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("/acceso_no_satisfactorio.jsp").forward(request, response);
                //response.sendRedirect("error.html");
            }
        }
        catch(Exception e)
        {
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
