package servlets;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;

import DAO.*;
import Util.StringFormatter;
import dominio.Accion;
import dominio.ClaseProducto;
import dominio.Profesor;
import dominio.Usuario;
import Util.Constantes;


public class InsercionAdmin extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Se obtiene el boton que se ha pulsado. El que no se haya pulsado devolvera null
        String submitProfesor = request.getParameter("submitProfesor");
        String submitAsignatura = request.getParameter("submitAsignatura");
        try
        {
            if(submitProfesor != null)
            {
                Profesor profesor = crearProfesor(request);
                // Se inserta y se comprueba si se ha hecho correctamente
                if(insertarProfesor(profesor)){
                    logAccion(Constantes.PROFESOR,"Nuevo profesor anadido por admin. Usuario: " + profesor.getUsuario());
                    System.out.println("Insercion ok");
                }
                else{
                    System.out.println("Insercion ko");
                }
            }
            else if(submitAsignatura != null)
            {
                ClaseProducto claseProducto = crearClaseProducto(request);
                // Se inserta y se comprueba si se ha hecho correctamente
                if(insertarClaseProducto(claseProducto)){
                    logAccion(Constantes.ADMIN,"Nueva clase producto anadida. Clase: " + claseProducto.toString());
                    System.out.println("Insercion ok");
                }
                else{
                    System.out.println("Insercion ko");
                }
            }
            else{
                System.out.println("Error en InsercionAdmin 40");
            }
            response.sendRedirect("anadir");
        }
        catch(Exception e)
        {
            System.out.println("Error en InsercionAdmin 46");
            e.printStackTrace();;
        }

    }

    private boolean insertarProfesor(Profesor profesor) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
        boolean insercionOK = false;

        if(usuarioDAO.anadirUsuario(new Usuario(profesor.getUsuario(), profesor.getContrasena()), Constantes.PROFESOR)) {
            // Se ha podido anadir en usuarios. Peligro si esto si que sale y lo siguiente no,
            // en ese caso ya no dejaría anadir nada más porque habría un usuario pero no un profesor
            if(profesorDAO.anadirProfesor(profesor)){
                insercionOK = true;
            }
        }
        return insercionOK;
    }

    private Profesor crearProfesor(HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        int codigo = Integer.parseInt(request.getParameter("CP"));
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");

        // Se tratan tildes y caracteres extraños
        nombre = StringFormatter.formatString(nombre);
        apellidos = StringFormatter.formatString(apellidos);
        usuario = StringFormatter.formatString(usuario);


        Profesor profesor = new Profesor(usuario, contrasena, nombre, apellidos, codigo, email, telefono, null);
        return profesor;
    }

    private boolean insertarClaseProducto(ClaseProducto claseProducto) throws SQLException, ClassNotFoundException {
        ClasesOfrecidasDAO clasesOfrecidasDAO = ClasesOfrecidasDAO.getInstance();
        boolean insercionOK = false;

        if(clasesOfrecidasDAO.anadirClase(claseProducto)) {
                insercionOK = true;
        }
        return insercionOK;
    }

    private ClaseProducto crearClaseProducto(HttpServletRequest request){
        int curso = Integer.parseInt(request.getParameter("curso"));
        String etapa = request.getParameter("etapa");
        String asignatura = request.getParameter("asignatura");


        etapa = StringFormatter.formatString(etapa);
        asignatura = StringFormatter.formatString(asignatura);


        ClaseProducto claseProducto = new ClaseProducto(curso, etapa, asignatura);
        return claseProducto;
    }

    private void logAccion(int usertype, String descripcion) throws SQLException, ClassNotFoundException {
        AccionDAO accionDAO = AccionDAO.getInstance();
        accionDAO.anadirAccion(new Accion(usertype, descripcion));
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
