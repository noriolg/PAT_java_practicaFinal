package dominio;

public class Usuario {
    private String usuario;
    private String contrasena;
    private int flagProfesor;

    public Usuario(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getFlagProfesor() {
        return flagProfesor;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void ascenderAProfesor(){
        this.flagProfesor = 1;
    }

    public void descenderAAlumno(){
        this.flagProfesor = 0;
    }



}
