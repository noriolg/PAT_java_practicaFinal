<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nosotros</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/quienes-somos.css">
</head>

<body>
<div class="header">
    <jsp:include page="/cabecera" />
</div>

<div class="separator">
    <br>
</div>


<div class = "contenido" id = "nosotros">
    <img src="./images/nosotros.jpg" alt="imagen_nosotros">
    <div class = "texto">
        <h3 style="color:#757575;">Nosotros</h3><br>
        Somos un grupo de alumnos universitarios de distintas carreras. Tenemos niveles de experiencia de
        docencia variados. Nos dedicamos a impartir <b>clases a domicilio</b> de asignaturas de primaria, secundaria,
        bachillerato y universidad. <br><br>
        Todos los profesores que ofrecemos son <b>alumnos universitarios</b>. Esto garantiza
        precios moderados y un <b>ambiente más cercano y accesible</b> para que el alumno se sienta siempre lo
        más cómodo posible y tenga en el profesor un referente cercano.
    </div>

</div>

<div class = "footer">
    <jsp:include page="/footer" />
</div>

</body>
</html>
