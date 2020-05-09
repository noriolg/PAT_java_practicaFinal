<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zona Clases</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/dahsboard-admin.css">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>

    <div class="contenido">
        Hola estas en dashboard admin. Eres un ${usertype}, ${objetoProfesor}<br>

        <div class = cuadrante id = "container-tabla-clases">
            <h4>Clases no asignadas</h4><div class = "valor-seleccionado" id = "clase-seleccionada"></div>
            <div class = tabla-superior>
                asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd
            </div>
        </div>

        <div class = "cuadrante" id = "container-tabla-profesores">
            <br><h4>Profesores</h4><div class = "valor-seleccionado" id = "profesor-seleccionado"></div>
            <div class = tabla-superior>
                    asasd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd
            </div>
        </div>

        <div class = "cuadrante" id = "container-tabla-clases-asignadas">
            <br><h4>Clases asignadas</h4>
            <div class = tabla-inferior>
                asasd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd
            </div>
        </div>

        <div class = "cuadrante" id = "container-controlador">
            <br><h4>Emparejar</h4>
            <div class = tabla-inferior>
                asasd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd<br>asd
            </div>
        </div>




    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
<script defer src="js/dashboard-admin.js" type="text/javascript"></script>
</html>
