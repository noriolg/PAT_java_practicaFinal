package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.PreparedStatement;

import Util.Constantes;
import dominio.Alumno;
import dominio.Profesor;
import dominio.Usuario;

public class ProfesorDAO {

    private static ProfesorDAO profesorDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = "icai";
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private ProfesorDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
    }

    public static ProfesorDAO getInstance() throws SQLException, ClassNotFoundException
    {
        if(profesorDAO!=null)
        {
            if(!profesorDAO.isActiva())
                profesorDAO = new ProfesorDAO();
        }
        else
            profesorDAO = new ProfesorDAO();
        return profesorDAO;
    }

    private boolean isActiva() throws SQLException
    {
        return con.isValid(0);
    }

    // Método para hacer una consulta segura de matrícula
    public boolean anadirProfesor(Profesor profesor)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement("INSERT INTO profesores (usuario, contrasena, nombre, apellidos, codigo, email, telefono, descripcion)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, profesor.getUsuario());
            ps.setString(2, profesor.getContrasena());
            ps.setString(3, profesor.getNombre());
            ps.setString(4, profesor.getApellidos());
            ps.setInt(5, profesor.getCodigoPostal());
            ps.setString(6, profesor.getEmail());
            ps.setString(7, profesor.getTelefono());
            ps.setString(8, profesor.getDescripcion());

            int i = ps.executeUpdate();
            con.close();
            insercionOk = true;
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Fallo en AlumnoDAO linea 57");
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

    // Estos hay que repasarlos, para ver qué queremos conseguir cuando obtenemos un alumno.
    public Profesor obtenerProfesor(Usuario usuario) throws SQLException, ClassNotFoundException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM profesores WHERE  usuario = ? AND contrasena = ? ");
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ResultSet rs = ps.executeQuery();

        int numeroResultados = 0;
        Profesor profesorObtenido  = null;
        while(rs.next()){
            profesorObtenido = new Profesor(rs.getString("usuario"),null,rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("codigo"), rs.getString("email"), rs.getString("telefono"), null, rs.getString("descripcion"));
            numeroResultados ++;
        }
        rs.close();

        // Si se ha obtenido más de un resultado es que hay un error en la tabla
        if(numeroResultados != 1 ){
            con.close();
            throw new Exception("Error de integridad de la base de datos. profesorDAO 104");
        }
        return profesorObtenido;
    }

    // Recorre el resultset y devuelve una colección de Profesores
    /*
    private Collection<Alumno> resultSetToCollection(ResultSet rs){
        Collection<Alumno> coleccion = new ArrayList<Alumno>();
        try {
            while(rs.next())
            {
                Alumno alu;
                alu = new Alumno(rs.getString(1), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                coleccion.add(alu);
            }
            return coleccion;
        }catch(SQLException e) {
            //En el caso de que rs esté vacío se devuelve una colección vacía. Esto se comprobará en recepción
            return coleccion;
        }
    }
    */

    // Cierra la conexión iniciada por la instancia de VehiculoDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }


}

