package servlets;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import DAO.AlumnoDAO;
import DAO.ProfesorDAO;
import DAO.UsuarioDAO;
import Util.StringFormatter;
import dominio.Usuario;
import Util.Constantes;


public class Autenticacion extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String user =request.getParameter("usuario"); //name
        String password =request.getParameter("contrasena");

        // Cuidamos que no haya caracteres raros
        user = StringFormatter.formatString(user);

        Usuario usuario = new Usuario(user, password);

        try
        {
            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            boolean existe = usuarioDAO.usuarioExiste(usuario);
            HttpSession sesion = request.getSession();

            if(existe)
            {
                // Se determina el tipo de usuario que ha accedido
                int tipoUsuario = determinarTipoUsuario(usuario);

                sesion.setAttribute("usertype", tipoUsuario);
                sesion.setAttribute("acceso", true);
                sesion.setAttribute("username", usuario.getUsuario());

                // Dependiendo del tipo de usuario creamos un objeto u otro
                if (tipoUsuario == Constantes.ALUMNO){
                    AlumnoDAO alumnoDAO = AlumnoDAO.getInstance();
                    sesion.setAttribute("objetoAlumno", alumnoDAO.obtenerAlumno(usuario));
                }else{
                    ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
                    sesion.setAttribute("objetoProfesor", profesorDAO.obtenerProfesor(usuario));
                }
                request.setAttribute("mensajeacceso", "");
                //response.sendRedirect("GestorClases");
                request.getRequestDispatcher("/dashboard").forward(request, response);
            }
            else
            {
                sesion.setAttribute("acceso", false);
                request.setAttribute("mensajeacceso", "Usuario o contrasena incorrectos");
                //sesion.setAttribute("mensajeacceso", "Usuario o contrasena incorrectos");
                request.getRequestDispatcher("/acceso").forward(request, response);
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


    private int determinarTipoUsuario(Usuario user) throws Exception {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        // Por defecto asumimos que es alumno
        int tipoUsuario;

        if(usuarioDAO.esAlumno(user)){
            tipoUsuario = Constantes.ALUMNO;
        }
        else{
            if(usuarioDAO.esProfesor(user)){
                tipoUsuario = Constantes.PROFESOR;
            }
            else{
                tipoUsuario = Constantes.ADMIN;
            }
        }
        return tipoUsuario;
    }
}
