package dominio;

public class ClaseProductoUniversitaria extends ClaseProducto{
    private String descripcion;

    public ClaseProductoUniversitaria(String asignatura, String descripcion) {
        super(0,"Universidad",asignatura);
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String mostrarClaseCesta() {
        return "\nClase Universitaria: " +
                this.asignatura+"\nDescripción: "+  this.descripcion;
    }
    @Override
    public String toString() {
        return "Clase Universitaria: " + this.asignatura;
    }
}
