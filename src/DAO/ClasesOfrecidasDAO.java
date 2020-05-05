package DAO;


import dominio.ClaseProducto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ClasesOfrecidasDAO {
    private static ClasesOfrecidasDAO clasesOfrecidasDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = "icai";
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private ClasesOfrecidasDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
    }

    public static ClasesOfrecidasDAO getInstance() throws SQLException, ClassNotFoundException
    {
        if(clasesOfrecidasDAO!=null)
        {
            if(!clasesOfrecidasDAO.isActiva())
                clasesOfrecidasDAO = new ClasesOfrecidasDAO();
        }
        else
            clasesOfrecidasDAO = new ClasesOfrecidasDAO();
        return clasesOfrecidasDAO;
    }

    private boolean isActiva() throws SQLException
    {
        return con.isValid(0);
    }

    public ArrayList<ClaseProducto> obtenerClases(String etapa) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM clasesofrecidas WHERE  etapa = ?");
        ps.setString(1, etapa);
        ResultSet rs = ps.executeQuery();
        ArrayList<ClaseProducto> clases = resultSetToCollection(rs);
        rs.close();
        con.close();
        return clases;
    }

    // Recorre el resultset y devuelve una colección de Vehículos
    private ArrayList<ClaseProducto> resultSetToCollection(ResultSet rs){
        ArrayList<ClaseProducto> coleccion = new ArrayList<ClaseProducto>();
        try {
            while(rs.next())
            {
                ClaseProducto clase;
                clase = new ClaseProducto(Integer.parseInt(rs.getString(1)), rs.getString(3), rs.getString(4));
                coleccion.add(clase);
            }
            return coleccion;
        }catch(SQLException e) {
            //En el caso de que rs esté vacío se devuelve una colección vacía. Esto se comprobará en recepción
            return coleccion;
        }
    }




    // Cierra la conexión iniciada por la instancia de VehiculoDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }

}
