<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>Dashboard</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/dahsboard-admin.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>

    <div class="contenido">
        <%--Hola estas en dashboard admin. Eres un ${usertype}, ${objetoProfesor}<br>--%>
        <br>
        <div class = cuadrante id = "container-tabla-clases">
            <h4>Clases no asignadas</h4>
            <div class = tabla-superior>
                <table class="tabla-datos" id = "tabla-datos-clases">
                    <div class = tabla-datos-header>
                        <tr>
                            <th class="hcolumna">ID</th>
                            <th class="hcolumna">Alumno</th>
                            <th class="hcolumna">Asignatura</th>
                            <th class="hcolumna">Curso</th>
                            <th class="hcolumna">Etapa</th>
                        </tr>
                    </div>
                    <div class = "tabla-datos-body">
                        <c:forEach var = "claseNoAsignada" items = "${requestScope.listaClasesSinAsignar}">
                            <tr class = "fila-tabla-sup">
                                <td class="columna-center ">${claseNoAsignada.idClase}</td>
                                <td class="columna-left ">${claseNoAsignada.alumnoUser}</td>
                                <td class="columna-left ">${claseNoAsignada.asignatura}</td>
                                <td class="columna-center ">${claseNoAsignada.curso}</td>
                                <td class="columna-center">${claseNoAsignada.etapa}</td>
                            </tr>
                        </c:forEach>
                    </div>
                </table>
            </div>
        </div>

        <div class = "cuadrante" id = "container-tabla-profesores">
            <br><h4>Profesores</h4>
            <div class = tabla-superior>
                <table class="tabla-datos" id = "tabla-datos-profesores">
                    <div class = tabla-datos-header>
                        <tr>
                            <th class="hcolumna">Apellidos</th>
                            <th class="hcolumna">Nombre</th>
                            <th class="hcolumna">Usuario</th>
                        </tr>
                    </div>
                    <div class = "tabla-datos-body">
                        <c:forEach var = "profe" items = "${requestScope.listaProfesores}">
                            <tr class = "fila-tabla-sup">
                                <td class="columna-left">${profe.apellidos}</td>
                                <td class="columna-left">${profe.nombre}</td>
                                <td class="columna-left">${profe.usuario}</td>
                            </tr>
                        </c:forEach>
                    </div>
                </table>
            </div>
        </div>

        <div class = "cuadrante" id = "container-tabla-clases-asignadas">
            <br><h4>Clases asignadas</h4>
            <div class = tabla-inferior>
                <table class="tabla-datos">
                    <div class = tabla-datos-header>
                        <tr>
                            <th class="hcolumna">ID</th>
                            <th class="hcolumna">Alumno</th>
                            <th class="hcolumna">Asignatura</th>
                            <th class="hcolumna">Curso</th>
                            <th class="hcolumna">Etapa</th>
                            <th class="hcolumna">Profesor</th>
                        </tr>                    </div>
                    <div class = "tabla-datos-body">
                        <c:forEach var = "claseAsignada" items = "${requestScope.listaClasesAsignadas}">
                            <tr>
                                <td class="columna-center ">${claseAsignada.idClase}</td>
                                <td class="columna-left">${claseAsignada.alumnoUser}</td>
                                <td class="columna-left">${claseAsignada.asignatura}</td>
                                <td class="columna-center">${claseAsignada.curso}</td>
                                <td class="columna-center">${claseAsignada.etapa}</td>
                                <td class="columna-left">${claseAsignada.profesorUser}</td>
                            </tr>
                        </c:forEach>
                    </div>
                </table>
            </div>
        </div>

        <div class = "container-controlador">
            <br><h4>Emparejar</h4>
            <div class = "control-asignacion">
                <form>
                    <div class = "titulos">
                        <div class = "titulo">Profesor</div>
                        <div class = "titulo">Alumno</div>
                    </div>
                    <div class = "labels">
                        <div class = "label" id = "label-profesor">
                            Seleccione un profesor...
                        </div>
                        <div class = "label" id = "label-alumno">
                            Seleccione un alumno...
                        </div>
                    </div>
                    <input type="text" class = "valor-seleccionado" id = "clase-seleccionada" name = "clase-seleccionada">
                    <input type="text" class = "valor-seleccionado" id = "profesor-seleccionado" name = "profesor-seleccionado">
                    <div class = "caja-asignar">
                        <%--<button class="asignar" type = "submit" onclick="loadDoc();">Asignar</button>--%>
                        <button class="asignar"  name = "asignar" type = "submit" formaction="GestionDashboardAdmin">Asignar</button>
                    </div>
                </form>
            </div>
            <div class = "test" id="teest">test</div>
        </div>


    </div>

    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
<script defer src="js/dashboard-admin.js" type="text/javascript"></script>
</html>
