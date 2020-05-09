<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Academia Ícaro</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<body>
<div class="header">
    <jsp:include page="/cabecera" />
</div>

<div id="contenido" class = "contenido">
    <c:if test="${not empty requestScope.mensajeCompra}">
        <div class="mensajeCompra">
            ${requestScope.mensajeCompra}
        </div>
    </c:if>
</div>

<div class = "footer">
    <jsp:include page="/footer" />
</div>

</body>
</html>
