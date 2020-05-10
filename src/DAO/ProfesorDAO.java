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
    private static final String PASSWORD = Constantes.BDPASS;
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private ProfesorDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
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

    // Estos hay que repasarlos, para ver qué queremos conseguir cuando obtenemos un alumno.
    public Profesor obtenerProfesor(Usuario usuario) throws SQLException, ClassNotFoundException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM profesores WHERE  usuario = ? AND contrasena = ? ");
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ResultSet rs = ps.executeQuery();

        int numeroResultados = 0;
        Profesor profesorObtenido  = null;
        while(rs.next()){
            // Ojo con guardar contrasena en la sesion, puede ser fallo de seguridad.
            profesorObtenido = new Profesor(rs.getString("usuario"),rs.getString("contrasena"),rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("codigo"), rs.getString("email"), rs.getString("telefono"), rs.getString("descripcion"));
            numeroResultados ++;
        }
        rs.close();

        // Si se ha obtenido más de un resultado es que hay un error en la tabla
        if(numeroResultados != 1 ){
            con.close();
            throw new Exception("Error de integridad de la base de datos. ProfesorDAO 64");
        }
        return profesorObtenido;
    }
    public Profesor obtenerProfesor(String usuario) throws SQLException, ClassNotFoundException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM profesores WHERE  usuario = ? ");
        ps.setString(1, usuario);;
        ResultSet rs = ps.executeQuery();

        int numeroResultados = 0;
        Profesor profesorObtenido  = null;
        while(rs.next()){
            // Ojo con guardar contrasena en la sesion, puede ser fallo de seguridad.
            profesorObtenido = new Profesor(rs.getString("usuario"),rs.getString("contrasena"),rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("codigo"), rs.getString("email"), rs.getString("telefono"), rs.getString("descripcion"));
            numeroResultados ++;
        }
        rs.close();
        // Si se ha obtenido más de un resultado es que hay un error en la tabla
        if(numeroResultados != 1 ){
            con.close();
            throw new Exception("Error de integridad de la base de datos. ProfesorDAO 88");
        }
        return profesorObtenido;
    }

    public boolean actualizarProfesor(Profesor profesor){
        boolean actualizacionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
            PreparedStatement ps = con.prepareStatement("UPDATE profesores SET contrasena = ?, nombre = ?, apellidos = ?, codigo = ?, email = ?, telefono = ?, descripcion = ?  where usuario = ?");
            ps.setString(1, profesor.getContrasena());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getApellidos());
            ps.setInt(4, profesor.getCodigoPostal());
            ps.setString(5, profesor.getEmail());
            ps.setString(6, profesor.getTelefono());
            ps.setString(7, profesor.getDescripcion());
            ps.setString(8, profesor.getUsuario());

            int i = ps.executeUpdate();
            con.close();
            actualizacionOk = true;
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo en ProfesorDAO linea 88");
            System.out.println(e);
            actualizacionOk = false;
        }
        return actualizacionOk;
    }


    // Devuelve true o false según sea exitosa o no la insercion en la base de datos
    public boolean anadirProfesor(Profesor profesor)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
            PreparedStatement ps = con.prepareStatement("INSERT INTO profesores (usuario, contrasena, nombre, apellidos, codigo, email, telefono, usertype)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, profesor.getUsuario());
            ps.setString(2, profesor.getContrasena());
            ps.setString(3, profesor.getNombre());
            ps.setString(4, profesor.getApellidos());
            ps.setInt(5, profesor.getCodigoPostal());
            ps.setString(6, profesor.getEmail());
            ps.setString(7, profesor.getTelefono());
            ps.setInt(8, 1);

            int i = ps.executeUpdate();
            con.close();
            insercionOk = true;
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Fallo en ProfesorDAO linea 117");
            System.out.println(e);
            insercionOk = false;


        } catch (SQLException e) {
            System.out.println("Fallo en ProfesorDAO linea 115");
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

    public Collection obtenerCollectionProfesores() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT nombre, apellidos, descripcion, usuario FROM profesores WHERE USERTYPE = 1 ORDER BY apellidos;");
        ResultSet rs_st = ps.executeQuery();
        Collection<Profesor> profesores = resultSetToCollection(rs_st);
        rs_st.close();
        con.close();
        return profesores;
    }

    private Collection<Profesor> resultSetToCollection(ResultSet rs) {
        Collection<Profesor> coleccion = new ArrayList<Profesor>();
        try {
            while (rs.next()) {
                Profesor prof = new Profesor(rs.getString("usuario"), null, rs.getString("nombre"), rs.getString("apellidos"), 1, null, null, rs.getString("descripcion"));
                coleccion.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coleccion;
    }


        // Cierra la conexión iniciada por la instancia de VehiculoDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }


}

