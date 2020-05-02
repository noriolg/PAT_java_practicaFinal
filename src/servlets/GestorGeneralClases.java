/**
package servlets;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.*;

import negocio.OperacionClases;


// Todas las llamadas desde y hacia zona-clases.jsp son gestionadas por este controlador y repartidas
// entre distintas clases ejecutoras
public class GestorGeneralClases extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Esta es la siguiente vista por defencto
        String jspDestino = "/zona-clases.jsp"; // vista por defecto

        // Objeto encargado de la lógica de las distintas acciones
        OperacionClases operacionClases = new OperacionClases();

        try{
            // Se coge el nombre de la acción a realizar
            String opcionEscogida = request.getParameter("opcion_accion_name");

            if(opcionEscogida!=null)
            {
                if(opcionEscogida.equals("anadir")){
                    gestionarCompra(request, operacionClases);
                    jspDestino = "/zona-clases.jsp";
                }
                else if(opcionEscogida.equals("vaciar")){
                    gestionarVaciado(request, operacionClases);
                    jspDestino = "/zona-clases.jsp";
                }
                else if(opcionEscogida.equals("finalizar")){
                    //gestionarFinCompra(request, operacionComercial);
                    jspDestino = "/fin_compra.jsp";
                }
            }else
            {
                // Si la opción es null, significa que viene de index. Se crea un atributo de sesion llamado carrito
                request.getSession().setAttribute("carrito", new Carrito( new HashMap<String,Integer>() ) );
            }


        }
        catch (Exception e){
            System.out.println("Error en GestorCompra");
            System.out.println(e);
            e.printStackTrace();
        }

        request.getRequestDispatcher(jspDestino).forward(request, response);
    }


    private void gestionarCompra(HttpServletRequest request, OperacionComercial operacionComercial){

        // Por ahora este, se quieren añadir simplemente en un hasmap. Cuando se quieran añadir en un
        // objeto carrito, se usará la opción de obtener el id
        String libroParaAnadir;
        try{
            libroParaAnadir = request.getParameter("opciones_libros_name");
            byte[] libroParaAnadirBytes = libroParaAnadir.getBytes(ISO_8859_1);
            libroParaAnadir = new String(libroParaAnadirBytes, UTF_8);
        }catch (NullPointerException e)
        {
            libroParaAnadir = "";
        }

        // Cantidad de libros a anadir
        int cantidad = Integer.parseInt(request.getParameter("form_compra_cantidad_name"));
        operacionComercial.comprarProducto(libroParaAnadir, cantidad);


        // Esto se mantiene aquí para cuando se quiera la opción de un objeto Carrito
        //int idLibroParaAnadir = Integer.parseInt(request.getParameter("opciones_libros_name"));
    }

    private void gestionarVaciado(HttpServletRequest request, OperacionComercial operacionComercial){
        operacionComercial.vaciarCarrito();
    }


    /**
     private void gestionarFinCompra(HttpServletRequest request, OperacionComercial operacionComercial){
     //operacionComercial(request).vaciar();
     }**/
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
**/

/**
 *              opcionEscogida es una string con caracteres raros
 *             byte[] opcionEscogidaBytes = opcionEscogida.getBytes(ISO_8859_1);
 *             opcionEscogida = new String(opcionEscogidaBytes, UTF_8);
 **/


