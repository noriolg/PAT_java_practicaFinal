package DAO;


import dominio.ClaseProducto;
import dominio.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ClasesOfrecidasDAO {
    private static ClasesOfrecidasDAO clasesOfrecidasDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
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
        PreparedStatement ps = con.prepareStatement("SELECT * FROM clasesofrecidas WHERE  etapa = ? order by curso, asignatura");
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
                clase = new ClaseProducto(Integer.parseInt(rs.getString("curso")), rs.getString("etapa"), rs.getString("asignatura"));
                coleccion.add(clase);
            }
            return coleccion;
        }catch(SQLException e) {
            //En el caso de que rs esté vacío se devuelve una colección vacía. Esto se comprobará en recepción
            return coleccion;
        }
    }


    // Devuelve false siya existía
    public boolean anadirClase(ClaseProducto claseProducto)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement("INSERT INTO clasesofrecidas (asignatura, curso, etapa )  VALUES (?, ?, ?)");
            ps.setString(1, claseProducto.getAsignatura());
            ps.setInt(2, claseProducto.getCurso());
            ps.setString(3, claseProducto.getEtapa());
            int i = ps.executeUpdate();

            con.close();
            insercionOk = true;
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Fallo en ClasesOfrecidasDAO linea 87");
            System.out.println(e);
            insercionOk = false;


        } catch (SQLException e) {
            System.out.println("Fallo en ClasesOfrecidasDAO linea 93");
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




    // Cierra la conexión iniciada por la instancia de VehiculoDAO
    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }

}
