
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
        <sql:setDataSource var = "db" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost/icarus"
                           user = "root"  password = "root"/>
        <sql:query dataSource = "${db}" var = "result">
            SELECT nombre, apellidos, descripcion FROM profesores WHERE ADMIN = 1 ORDER BY apellidos;
        </sql:query>

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
                    <c:forEach var = "row" items = "${result.rows}">
                        <tr>
                            <td class="columna1">${row.apellidos}</td>
                            <td class="columna2">${row.nombre}</td>
                            <td class="columna3">${row.descripcion}</td>
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
