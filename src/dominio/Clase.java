package dominio;

public class Clase {
    private String profesorUser;
    private String alumnoUser;

    private Profesor profesor;
    private Alumno alumno;

    private String asignatura;
    private String descripcion;
    private int curso;
    private String etapa;

    private int idClase;


    public Clase(Alumno alumno, String asignatura, String descripcion, int curso, String etapa) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.curso = curso;
        this.etapa = etapa;
        this.setAlumnoUser(alumno.getUsuario());
    }
    public Clase( Profesor profesor, String asignatura, String descripcion,String etapa, int curso) {
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.curso = curso;
        this.etapa = etapa;
        if (profesor != null){
            this.setProfesorUser(profesor.getUsuario());
        }else{
            this.setProfesorUser("null");
        }
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

    public Profesor getProfesor() {
        return this.profesor;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public String getAlumnoUser() {
        return alumnoUser;
    }

    public String getProfesorUser() {
        return profesorUser;
    }

    public String getAsignatura() {
        return this.asignatura;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setProfesor(Profesor profesorUser) {
        this.profesor = profesor;
    }

    public void setAlumno(Alumno alumnoUser) {
        this.alumno = alumno;
    }

    public void setAlumnoUser(String alumnoUser) {
        this.alumnoUser = alumnoUser;
    }

    public void setProfesorUser(String profesorUser) {
        this.profesorUser = profesorUser;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }
}
