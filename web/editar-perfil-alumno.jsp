<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Anadir</title>
    <link rel="stylesheet" type="text/css" href="css/editar-perfil.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class = "contenido">
        <sql:setDataSource var = "db" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost/icarus"
                           user = "root"  password = "root"/>
        <sql:query dataSource = "${db}" var = "result">
            SELECT * FROM alumnos WHERE usuario = '${username}' LIMIT 1 ;
        </sql:query>

        <div class="display-info">
            <h4>Información actual</h4><br>
            <div class = "aclaracion">Estos son los datos actuales de tu cuenta</div>
            <div style="width: 100%; text-align: center; font-size:12px">El usuario no se puede cambiar y la contraseña no se muestra por seguridad</div>
            <div class ="datos-display" >
                <c:forEach var = "row" items = "${result.rows}">
                    <div class = "info-piece">
                        <div class = "indicador">Usuario:</div><label id="usuario_label" name="usuario_label" class="form-control" >${row.usuario}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">Nombre:</div> <label id="nombre_label" name="nombre_label" class="form-control" >${row.nombre}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">Apellidos:</div><label id="apellidos_label" name="apellidos" class="form-control">${row.apellidos}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">C. Postal:</div><label id="CP_label" name="CP_label" class="form-control">${row.codigo}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">Teléfono:</div><label id="telefono_label" name="telefono_label"  class="form-control" >${row.telefono}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">Email:</div><label id="email_label" type="email" name="email_label" class="form-control">${row.email}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">Etapa:</div><label id="etapa_label" name="etapa_label"  class="form-control " >${row.etapa}</label>
                    </div>
                    <div class = "info-piece">
                        <div class = "indicador">Curso:</div><label id="curso_label" name="curso_label"  class="form-control " >${row.curso}</label>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="formulario">
            <h4>Información a actualizar</h4><br>
            <div class = "aclaracion" style = "font-size: 13px;">Puedes rellenar únicamente los datos que desees cambiar.</div>
            <form method="post" action="EditarPerfil" onsubmit="return validarFormularioEdicionAlumno();" >
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <input id="nombre" name="nombre" type="text" placeholder="Nombre"  class="form-control "autofocus="">
                            <input id="apellidos" name="apellidos" type="text" placeholder="Apellidos"  class="form-control " autofocus="">
                            <input id="CP" name="CP" type="number" placeholder="Código Postal"  minlength="5" maxlength="5" class="form-control" autofocus="">
                            <input id="contrasena" name="contrasena" type="password"  placeholder="Contraseña" class="form-control " autofocus="">
                            <input id="telefono" name="telefono" type="number"  maxlength="9" minlength="9" placeholder="Teléfono de Contacto" class="form-control "autofocus="">
                            <input id="email" type="email" name="email" placeholder="E-Mail" class="form-control " autofocus="" >
                            <input id="etapa" name="etapa" type="text"  placeholder="Primaria/ESO/Bachillerato/Universidad" class="form-control " autofocus="">
                            <input id="curso" name="curso" type="number"  placeholder="Curso" class="form-control " autofocus="">
                        </div>
                    </div>
                </div>
                <div class = "mensaje-registro">
                    <c:if test="${not empty mensajeActualizacion}">
                        ${mensajeActualizacion}
                    </c:if>
                </div>
                <div class = "mensaje-registro" id="mensaje-validacion"></div>
                <input id="submitActualizacionAlumno" name = "submitActualizacionAlumno" class="submit btn btn-primary" type="submit" value = "Actualizar">
            </form>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
<script src="js/editar-perfil.js" type="text/javascript"></script>
</html>
