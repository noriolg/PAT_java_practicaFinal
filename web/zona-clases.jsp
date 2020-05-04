<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zona Clases</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>

    <div class="contenido">
        Hola<br>

        ${usertype}
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
