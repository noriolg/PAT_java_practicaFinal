<%@page import="dominio.Profesor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>
    <title>Profesores</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/profesores.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <%--
        <sql:setDataSource var = "db" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost/icarus"
                           user = "root"  password = "root"/>
        <sql:query dataSource = "${db}" var = "result">
            SELECT nombre, apellidos, descripcion FROM profesores WHERE USERTYPE = 1 ORDER BY apellidos;
        </sql:query>
        --%>
        <br><h4 style="color:#757575;">Estos son nuestros profesores...</h4>
        <div class = "container-tabla">
            <table class="tabla-profesores">
                <div class = tabla-profesores-header>
                    <tr>
                        <th class="hcolumna1">Apellidos</th>
                        <th class="hcolumna2">Nombre</th>
                        <th class="hcolumna3">Descripción</th>
                    </tr>
                </div>
                <div class = "tabla-profesores-body">
                    <c:forEach var = "profe" items = "${requestScope.listaProfesores}">
                        <tr>
                            <td class="columna1">${profe.apellidos}</td>
                            <td class="columna2">${profe.nombre}</td>
                            <td class="columna3">${profe.descripcion}</td>
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
