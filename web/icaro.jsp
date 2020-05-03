<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ícaro</title>
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


<div class = "contenido" id = "icaro">
    <img src="./images/icaro.jpg" alt="imagen_icaro">
    <div class = "texto" id = "texto-icaro">
        <h3 style="color:#757575;">La academia</h3><br>
        La academia se creó en <b>noviembre de 2018</b> . Algunos de nuestros profesores llevan dando clase desde antes
        y otros tienen menos experiencia. <br><br>

        En <b>septiembre de 2019</b> profesionalizamos el servicio con un programa
        interno que gestiona las horas de clase de los profesores.<br><br>

        En <b>enero de 2020</b> se lanzó una
        <a href="https://noriolg.shinyapps.io/academiaicaro/" target="_blank">primera iniciativa web</a> para
        coordinar los grupos de preparación de acceso a ICAI/ICADE.<br><br>

        En <b>primavera de 2020</b> nos adaptamos al confinamiento mediante un método de clases online utilizando
        la plataforma Zoom y decidimos empezar a desarrollar un portal web algo más avanzado. Este es el resultado.
        Tenemos amplia experiencia escogiendo los profesores que más se adapten a tu situación. Buscamos

        <br><br>
        El fundador y actual gerente es Nicolás Oriol Guerra. Antiguo alumno del colegio Nuestra Señora del Recuerdo.
        Estudia Ingeniería de Telecomunicaciones y Business Analytics en ICAI. Lleva impartiendo clases
        desde 2016 y amplia experiencia con el temario de las distintas etapas escolares.

    </div>

</div>

<div class = "footer">
    <jsp:include page="/footer" />
</div>

</body>
</html>
