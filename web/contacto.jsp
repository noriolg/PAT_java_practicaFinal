<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carsa
  Date: 02/05/2020
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacto</title>
    <link rel="stylesheet" href="css/contacto.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <script defer src="js/contacto.js" type="text/javascript"></script>
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <img class="ola" src="images/wave.png">
        <div class="imagen">
            <embed src="images/contacto.svg">
        </div>
        <h1>Contáctenos</h1>
        <div class="mensaje-OK">
            <c:if test="${not empty mensajeSatisfactorio}">
                ${mensajeSatisfactorio}
            </c:if>
        </div>
        <div id="mensaje-error">
            <c:if test="${not empty mensajeError}">
                ${mensajeError}
            </c:if>
        </div>
        <div class="border"></div>
        <form class="contact-form" action="Mail" method="post">
            <input type="text" class="form-contacto" id="nombre" name="nombre" placeholder="Nombre y apellidos">
            <input type="email" class="form-contacto" id="mail" name="mail" placeholder="ejemplo@ejemplo.com">
            <input type="text" class="form-contacto" id="telefono" name="telefono" placeholder="Teléfono">
            <textarea class="form-contacto" name="mensaje" id="mensaje" placeholder="Mensaje"></textarea>
            <input type="submit" class="form-submit" id="enviar" name="enviar" value="Enviar">
        </form>
    </div>

    <div class = "footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
