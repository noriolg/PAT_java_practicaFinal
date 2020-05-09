package dominio;

public class Alumno extends Usuario {
    private String nombre;
    private String apellidos;
    private int codigoPostal;
    private String email;
    private String telefono;
    private String etapa;
    private int curso;


    // Constructor general
    public Alumno(String usuario, String contrasena, String nombre, String apellidos, int codigoPostal, String email, String telefono, String etapa, int curso ){
        super(usuario,contrasena);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
        this.etapa = etapa;
        this.curso = curso;
    }

    public Alumno(String usuario, String contrasena){
        super(usuario,contrasena);
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

    public String toString(){
        return "Alumno: " + nombre + " " + apellidos + " Usuario: " + super.getUsuario();
    }

     public String mostrarInfo(){
        return "Alumno: " + nombre + " " + apellidos + "\nUsuario: " + super.getUsuario()+
                "\nTeléfono: " + this.telefono + "\nEtapa: " + this.etapa+ "\nCurso: "+ this.curso
                + "\nCódigo Postal: " +this.codigoPostal+ "\nE-mail: " + this.email;
    }
}
