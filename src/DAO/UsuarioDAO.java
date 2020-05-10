package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.PreparedStatement;

import Util.Constantes;
import dominio.Alumno;
import dominio.Profesor;
import dominio.Usuario;

public class UsuarioDAO {

    private static UsuarioDAO usuarioDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = Constantes.BDPASS;
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private UsuarioDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
    }

    public static UsuarioDAO getInstance() throws SQLException, ClassNotFoundException
    {
        if(usuarioDAO!=null)
        {
            if(!usuarioDAO.isActiva())
                usuarioDAO = new UsuarioDAO();
        }
        else
            usuarioDAO = new UsuarioDAO();
        return usuarioDAO;
    }

    private boolean isActiva() throws SQLException
    {
        return con.isValid(0);
    }

    // Devuelve false siya existía
    public boolean anadirUsuario(Usuario usuario, int tipoUsuario)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (usuario, contrasena, usertype )  VALUES (?, ?, ?)");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, tipoUsuario);
            int i = ps.executeUpdate();

            con.close();
            insercionOk = true;
        }catch(SQLException | ClassNotFoundException e) {
            System.out.println("Excepción controlada: " +  e);
            insercionOk = false;
        }
        return insercionOk;
    }

    public boolean usuarioExiste(Usuario usuario) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE  usuario = ? AND contrasena = ? ");
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            con.close();
            return true;
        }
        else{
            con.close();
            return false;
        }

    }

    public boolean esAlumno(Usuario usuario) throws ClassNotFoundException, SQLException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
        System.out.println(usuario.getUsuario());
        System.out.println(usuario.getContrasena());
        PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE  usuario = ? AND contrasena = ? ");
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ResultSet rs = ps.executeQuery();

        int userType = -1;
        int numeroResultados = 0;
        while(rs.next()){
            userType = Integer.parseInt(rs.getString(3));
            numeroResultados ++;
        }
        rs.close();
        // Si se ha obtenido más de un resultado es que hay un error en la tabla
        if(numeroResultados != 1 || userType == -1){
            con.close();
            throw new Exception("Error de integridad de la base de datos. UsuarioDAO 97");
        }
        else{
            if(userType == Constantes.ALUMNO){
                // Si es alumno, se devuelve true
                con.close();
                return true;
            }else{
                // Si no es alumno, se devuelve false
                con.close();
                return false;
            }
        }
    }


    public boolean esProfesor(Usuario usuario) throws ClassNotFoundException, SQLException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM profesores WHERE  usuario = ? AND contrasena = ? ");
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ResultSet rs = ps.executeQuery();

        int userType = -1;
        int numeroResultados = 0;
        while(rs.next()){
            userType = Integer.parseInt(rs.getString("usertype"));
            numeroResultados ++;
        }
        rs.close();

        // Si se ha obtenido más de un resultado es que hay un error en la tabla
        if(numeroResultados != 1 || userType == -1){
            con.close();
            throw new Exception("Error de integridad de la base de datos. AlumnoDAO 125");
        }
        else{

            if(userType == Constantes.PROFESOR){
                // Si es profesor devolvemos true
                con.close();
                return true;
            }else{
                // Si no es profesor, devolvemos false, por lo que sera admin
                con.close();
                return false;
            }
        }
    }


    public boolean actualizarUsuario(Usuario usuario){
        boolean actualizacionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET contrasena = ? where usuario = ?");
            ps.setString(1, usuario.getContrasena());
            ps.setString(2, usuario.getUsuario());

            int i = ps.executeUpdate();
            con.close();
            actualizacionOk = true;
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo en UsuarioDAO linea 182");
            System.out.println(e);
            actualizacionOk = false;
        }
        return actualizacionOk;
    }



    // Cierra la conexión iniciada por la instancia de UsuarioDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }

}

