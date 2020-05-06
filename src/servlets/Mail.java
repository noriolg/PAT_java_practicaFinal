package servlets;

import Util.EmailUtility;
import dominio.Alumno;
import dominio.Carrito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Mail extends javax.servlet.http.HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destinatario = request.getParameter("mail");
        String asunto = "Notificación academia Ícaro";
        String mensaje = request.getParameter("mensaje");
        String nombre = request.getParameter("nombre");
        String telefono=request.getParameter("telefono");
        String submit=request.getParameter("submit");
        String mensaje_autogenerado="Se ha recibido su mensaje. Nos pondremos en contacto lo antes posible\n Atentamente,\n El equipo de Ícaro";
        try {
            if(submit.equals("Enviar")){
                EmailUtility.sendEmailAutogenerado(host, port, user, pass,destinatario, asunto,
                        mensaje_autogenerado);
                EmailUtility.sendEmailContacto(host, port, user, pass,user, asunto,
                        mensaje,telefono,nombre);
                request.setAttribute("mensajeSatisfactorio","El e-mail se envió correctamente");
                RequestDispatcher rd= request.getRequestDispatcher("contacto");
                rd.forward(request,response);
            }else{
                HttpSession session=request.getSession();
                Alumno usuario=(Alumno) session.getAttribute("objetoAlumno");
                Carrito carrito=(Carrito) session.getAttribute("carrito");
                String mensajeClase=usuario.mostrarInfo()+ "\n Ha solicitado: \n" +carrito.toString();
                EmailUtility.sendEmailClases(host,port,user,pass,asunto,mensajeClase);
                EmailUtility.sendEmailAutogenerado(host, port, user, pass,usuario.getEmail(), asunto,
                        mensaje_autogenerado);
                response.sendRedirect("finalizarcompra");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensajeError","Se ha producido un error");
            RequestDispatcher rd= request.getRequestDispatcher("contacto");
            rd.forward(request,response);

        }
    }

}
