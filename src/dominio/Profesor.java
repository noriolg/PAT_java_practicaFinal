package dominio;

public class Profesor extends Usuario { ;
    private String nombre;
    private String apellidos;
    private int codigoPostal;
    private String email;
    private String telefono;
    private String descripcion;


    // Constructor general
    public Profesor(String usuario, String contrasena, String nombre, String apellidos, int codigoPostal, String email, String telefono, String descripcion ){
        super(usuario,contrasena);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }


    public Profesor(String usuario, String contrasena){
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


    public String getDescripcion() {
        return descripcion;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString(){
        return "Profesor: " + nombre + " " + apellidos + " Usuario: " +super.getUsuario();
    }

}
