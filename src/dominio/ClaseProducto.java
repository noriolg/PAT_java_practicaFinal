package dominio;

public class ClaseProducto {
    protected int curso;
    protected String etapa;
    protected String asignatura;

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

    public String mostrarClaseCesta() {
        return this.curso+"º " + this.asignatura;
    }
    @Override
    public String toString(){ ;
            return  "\nClase: "+ this.asignatura+ " "+ this.curso+"º de "+this.etapa;
    }
}
