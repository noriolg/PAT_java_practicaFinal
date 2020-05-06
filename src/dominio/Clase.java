package dominio;

public class Clase {
    private String profesorUser;
    private String alumnoUser;
    private String asignatura;
    private String descripcion;
    private int curso;
    private String etapa;


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

    public Clase( String profesorUser, String alumnoUser, String asignatura, String descripcion, int curso, String etapa) {
        this.profesorUser = profesorUser;
        this.alumnoUser = alumnoUser;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.curso = curso;
        this.etapa = etapa;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
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
