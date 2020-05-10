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
    <title>Info Compras</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/info-compras.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <div class = "division-vertical">
            <br><h4 style="color:white;">Agregado por días</h4>
            <div class = "container-tabla">
                <table class="tabla">
                    <div class = tabla-header>
                        <tr>
                            <th class="hcolumna1">Día</th>
                            <th class="hcolumna2">Número compras</th>
                        </tr>
                    </div>
                    <div class = "tabla-body">
                        <c:forEach var = "dia" items = "${requestScope.diasMascompras}">
                            <tr>
                                <td class="columna11">${dia.fecha}</td>
                                <td class="columna12">${dia.cantidad}</td>
                            </tr>
                        </c:forEach>

                    </div>
                </table>
            </div>
            <form method="post"  action="GestionDashboardAdmin">
                <input class = "boton" type = "submit" value = "Volver a Dashboard Principal" style = "width: 60% !important;">
            </form>
        </div>

        <div class = "division-vertical">
            <br><h4 style="color:white;">Agregado por productos</h4>
            <div class = "container-tabla">
                <table class="tabla">
                    <div class = tabla-header>
                        <tr>
                            <th class="hcolumna1">Asignatura</th>
                            <th class="hcolumna2">Cantidad</th>
                        </tr>
                    </div>
                    <div class = "tabla-body">
                        <c:forEach var = "producto" items = "${requestScope.productosMasComprados}">
                            <tr>
                                <td class="columna21">${producto.infoAdmin}</td>
                                <td class="columna22">${producto.cantidad}</td>
                            </tr>
                        </c:forEach>
                    </div>
                </table>
            </div>
            <div>
                <form method="post" onsubmit="return validar();" action="GestorPeticionBDClasesAsignadas">
                    <label class = "label-left" for="fechainicio">Fecha inicio:</label>
                    <input type="date" name = "fechainicio" id = "fechainicio">
                    <label class = "label-right" for="fechafin">Fecha fin:</label>
                    <input type="date" name = "fechafin" id = "fechafin"><br>
                    <input class = "boton" type = "submit" value = "Aplicar Filtro">
                </form>
            </div>
        </div>

        <div>

        </div>
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>

</body>
<script src="js/info-compras.js" type="text/javascript"></script>
</html>
