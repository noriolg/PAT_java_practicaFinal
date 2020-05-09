package servlets;

import DAO.ClasesOfrecidasDAO;
import Servicios.CarritoServicio;
import Util.StringFormatter;
import dominio.ClaseProducto;
import dominio.ClaseProductoUniversitaria;
import sun.nio.cs.ISO_8859_2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class GestorClasesProducto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String submit=request.getParameter("submit");
        HttpSession session=request.getSession();
        ArrayList <ClaseProducto> clases=new ArrayList<ClaseProducto>();
        try{
            if(submit.equals("Agregar a la cesta") && ((String)session.getAttribute("etapa")).equals("Universidad") ){
                String asignatura= StringFormatter.formatString(request.getParameter("asignatura")) ;
                String mensaje=request.getParameter("mensajesasig");
                System.out.println(mensaje);
                ClaseProductoUniversitaria cu=new ClaseProductoUniversitaria(asignatura,mensaje);
                new CarritoServicio(request).comprar((ClaseProducto) cu);
                RequestDispatcher rd=request.getRequestDispatcher("mostrarclases");
                request.setAttribute("mensajeCesta","Se ha agregado la clase correctamente a la cesta");
                rd.forward(request,response);
            }
            else if(submit.equals("Agregar a la cesta")){
                String asignatura=StringFormatter.formatString((request.getParameter("valor").substring(3)));
                String curso=Character.toString((request.getParameter("valor").charAt(0)));
                String etapa=(String) session.getAttribute("etapa");
                new CarritoServicio(request).comprar(new ClaseProducto(Integer.parseInt(curso),etapa,asignatura));
                RequestDispatcher rd=request.getRequestDispatcher("mostrarclases");
                request.setAttribute("mensajeCesta","Se ha agregado la clase correctamente a la cesta");
                rd.forward(request,response);
            }else if(submit.equals("Vaciar"))
            {
                new CarritoServicio(request).vaciar();
                response.sendRedirect("clases");
            }else if(submit.equals("Universidad")){
                session.setAttribute("etapa","Universidad");
                response.sendRedirect("mostrarclases");
            }
            else{
                    ClasesOfrecidasDAO clasesDao = ClasesOfrecidasDAO.getInstance();
                    clases=clasesDao.obtenerClases(submit);
                    session.setAttribute("etapa",submit);
                    session.setAttribute("Clases",clases);
                    response.sendRedirect("mostrarclases");
            }

        }catch (Exception e){
            System.out.println("Error en Gestion Producto");
            e.printStackTrace();;
        }
    }
}
