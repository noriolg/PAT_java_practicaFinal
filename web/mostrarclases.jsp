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
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <script defer src="js/mostrarclases.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/mostrarclases.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="imagen">
        <img src="images/Clases.svg">
    </div>
    <div class="contenido">
        <c:choose>
            <c:when test="${etapa!='Universidad'}">
                <h1>${etapa}</h1>
                <input type="text" id="myInput" onkeyup="Filtro()" placeholder="Busque sus clases.." >
                <div class="contenedor">
                    <ul class="lista" id="lista">
                        <c:forEach var="entry" items="${sessionScope.Clases}" >
                            <li class="clase"><a href="javascript:void(0)">${entry.mostrarClaseCesta()}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <form  id="enviar" action="GestorClasesProducto" method="post">
                    <input name="submit" id="submitClase" class="submit" type="submit" value="Agregar a la cesta">
                    <input name="valor" id="oculto" type="hidden">
                    <input name="user" id="oculto3" type="hidden" value="${acceso}">
                    <div id="mensaje">
                        <c:if test="${not empty requestScope.mensajeCesta}">
                            <div id="mensajeCesta" class="mensajeCesta">
                                    ${mensajeCesta}
                            </div>
                        </c:if>
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <div class="border">
                    <h1>Universidad</h1>
                    <form id="contact-form" class="contact-form" action="GestorClasesProducto" method="post">
                        <input type="text" class="form-contacto" id="asignatura" name="asignatura" placeholder="Asignatura">
                        <textarea name="mensajeasig" id="mensajeasig" class="form-contacto"  form="contact-form" placeholder="Descripción"></textarea>
                        <input name="submit" type="submit"  class="form-submit" id="universidadEnviar"  value="Agregar a la cesta">
                        <input name="user" id="ocultouni" type="hidden" value="${acceso}">
                        <div id="mensaje">
                            <c:if test="${not empty requestScope.mensajeCesta}">
                                <div id="mensajeCesta" class="mensajeCesta">
                                        ${mensajeCesta}
                                </div>
                            </c:if>
                        </div>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
