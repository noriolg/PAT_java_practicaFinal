package servlets;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import DAO.AccionDAO;
import DAO.AlumnoDAO;
import DAO.UsuarioDAO;
import Util.Constantes;
import Util.StringFormatter;
import dominio.Accion;
import dominio.Alumno;
import dominio.Usuario;


public class Registro extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loguear(request, response);
    }

    protected void loguear(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            response.setStatus(200);

            // En primer lugar se obtienen los parámetros pasados por la petición
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String codigo =request.getParameter("CP");
            String user =request.getParameter("usuario");
            String contrasena =request.getParameter("contrasena");
            String telefono =request.getParameter("telefono");
            String email =request.getParameter("email");
            String etapa =request.getParameter("etapa");
            String curso =request.getParameter("cursos");

            // Cuidamos que no haya caracteres raros
            nombre = StringFormatter.formatString(nombre);
            apellidos = StringFormatter.formatString(apellidos);
            user = StringFormatter.formatString(user);
            email = StringFormatter.formatString(email);

            // Validación en servidor
            if (algunoVacio(nombre, apellidos, codigo, user, contrasena, telefono, email, etapa, curso)){
                response.sendError(401, "Acceso no autorizado");
            }else {

                // Primero se registra en la tabla usuarios.
                Usuario usuario = new Usuario(user, contrasena);
                UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
                if(usuarioDAO.anadirUsuario(usuario, Constantes.ALUMNO)){
                    System.out.println("Usuario anadido");
                    Alumno alumno = new Alumno(user, contrasena, nombre, apellidos, Integer.parseInt(codigo), email, telefono, etapa, Integer.parseInt(curso));
                    if(anadirAlumno(alumno)){
                        System.out.println("Alumno anadido");
                        logAccion(Constantes.ALUMNO,"Nuevo alumno registrado. Usuario: " + alumno.getUsuario());
                        resolverRegistro(true, request, response);
                    }
                    else{
                        resolverRegistro(false, request, response);
                    }
                }
                else{
                    resolverRegistro(false, request, response);
                }
            }

        }catch (IllegalArgumentException | ServletException e){
            System.out.println("Error en Registro línea 56");
            e.printStackTrace();
            response.sendError(500, "Error Argumento Invalido.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean algunoVacio(String nombre, String apellidos, String codigo, String user, String contrasena, String telefono, String email, String etapa, String curso){
       try{
           /*System.out.println(nombre);
           System.out.println(apellidos);
           System.out.println(codigo);
           System.out.println(user);
           System.out.println(contrasena);
           System.out.println(telefono);
           System.out.println(email);
           System.out.println(etapa);
           System.out.println(curso);*/

           boolean algunoVacio =  nombre.isEmpty() || apellidos.isEmpty() || codigo.isEmpty() || user.isEmpty() || contrasena.isEmpty() || telefono.isEmpty() || email.isEmpty() || etapa.isEmpty() || curso.isEmpty();
           System.out.println(algunoVacio);
           return algunoVacio;
       }
       catch (NullPointerException e){
           return true; // Hay alguno vacio
       }

        /*boolean algunoVacio = false;
        for(String arg: args){
            algunoVacio = algunoVacio || arg.isEmpty();
            // Con que alguno esté vacío, la variable se vuelve true.
        }
        // Devuelvo true si alguno está vacío
        return algunoVacio;*/
    }

    // Devuelve true si se ha añadido correctamente
    private boolean anadirAlumno(Alumno alumno) throws SQLException, ClassNotFoundException {
        AlumnoDAO alumnoDAO = AlumnoDAO.getInstance();
        return alumnoDAO.anadirAlumno(alumno);
    }


    private void resolverRegistro(boolean booleanExitoso, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (booleanExitoso){
            request.setAttribute("mensajeacceso", "Registrado correctamente");
            request.getRequestDispatcher("/acceso").forward(request, response);
        }
        else{
            request.setAttribute("mensajeacceso", "Nombre de usuario ya existe");
            request.getRequestDispatcher("/registro").forward(request, response);
        }
    }

    private void logAccion(int usertype, String descripcion) throws SQLException, ClassNotFoundException {
        AccionDAO accionDAO = AccionDAO.getInstance();
        accionDAO.anadirAccion(new Accion(usertype, descripcion));
    }

}

