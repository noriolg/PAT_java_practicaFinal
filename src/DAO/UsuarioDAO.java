package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.PreparedStatement;

import dominio.Usuario;

public class UsuarioDAO {

    private static UsuarioDAO usuarioDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

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

    // Método para hacer una consulta segura de matrícula
    public boolean anadirUsuario(Usuario usuario)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/practicas", USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (nombre, apellidos, codigo, user,  password, etapa, curso)  VALUES (?, ?, ?, ?, ?,?,?)");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setInt(3, usuario.getCodigoPostal());
            ps.setString(4, usuario.getUsuario());
            ps.setString(5, usuario.getContrasena());
            ps.setString(6, usuario.getEtapa());
            ps.setInt(7, usuario.getCurso());
            int i = ps.executeUpdate();

            con.close();
            insercionOk = true;
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Fallo en UsuarioDAO linea 55");
            System.out.println(e);
            insercionOk = false;


        } catch (SQLException e) {
            System.out.println("Fallo en UsuarioDAO linea 61");
            e.printStackTrace();
            insercionOk = false;
            //System.err.format("Mensaje SQL:  \n", e.getSQLState(),e.getMessage());
            //response.sendError(500, "Error en el acceso a la base de datos");
        } catch (ClassNotFoundException e) {
            //response.sendError(500, e.toString() );
            insercionOk = false;
            e.printStackTrace();
        }
        return insercionOk;
    }

    public boolean usuarioExiste(Usuario usuario) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/practicas", USER, PASSWORD);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE  user = ? AND password = ? ");
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


    // Cierra la conexión iniciada por la instancia de VehiculoDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }


}

