package servlets;

import DAO.AccionDAO;
import DAO.AlumnoDAO;
import DAO.ProfesorDAO;
import DAO.UsuarioDAO;
import Util.Constantes;
import Util.StringFormatter;
import dominio.Accion;
import dominio.Alumno;
import dominio.Profesor;
import dominio.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class EditarPerfil extends HttpServlet{
    boolean cambiarContrasena;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        // Se obtiene el boton que se ha pulsado. El que no se haya pulsado devolvera null
        // Si se viene aquí desde cabecera, ambos serán null. Esto se hace para eliminar posibles mensajes en la sesion.
        String perfilProfesor = request.getParameter("submitActualizacionProfesor");
        String perfilAlumno = request.getParameter("submitActualizacionAlumno");
        String pathRetorno = "index"; // Por defecto por si hay algún error
        cambiarContrasena = false; // Indica si se ha realizado un cambio de contrasena

        try
        {
            if(perfilProfesor != null)
            {
                // Se está editando un perfil de profesor, se crea el objeto profesor a introducir,
                Profesor profesor = crearProfesor(request);

                // Se inserta y se comprueba si se ha hecho correctamente
                if(actualizarProfesor(profesor)){
                    logAccion(Constantes.PROFESOR,"Se ha editado un perfil. Usuario: " + profesor.getUsuario());
                    pathRetorno = "editar-perfil-profesor";
                    request.setAttribute("mensajeActualizacion", "Actualización ejecutada correctamente");
                    System.out.println(request.getAttribute("mensajeActualizacion"));
                }
                else{
                    System.out.println("Actualizacion ko 44");
                }
            }
            else if(perfilAlumno != null)
            {
                // Se está editando un perfil de un alumno, se crea el objeto alumno a introducir.
                Alumno alumno = crearAlumno(request);
                // Se inserta y se comprueba si se ha hecho correctamente
                if(actualizarAlumno(alumno)){
                    logAccion(Constantes.ALUMNO,"Se ha editado un perfil. Usuario: " + alumno.getUsuario());
                    pathRetorno = "editar-perfil-alumno";
                    request.setAttribute("mensajeActualizacion", "Actualizacion ejecutada correctamente");
                }
                else{
                    System.out.println("Actualización ko 57");
                }
            }
            else{
                // A la entrada de cualquier actualizacion se pasa por aquí para borrar
                // un posible mensaje que haya en la sesión de alguna actualización pasada.
                if(request.getAttribute("mensajeActualizacion") != null){
                    request.removeAttribute("mensajeActualizacion");
                }

                if(Integer.valueOf(0) == request.getSession().getAttribute("usertype")){
                    pathRetorno = "editar-perfil-alumno";
                }else{
                    pathRetorno = "editar-perfil-profesor";
                }
            }
            // Depende del camino que se haya seguido
            request.getRequestDispatcher(pathRetorno).forward(request, response);
        }
        catch(Exception e)
        {
            System.out.println("Error en EditarPerfil 67");
            e.printStackTrace();;
        }
    }

    private Profesor crearProfesor(HttpServletRequest request){

        // Primero se obtienen todos los parámetros posibles a editar
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String contrasena = request.getParameter("contrasena");
        String codigo =request.getParameter("CP");
        String telefono =request.getParameter("telefono");
        String email =request.getParameter("email");
        String descripcion =request.getParameter("descripcion");

        // Obtenemos el objeto de la sesion con los valores actuales
        Profesor profesor = (Profesor) request.getSession().getAttribute("objetoProfesor");


        //Ahora se obtienen los segundos, si no son null, se actualiza el valor anterior.
        if(!nombre.equals("")){
            profesor.setNombre(StringFormatter.formatString(nombre));
        }
        if (!apellidos.equals("")){
            profesor.setApellidos(StringFormatter.formatString(apellidos));
        }
        if(!codigo.equals("")){
            profesor.setCodigoPostal(Integer.parseInt(codigo));
        }
        if(!contrasena.equals("")){
            cambiarContrasena(true);
            profesor.setContrasena(contrasena);
            System.out.println("cambio contrasena");
        }
        if(!telefono.equals("")){
            profesor.setTelefono(telefono);
        }
        if(!email.equals("")){
            profesor.setEmail(StringFormatter.formatString(email));
        }
        if(!descripcion.equals("")){
            profesor.setDescripcion(StringFormatter.formatString(descripcion));
        }

        return  profesor;
    }

    private boolean actualizarProfesor(Profesor profesor) throws SQLException, ClassNotFoundException {
        ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
        boolean actualizacionOk = profesorDAO.actualizarProfesor(profesor);

        if(cambiarContrasena){
            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            // La actualizacion solo es ok si ambas son true
            boolean userActualizacion = usuarioDAO.actualizarUsuario(new Usuario(profesor.getUsuario(), profesor.getContrasena()));
            actualizacionOk = actualizacionOk && userActualizacion;
        }

        return actualizacionOk;
    }

    private Alumno crearAlumno(HttpServletRequest request){

        // Primero se obtienen todos los parámetros posibles a editar
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String codigo =request.getParameter("CP");
        String contrasena =request.getParameter("contrasena");
        String telefono =request.getParameter("telefono");
        String email =request.getParameter("email");
        String etapa =request.getParameter("etapa");
        String curso =request.getParameter("curso");

        // La contrasena está en la sesion
        Alumno alumno = (Alumno) request.getSession().getAttribute("objetoAlumno");

        //Ahora se obtienen los segundos, si no son null, se actualiza el valor anterior.
        if(!nombre.equals("")){
            alumno.setNombre(StringFormatter.formatString(nombre));
        }
        if (!apellidos.equals("")){
            alumno.setApellidos(StringFormatter.formatString(apellidos));
        }
        if(!codigo.equals("")){
            alumno.setCodigoPostal(Integer.parseInt(codigo));
        }
        if(!contrasena.equals("")){
            alumno.setContrasena(contrasena);
            cambiarContrasena(true);
        }
        if(!telefono.equals("")){
            alumno.setTelefono(telefono);
        }
        if(!email.equals("")){
            alumno.setEmail(StringFormatter.formatString(email));
        }
        if(!etapa.equals("")){
            alumno.setEtapa(etapa);
        }
        if(!curso.equals("")){
            alumno.setCurso(Integer.parseInt(curso));
        }
        return  alumno;
    }

    private boolean actualizarAlumno(Alumno alumno) throws SQLException, ClassNotFoundException {
        AlumnoDAO alumnoDAO = AlumnoDAO.getInstance();
        boolean actualizacionOk = alumnoDAO.actualizarAlumno(alumno);

        if(cambiarContrasena){
            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            // La actualizacion solo es ok si ambas son true
            actualizacionOk = actualizacionOk && usuarioDAO.actualizarUsuario(new Usuario(alumno.getUsuario(), alumno.getContrasena()));
        }


        return actualizacionOk;
    }

    private void logAccion(int usertype, String descripcion) throws SQLException, ClassNotFoundException {
        AccionDAO accionDAO = AccionDAO.getInstance();
        accionDAO.anadirAccion(new Accion(usertype, descripcion));
    }

    private void cambiarContrasena(boolean valorAActualizar){
        this.cambiarContrasena = valorAActualizar;
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
