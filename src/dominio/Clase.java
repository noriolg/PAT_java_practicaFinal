package dominio;

public class Clase {
    private int idClase;
    private String profesorUser;
    private String alumnoUser;
    private String asignatura;
    private String descripcion;

    public Clase(String profesorUser, String alumnoUser, String asignatura, String descripcion){
        this.profesorUser = profesorUser;
        this.alumnoUser = alumnoUser;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
    }

    public Clase(String profesorUser, String alumnoUser, String asignatura){
        this.profesorUser = profesorUser;
        this.alumnoUser = alumnoUser;
        this.asignatura = asignatura;
    }

    public int getIdClase() {
        return idClase;
    }

    public String getProfesorUser() {
        return profesorUser;
    }

    public String getAlumnoUser() {
        return alumnoUser;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public void setProfesorUser(String profesorUser) {
        this.profesorUser = profesorUser;
    }

    public void setAlumnoUser(String alumnoUser) {
        this.alumnoUser = alumnoUser;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
