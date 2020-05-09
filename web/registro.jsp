<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="css/registro.css">
    <script defer src="js/registro.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >

</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <h2>Registrarse</h2>
        <div id = "mensaje-notificacion-acceso">
            <c:if test="${not empty acceso}">
                ${mensajeacceso}
            </c:if>
        </div>
        <div id="mensaje"></div>
        <form method="post" action="Registro" >
            <div class="row">
                <div class="col-xs-12">
                    <div class="form-group">
                        <input id="nombre" name="nombre" type="text" placeholder="Nombre"  class="form-control formulario"autofocus="">
                        <input id="apellidos" name="apellidos" type="text" placeholder="Apellidos"  class="form-control formulario" autofocus="">
                        <input id="CP" name="CP" type="number" placeholder="Código Postal"  minlength="5" maxlength="5" class="form-control formulario" autofocus="">
                        <input id="usuario" name="usuario" type="text" placeholder="Usuario"  class="form-control formulario" autofocus="">
                        <input id="contrasena" name="contrasena" type="password"  placeholder="Contraseña" class="form-control formulario" autofocus="">
                        <input id="telefono" name="telefono" type="number"  maxlength="9" minlength="9" placeholder="Teléfono de Contacto" class="form-control formulario"autofocus="">
                        <input id="email" type="email" name="email" placeholder="E-Mail" class="form-control formulario" autofocus="" >
                    </div>
                </div>
            </div>
            <select id="etapa" name="etapa" class="formulario" >
                <option disabled selected>Seleccione una etapa</option>
                <option value="Primaria">Primaria</option>
                <option value="ESO">ESO</option>
                <option value="Bachillerato">Bachillerato</option>
                <option value="Universidad">Universidad</option>
            </select>
            <select id="cursos" name="cursos" class="formulario"></select>
            <input id="submit" class="submit btn btn-primary" type="submit">
        </form>
    </div>
    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
