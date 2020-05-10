package Util;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Fecha {
    public static java.sql.Date obtenerFecha()
    {
        LocalDate fecha=LocalDate.now();
        java.sql.Date fechasql=java.sql.Date.valueOf(fecha);
        return fechasql;
    }
    public static  java.sql.Date formatoFecha(String fecha){
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        return fechasql;
    }
}
