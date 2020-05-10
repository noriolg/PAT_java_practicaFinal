package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.PreparedStatement;

import Util.Constantes;
import dominio.Accion;
import dominio.Alumno;


public class AccionDAO {

    private static AccionDAO accionDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = Constantes.BDPASS;
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private AccionDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, USER, PASSWORD);
    }

    public static AccionDAO getInstance() throws SQLException, ClassNotFoundException
    {
        if(accionDAO!=null)
        {
            if(!accionDAO.isActiva())
                accionDAO = new AccionDAO();
        }
        else
            accionDAO = new AccionDAO();
        return accionDAO;
    }

    private boolean isActiva() throws SQLException
    {
        return con.isValid(0);
    }

    // Método para hacer una consulta segura de matrícula
    public boolean anadirAccion(Accion accion)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
            PreparedStatement ps = con.prepareStatement("INSERT INTO log (timestamp , usertype, descripcion)  VALUES (?, ?, ?)");
            ps.setString(1, accion.getTimestamp().toString());
            ps.setInt(2, accion.getUserType());
            ps.setString(3, accion.getDescripcion());
            int i = ps.executeUpdate();

            con.close();
            insercionOk = true;
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Fallo en AccionDAO linea 60");
            System.out.println(e);
            insercionOk = false;


        } catch (SQLException e) {
            System.out.println("Fallo en AccionDAO linea 66");
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

    public Collection<Accion> obtenerCollectionAcciones() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM log ORDER BY timestamp DESC LIMIT 15");
        ResultSet rs = ps.executeQuery();
        Collection<Accion> acciones = resultSetToCollection(rs);
        rs.close();
        con.close();
        return acciones;
    }

    // Recorre el resultset y devuelve una colección de Vehículos
    private Collection<Accion> resultSetToCollection(ResultSet rs){
        Collection<Accion> acciones = new ArrayList<Accion>();
        try {
            while(rs.next())
            {
                Accion accion;
                accion = new Accion(rs.getTimestamp(2), rs.getInt("usertype"), rs.getString("descripcion"));
                acciones.add(accion);
            }
            return acciones;
        }catch(SQLException e) {
            //En el caso de que rs esté vacío se devuelve una colección vacía. Esto se comprobará en recepción
            return acciones;
        }
    }



    // Cierra la conexión iniciada por la instancia de AccionDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }

}


