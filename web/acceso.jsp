<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Acceso</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/acceso.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
    <script defer src="js/acceso.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <img class="ola" src="images/wave.png">
    <div class="contenido">
        <div class="imagen">
            <img src="images/profesor.svg">
        </div>
        <div class="contenedor-acceso">
            <form method="post" action="Autenticacion">
                <div class="contenedor-perfil">
                    <img class="perfil" src="images/perfil.svg">
                </div>
                <h2>Bienvenido</h2>
                <div class="contenido-input uno">
                    <input class="usuario" name="usuario" id="usuario" type="text" placeholder="Usuario">
                    <br>
                    <input class="contrasena" name="contrasena" id="contrasena" type="password" placeholder="Contraseña">
                    <br>
                </div>
                <div class = "mensaje-notificacion" id = "mensaje-notificacion-acceso">
                    <c:if test="${not empty mensajeacceso}">
                        ${mensajeacceso}
                    </c:if>
                </div>
                <div  id = "mensaje-notificacion-registro">
                    <c:if test="${not empty mensajeregistro}">
                        ${mensajeregistro}
                    </c:if>
                </div>

                <div id="mensaje">

                </div>
                <input type="submit" class="submitacceso"  id="submitacceso" value="Acceder">
            </form>
        </div>
    </div>
    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
