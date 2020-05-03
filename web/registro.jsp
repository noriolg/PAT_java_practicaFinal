<%--
  Created by IntelliJ IDEA.
  User: carsa
  Date: 30/04/2020
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/registro.css">
    <script defer src="js/registro.js" type="text/javascript"></script>
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <h2>Registrarse</h2>
        <div id="mensaje"></div>
        <form method="post" action="Registro" >
            <input id="nombre" name="nombre" type="text" placeholder="Nombre" class="formulario">
            <input id="apellidos" name="apellidos" type="text" placeholder="Apellidos"class="formulario">
            <input id="CP" name="CP" type="number" placeholder="Código Postal" minlength="5" maxlength="5" class="formulario">
            <input id="usuario" name="usuario" type="text" placeholder="Usuario" class="formulario">
            <input id="contrasena" name="contrasena" type="password" placeholder="Contraseña" class="formulario">
            <input id="telefono" name="telefono" type="number" maxlength="9" minlength="9" placeholder="Teléfono de Contacto" class="formulario">
            <input id="email" name = "email" type="email" placeholder="E-Mail" class="formulario">
            <select id="etapa" name = "etapa" class="formulario">
                <option disabled selected>Seleccione una etapa</option>
                <option value="Primaria">Primaria</option>
                <option value="ESO">ESO</option>
                <option VALUE="Bachillerato">Bachillerato</option>
                <option value="Universidad">Universidad</option>
            </select>
            <select id="cursos" name = "cursos" class="formulario"></select>
            <input id="submit" id="submit" type="submit">
        </form>
        <div class = "mensaje-notificacion" id = mensaje-notificacion-acceso>
            <c:if test="${not empty acceso}">
                ${mensajeacceso}
            </c:if>
        </div>
    </div>
    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
