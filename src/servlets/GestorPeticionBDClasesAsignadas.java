package servlets;

import DAO.AccionDAO;
import DAO.ClasesAsignadasDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class GestorPeticionBDClasesAsignadas extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            String fechaInicio = (String)request.getParameter("fechainicio");
            String fechaFin = (String)request.getParameter("fechafin");

            // Solo es null si ambas son null
            if (fechaInicio == null){
                fechaInicio = "2020-01-01";
                fechaFin = "2020-12-31";
            }

            ClasesAsignadasDAO clasesDAO = ClasesAsignadasDAO.getInstance();
            ArrayList productosMasComprados = (ArrayList) clasesDAO.obtenerProductosMasComprados(fechaInicio, fechaFin);
            request.setAttribute("productosMasComprados", productosMasComprados);

            ArrayList diasMasCompras = (ArrayList) clasesDAO.obtenerDiasMasCompras();
            request.setAttribute("diasMascompras", diasMasCompras);

            request.getRequestDispatcher("info-compras").forward(request,response);
        }

        catch(Exception e)
        {
            System.out.println("Error en GestorPeticionClasesAsignadas 33");
            e.printStackTrace();;
        }
    }

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
