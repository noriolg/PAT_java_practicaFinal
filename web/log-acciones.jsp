
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="DAO.AccionDAO" %>
<%@ page import="dominio.Accion" %>
<html>
<head>
    <title>Log-Acciones</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/logacciones.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <br>
        <br><h4 style="color:#757575;">Registro de acciones (15 más recientes)</h4>
        <div class = "container-tabla">
            <table class="tabla-profesores">
                <div class = tabla-profesores-header>
                    <tr>
                        <th class="hcolumna1">Timestamp</th>
                        <th class="hcolumna2">Usertype</th>
                        <th class="hcolumna3">Evento</th>
                    </tr>
                </div>
                <div class = "tabla-profesores-body">
                    <%
                        AccionDAO accionDAO = AccionDAO.getInstance();
                        ArrayList acciones = (ArrayList) accionDAO.obtenerListaAcciones();

                        java.util.Iterator it = acciones.iterator();
                        if(acciones.isEmpty()){
                            out.println("No hay acciones disponibles.");
                        }
                        else {
                            while (it.hasNext()) {
                                Accion accion = (Accion) it.next();
                                out.println("<tr><td class = \"columna1\">" + accion.getTimestamp() + "</td><td class = \"columna2\">" + accion.getUserTypeString() + "</td> <td class = \"columna3\">" + accion.getDescripcion() + "</td></tr>");
                            }
                        }
                    %>
                </div>
            </table>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>

</body>
</html>
