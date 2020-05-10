package dominio;

public class ProductoAgregado {

    protected String asignatura;
    protected int cantidad;

    public ProductoAgregado(String asignatura, String etapa, String curso, int cantidad) {
        this.asignatura = asignatura + " " + curso + "º " + etapa;
        this.cantidad = cantidad;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
