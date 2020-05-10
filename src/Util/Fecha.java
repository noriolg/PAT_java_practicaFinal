package Util;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
public class Fecha {
    public static java.sql.Date obtenerFecha()
    {
        LocalDate fecha=LocalDate.now();
        java.sql.Date fechasql=java.sql.Date.valueOf(fecha);
        return fechasql;
    }
    public static  java.sql.Date formatoFecha(Date fecha){
        java.sql.Date fechasql=new java.sql.Date(fecha);
        return fechasql;
    }
}
