<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anadir</title>
    <link rel="stylesheet" type="text/css" href="css/anadir.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class = "contenido">
        <div class="formulario">
            <h4>Nuevo profesor</h4>
            <form method="post" action="InsercionAdmin" >
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <input id="nombre" name="nombre" type="text" placeholder="Nombre"  class="form-control "autofocus="">
                            <input id="apellidos" name="apellidos" type="text" placeholder="Apellidos"  class="form-control " autofocus="">
                            <input id="CP" name="CP" type="number" placeholder="Código Postal"  minlength="5" maxlength="5" class="form-control" autofocus="">
                            <input id="usuario" name="usuario" type="text" placeholder="Usuario"  class="form-control" autofocus="">
                            <input id="contrasena" name="contrasena" type="password"  placeholder="Contraseña" class="form-control " autofocus="">
                            <input id="telefono" name="telefono" type="number"  maxlength="9" minlength="9" placeholder="Teléfono de Contacto" class="form-control "autofocus="">
                            <input id="email" type="email" name="email" placeholder="E-Mail" class="form-control " autofocus="" >
                        </div>
                    </div>
                </div>
                <input id="submitProfesor" name = "submitProfesor" class="submit btn btn-primary" type="submit" value = "Añadir profesor">
            </form>
        </div>
        <div class="formulario">
            <h4>Nueva asignatura</h4>
            <form method="post" action="InsercionAdmin" >
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <input id="asignatura" name="asignatura" type="text" placeholder="Asignatura"  class="form-control"autofocus="">
                            <input id="curso" name="curso" type="number" placeholder="Curso" minlength="1" maxlength="1" class="form-control" autofocus="">
                            <input id="etapa" name="etapa" type="text" placeholder="Etapa"   class="form-control" autofocus="">
                        </div>
                    </div>
                </div>
                <input id="submitAsignatura" name = "submitAsignatura" class="submit btn btn-primary" type="submit" value = "Añadir Asignatura">
            </form>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
