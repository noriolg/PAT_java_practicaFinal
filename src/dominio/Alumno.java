package dominio;

public class Alumno {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private int codigoPostal;
    private String email;
    private String telefono;
    private String etapa;
    private int curso;
    private String clase;


    // Constructor general
    public Alumno(String usuario, String contrasena, String nombre, String apellidos, int codigoPostal, String email, String telefono, String etapa, int curso, String clase ){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
        this.etapa = etapa;
        this.curso = curso;
        this.clase = clase;
    }

    public Alumno(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Alumno(String usuario, String contrasena, String nombre, String apellidos, int codigoPostal, String email, String telefono, String etapa, int curso){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
        this.etapa = etapa;
        this.curso = curso;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
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

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEtapa() {
        return etapa;
    }

    public int getCurso() {
        return curso;
    }

    public String getClase() {
        return clase;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
