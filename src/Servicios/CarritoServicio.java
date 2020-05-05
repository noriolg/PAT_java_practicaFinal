package Servicios;

import dominio.Carrito;
import dominio.ClaseProducto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CarritoServicio {
    private HttpServletRequest request;
    private Carrito carrito;

    public CarritoServicio(HttpServletRequest request) {
        this.request = request;
        carrito = this.getCarrito();
    }

    public Carrito getCarrito() {
        HttpSession sesion = request.getSession();
        carrito = (Carrito) sesion.getAttribute("carrito");

        if (carrito == null) {
            carrito = new Carrito();
            sesion.setAttribute("carrito", carrito);
        }

        return carrito;
    }
    public void comprar(ClaseProducto c)
    {

        this.getCarrito().addClase(c);
    }
    public void vaciar()
    {

        this.getCarrito().clear();
    }
}
