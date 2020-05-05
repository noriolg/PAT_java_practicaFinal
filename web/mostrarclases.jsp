<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carsa
  Date: 04/05/2020
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ClasesOfrecidas</title>
    <script defer src="js/mostrarclases.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/mostrarclases.css">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="imagen">
        <img src="images/Clases.svg">
    </div>
    <div class="contenido">
        <div id="mensaje"></div>
        <input type="text" id="myInput" onkeyup="Filtro()" placeholder="Busque sus clases.." >
        <div class="contenedor">
            <ul class="lista" id="lista">
                <c:forEach var="entry" items="${sessionScope.Clases}" >
                    <li class="clase"><a href="javascript:void(0)">${entry.toString()}</a></li>
                </c:forEach>
            </ul>
        </div>
        <form  id="enviar" action="GestorClasesProducto" method="post">
            <input name="submit" id="submitClase" class="submit" type="submit" value="Agregar a la cesta">
            <input name="valor" id="oculto" type="hidden">
            <input name="etapa" id="oculto2" type="hidden" value="${etapa}">
            <input name="user" id="oculto3" type="hidden" value="${acceso}">
        </form>
        <div class="footer">
            <jsp:include page="/footer" />
        </div>
    </div>
</body>
</html>
