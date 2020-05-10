package DAO;


import Util.Constantes;
import Util.Fecha;
import dominio.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ClasesAsignadasDAO {
    private static ClasesAsignadasDAO clasesAsignadasDAO;
    private Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = Constantes.BDPASS;
    // Date en mysql es '0000-00-00' 'YYYY-MM-DD'

    private ClasesAsignadasDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
    }

    public static ClasesAsignadasDAO getInstance() throws SQLException, ClassNotFoundException {
        if (clasesAsignadasDAO != null) {
            if (!clasesAsignadasDAO.isActiva())
                clasesAsignadasDAO = new ClasesAsignadasDAO();
        } else
            clasesAsignadasDAO = new ClasesAsignadasDAO();
        return clasesAsignadasDAO;
    }

    private boolean isActiva() throws SQLException {
        return con.isValid(0);
    }

    // Método para hacer una consulta segura de matrícula
    public boolean anadirClasesSinAsignar(Alumno alumno, Carrito carrito) {
        boolean insercionOk;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
            for (ClaseProducto c : carrito.getCarrito()) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO clasesasignadas (profesor,alumno,asignatura,descripcion ,curso,etapa,fechacompra)  VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, "null");
                ps.setString(2, alumno.getUsuario());
                ps.setString(3, c.getAsignatura());
                ps.setString(4, "null");
                ps.setString(5, Integer.toString(c.getCurso()));
                ps.setString(6, c.getEtapa());
                ps.setDate(7, Fecha.obtenerFecha());

                int i = ps.executeUpdate();
            }
            con.close();
            insercionOk = true;
        } catch (SQLIntegrityConstraintViolationException e) {
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

    public ArrayList<Clase> obtenerClasesAsignadasDeAlumno(Alumno alumno) {
        ArrayList<Clase> clases = new ArrayList<Clase>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  clasesasignadas WHERE alumno= ?");
            ps.setString(1, alumno.getUsuario());
            ResultSet rs = ps.executeQuery();
            ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
            Profesor p;
            while (rs.next()) {
                Clase c = null;
                if (rs.getString("profesor").equals("null")) {
                    c = new Clase(null, rs.getString("asignatura"), "Solicitud pendiente de asignación", rs.getString("etapa"), Integer.parseInt(rs.getString("curso")));

                } else {
                    try {
                        p = profesorDAO.obtenerProfesor(rs.getString("profesor"));
                        c = new Clase(p, rs.getString("asignatura"), "Asignada", rs.getString("etapa"), Integer.parseInt(rs.getString("curso")));

                    } catch (Exception e) {
                        e.printStackTrace();
                        ;
                    }
                }
                clases.add(c);
            }
            rs.close();
            con.close();
            return clases;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Fallo en ClasesAsignadasDAO linea 98");
            System.out.println(e);


        } catch (SQLException e) {
            System.out.println("Fallo en ClasesAsignadasDAO linea 103");
            e.printStackTrace();
            //System.err.format("Mensaje SQL:  \n", e.getSQLState(),e.getMessage());
            //response.sendError(500, "Error en el acceso a la base de datos");
        } catch (ClassNotFoundException e) {
            //respons;
            //
            //   e.sendError(500, e.toString() );
            e.printStackTrace();
        }
        return clases;
    }

    public ArrayList<Clase> obtenerClasesAsignadasDeProfesor(Profesor profesor) {
        ArrayList<Clase> clases = new ArrayList<Clase>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  clasesasignadas WHERE profesor= ?");
            ps.setString(1, profesor.getUsuario());
            ResultSet rs = ps.executeQuery();
            AlumnoDAO alumnoDAO = AlumnoDAO.getInstance();
            Alumno alu;
            while (rs.next()) {
                try {
                    alu = alumnoDAO.obtenerAlumno(rs.getString("alumno"));
                    Clase c = new Clase(alu, rs.getString("asignatura"), "Asignada", Integer.parseInt(rs.getString("curso")), rs.getString("etapa"));
                    clases.add(c);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            rs.close();
            con.close();
            return clases;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Fallo en ClasesAsignadasDAO linea 131");
            System.out.println(e);


        } catch (SQLException e) {
            System.out.println("Fallo en ClasesAsignadasDAO linea 136");
            e.printStackTrace();
            //System.err.format("Mensaje SQL:  \n", e.getSQLState(),e.getMessage());
            //response.sendError(500, "Error en el acceso a la base de datos");
        } catch (ClassNotFoundException e) {
            //respons;
            //
            //   e.sendError(500, e.toString() );
            e.printStackTrace();
        }
        return clases;
    }

    public Collection obtenerTodasClasesSinAsignar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM clasesasignadas WHERE profesor = \"null\";");
        ResultSet rs_st = ps.executeQuery();
        Collection<Clase> clases = resultSetToCollectionSinAsignar(rs_st);
        rs_st.close();
        con.close();
        return clases;
    }

    private Collection<Clase> resultSetToCollectionSinAsignar(ResultSet rs) {
        Collection<Clase> coleccion = new ArrayList<Clase>();
        try {
            while (rs.next()) {
                Clase clase = new Clase(null, rs.getString("asignatura"), null, rs.getString("etapa"), rs.getInt("curso"));
                clase.setAlumnoUser(rs.getString("alumno"));
                clase.setIdClase(rs.getInt("idclase"));
                coleccion.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coleccion;
    }


    public Collection obtenerTodasAsignadas() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM clasesasignadas WHERE profesor != \"null\";");
        ResultSet rs_st = ps.executeQuery();
        Collection<Clase> clases = resultSetToCollectionTodasAsignadas(rs_st);
        rs_st.close();
        con.close();
        return clases;
    }

    private Collection<Clase> resultSetToCollectionTodasAsignadas(ResultSet rs) throws Exception {
        Collection<Clase> coleccion = new ArrayList<Clase>();
        try {
            ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
            while (rs.next()) {
                String usuarioProfesor = rs.getString("profesor");
                Profesor profesor = profesorDAO.obtenerProfesor(usuarioProfesor);
                Clase clase = new Clase(profesor, rs.getString("asignatura"), null, rs.getString("etapa"), rs.getInt("curso"));
                clase.setAlumnoUser(rs.getString("alumno"));
                clase.setIdClase(rs.getInt("idclase"));
                coleccion.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coleccion;
    }

    public void asignarProfesorAClase(String userProf, String idclase) throws SQLException, ClassNotFoundException {
        int idClase = Integer.parseInt(idclase);
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("UPDATE clasesasignadas SET profesor = ? where idclase = ?");
        ps.setString(1, userProf);
        ps.setInt(2, idClase);
        int i = ps.executeUpdate();
        con.close();
    }


    public Collection obtenerProductosMasComprados(String fechainicio, String fechafin) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        java.sql.Date inicio=Fecha.formatoFecha(fechainicio);
        java.sql.Date fin=Fecha.formatoFecha(fechafin);
        PreparedStatement ps = con.prepareStatement("SELECT asignatura, etapa, curso, fechacompra, COUNT(*) as cantidad FROM clasesasignadas WHERE fechacompra between ? and ? GROUP BY asignatura ORDER BY cantidad DESC, etapa, curso DESC LIMIT 15");
        ps.setDate(1,inicio);
        ps.setDate(2,fin);
        ResultSet rs_st = ps.executeQuery();
        Collection<Clase> clases = resultSetToCollectionProductosAgregados(rs_st);
        rs_st.close();
        con.close();
        return clases;
    }

    public Collection obtenerDiasMasCompras() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + Constantes.BDNAME, Constantes.BDUSER,Constantes.BDPASS);
        PreparedStatement ps = con.prepareStatement("SELECT asignatura, etapa, curso,fechacompra, COUNT(*) as cantidad FROM clasesasignadas GROUP BY fechacompra ORDER BY cantidad DESC, fechacompra DESC, etapa LIMIT 15");
        ResultSet rs_st = ps.executeQuery();
        Collection<Clase> clases = resultSetToCollectionFechasAgregadas(rs_st);
        rs_st.close();
        con.close();
        return clases;
    }


    private Collection<Clase> resultSetToCollectionProductosAgregados(ResultSet rs) throws Exception {
        Collection<Clase> coleccion = new ArrayList<Clase>();
        try {
            ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
            while (rs.next()) {
                Clase clase = new Clase(null, rs.getString("asignatura"), null, rs.getString("etapa"), rs.getInt("curso"));
                clase.setFecha(rs.getString("fechacompra"));
                clase.setCantidad(rs.getInt("cantidad"));
                coleccion.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coleccion;
    }



    private Collection<Clase> resultSetToCollectionFechasAgregadas(ResultSet rs) throws Exception {
        Collection<Clase> coleccion = new ArrayList<Clase>();
        try {
            ProfesorDAO profesorDAO = ProfesorDAO.getInstance();
            while (rs.next()) {
                Clase clase = new Clase(rs.getString("fechacompra"), rs.getInt("cantidad"));
                coleccion.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coleccion;
    }

    public void close() throws SQLException, ClassNotFoundException
    {
        con.close();
    }


}
