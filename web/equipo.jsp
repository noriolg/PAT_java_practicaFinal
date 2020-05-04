<%--
  Created by IntelliJ IDEA.
  User: norio
  Date: 03/05/2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Equipo directivo</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/equipo-directivo.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>

    <div class = "contenido">
        <div class = "bloque-persona" id = "izquierda">
            <img src="./images/nico.jpg" alt="imagen_nico" width="auto" height="35%" >
            <div class = "texto">
                <h3 style="color:#757575; text-align: center;">Nicolás Oriol Guerra</h3><br>
                Estudiante de Universidad Pontificia Comillas (Ingeniería de Telecomunicaciones y Business Analytics) y
                antiguo alumno del Colegio Nuestra Señora del Recuerdo. <br><br>
                Tiene varios años de experiencia dando clases de apoyo en las distintas etapas educativas tanto
                particulares como grupales.<br><br>
                Es el mayor de cinco hermanos, le encanta el baloncesto, la vela y la programación.
                Montó este proyecto en noviembre de 2018 con la idea de tener la experiencia de montar una
                pequeña empresa y gestionar un equipo.<br><br>
            </div>


        </div>
        <div class = "bloque-persona" id = "centro">
            <img src="./images/miriam.jpg" alt="imagen_miriam" width="auto" height="35%" >
            <div class = "texto">
                <h3 style="color:#757575; text-align: center;">Miriam Medina Ocaña</h3><br>
                Estudiante en la Universidad Pontificia Comillas (Ingeniería Industrial y ADE) y antigua alumna del
                Colegio Nuestra Señora de la Presentación de Granada.<br><br>
                Tanto en sus tres años en Madrid, como en su etapa escolar en Granada, ha ayudado a niños de
                todas las edades voluntaria y profesionalmente, disfrutando mucho de ello.
                Además, le encanta hacer deporte y viajar.<br><br>
                Se unió al equipo este año, ayudando en la gestión y selección del profesorado, motivada por las
                ganas de aprender sobre gestión de empresas y hacer cosas nuevas.
            </div>

        </div>

        <div class = "bloque-persona" id = "derecha">
            <img src="./images/miriam.jpg" alt="imagen_miriam" width="auto" height="35%" >
            <div class = "texto">
                <h3 style="color:#757575; text-align: center;">Pablo de la Cueva García-H.</h3><br>
                Estudiante de Universidad Pontificia Comillas (Ingeniería de Telecomunicaciones y Business Analytics) y
                antiguo alumno del Colegio Nuestra Señora del Recuerdo. <br><br>
                Tiene varios años de experiencia dando clases de apoyo en las distintas etapas educativas tanto
                particulares como grupales.<br><br>
                Es el mayor de cinco hermanos, le encanta el baloncesto, la vela y la programación.
                Montó este proyecto en noviembre de 2018 con la idea de tener la experiencia de montar una
                pequeña empresa y gestionar un equipo.<br><br>
            </div>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
