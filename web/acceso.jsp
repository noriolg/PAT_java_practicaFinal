<%--
  Created by IntelliJ IDEA.
  User: carsa
  Date: 30/04/2020
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Acceso</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/acceso.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
    <script defer src="js/acceso.js" type="text/javascript"></script>
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <img class="ola" src="images/wave.png">
        <div class="imagen">
            <img src="images/profesor.svg">
        </div>
        <div class="contenedor-acceso">
            <form method="post" action="/icaro">
                <img class="perfil" src="images/perfil.svg">
                <div id="mensaje">

                </div>
                <h2>Bienvenido</h2>
                <div class="contenido-input uno">
                    <input class="usuario" name="usuario" id="usuario" type="text" placeholder="Usuario">
                    <br>
                    <input class="contrasena" name="contrasena" id="contrasena" type="password" placeholder="Contraseña">
                    <br>
                    <input type="submit" class="submitacceso"  id="submitacceso" value="Acceder">
            </form>
        </div>
    </div>
    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
