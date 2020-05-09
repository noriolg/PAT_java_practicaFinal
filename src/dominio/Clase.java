package dominio;

public class Clase {
    private Profesor profesorUser;
    private Alumno alumnoUser;
    private String asignatura;
    private String descripcion;
    private int curso;
    private String etapa;


    public Clase(Alumno alumnoUser, String asignatura, String descripcion, int curso, String etapa) {
        this.alumnoUser = alumnoUser;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.curso = curso;
        this.etapa = etapa;
    }
    public Clase( Profesor profesorUser, String asignatura, String descripcion,String etapa, int curso) {
        this.profesorUser = profesorUser;
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

    public Profesor getProfesorUser() {
        return this.profesorUser;
    }


    public Alumno getAlumnoUser() {
        return this.alumnoUser;
    }

    public String getAsignatura() {
        return this.asignatura;
    }

    public String getDescripcion() {
        return this.descripcion;
    }


    public void setProfesorUser(Profesor profesorUser) {
        this.profesorUser = profesorUser;
    }

    public void setAlumnoUser(Alumno alumnoUser) {
        this.alumnoUser = alumnoUser;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
