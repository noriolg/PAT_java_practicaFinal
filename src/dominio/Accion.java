package dominio;


import Util.Constantes;

import java.sql.Timestamp;

public class Accion {
    private int userType;
    private String descripcion;
    private Timestamp timestamp;

    public Accion(int userType, String descripcion){
        this.userType = userType;
        this.descripcion = descripcion;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Accion(Timestamp timestamp, int userType, String descripcion){
        this.userType = userType;
        this.descripcion = descripcion;
        this.timestamp = timestamp;
    }

    public int getUserType() {
        return userType;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getUserTypeString(){
        String tipoUsuario;
        if (userType == Constantes.ALUMNO){
            tipoUsuario = "Alumno    [0]";
        }else if(userType == Constantes.PROFESOR){
            tipoUsuario = "Profesor  [1]";
        }
        else{
            tipoUsuario = "Administ. [2]";
        }
        return tipoUsuario;
    }
}
