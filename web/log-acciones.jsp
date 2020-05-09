<%@page import="dominio.Accion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>


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
                    <c:forEach var = "accion" items = "${requestScope.listaAcciones}">
                        <tr>
                            <td class="columna1">${accion.timestamp}</td>
                            <td class="columna2">${accion.userTypeString}</td>
                            <td class="columna3">${accion.descripcion}</td>
                        </tr>
                    </c:forEach>

                </div>
            </table>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>

</body>
</html>
