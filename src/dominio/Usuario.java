package dominio;

public class Usuario {
    private String nombre;
    private String apellidos;
    private int codigoPostal;

    private String usuario;
    private String contrasena;
    private String etapa;
    private int curso;


    // Constructor general
    public Usuario(String nombre, String apellidos, int codigoPostal, String usuario, String contrasena, String etapa, int curso ){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoPostal = codigoPostal;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.etapa = etapa;
        this.curso = curso;
    }

    // Constructor para comprobar si existe
    public Usuario(String user, String password){
        this.setUsuario(user);
        this.setContrasena(password);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEtapa() {
        return etapa;
    }

    public int getCurso() {
        return curso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

}
