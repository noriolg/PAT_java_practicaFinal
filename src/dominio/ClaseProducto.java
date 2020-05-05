package dominio;

public class ClaseProducto {
    private int curso;
    private String etapa;
    private String asignatura;

    public ClaseProducto(int curso, String etapa, String asignatura) {
        this.curso = curso;
        this.etapa = etapa;
        this.asignatura = asignatura;
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

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return this.curso+"º " + this.asignatura;
    }
    public String mostrarClaseCesta(){
        return this.asignatura+ " "+ this.curso+"º "+this.etapa;
    }
}
