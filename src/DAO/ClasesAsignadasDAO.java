package DAO;


import dominio.Alumno;
import dominio.Carrito;
import dominio.ClaseProducto;
import dominio.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ClasesAsignadasDAO {
    private static ClasesAsignadasDAO clasesAsignadasDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = "icai";
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private ClasesAsignadasDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
    }

    public static ClasesAsignadasDAO getInstance() throws SQLException, ClassNotFoundException
    {
        if(clasesAsignadasDAO!=null)
        {
            if(!clasesAsignadasDAO.isActiva())
                clasesAsignadasDAO = new ClasesAsignadasDAO();
        }
        else
            clasesAsignadasDAO = new ClasesAsignadasDAO();
        return clasesAsignadasDAO;
    }

    private boolean isActiva() throws SQLException
    {
        return con.isValid(0);
    }

    // Método para hacer una consulta segura de matrícula
    public boolean anadirClasesSinAsignar(Alumno alumno, Carrito carrito)
    {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icarus", USER, PASSWORD);
            for (ClaseProducto c:carrito.getCarrito())
            {
                PreparedStatement ps = con.prepareStatement("INSERT INTO clasesasignadas (profesor,alumno,asignatura,descripcion ,curso,etapa)  VALUES (?,?,?,?,?,?)");
                ps.setString(1, "null");
                ps.setString(2, alumno.getUsuario());
                ps.setString(3, c.getAsignatura());
                ps.setString(4, "null");
                ps.setString(5, Integer.toString(c.getCurso()));
                ps.setString(6, c.getEtapa());

                int i = ps.executeUpdate();
            }
            con.close();
            insercionOk = true;
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Fallo en ClasesAsignadasDAO linea 57");
            System.out.println(e);
            insercionOk = false;


        } catch (SQLException e) {
            System.out.println("Fallo en ClasesAsignadasDAO linea 61");
            e.printStackTrace();
            insercionOk = false;
            //System.err.format("Mensaje SQL:  \n", e.getSQLState(),e.getMessage());
            //response.sendError(500, "Error en el acceso a la base de datos");
        } catch (ClassNotFoundException e) {
            //respons;
            //
            //   e.sendError(500, e.toString() );
            insercionOk = false;
            e.printStackTrace();
        }
        return insercionOk;
    }

    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }

}
