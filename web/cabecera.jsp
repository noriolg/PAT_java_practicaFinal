<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Academia Icaro</title>
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="css/cabecera.css">
    <script defer src="https://kit.fontawesome.com/0393c6f460.js" crossorigin="anonymous"></script>
    <script defer src="js/cabecera.js" type="text/javascript"></script>
  </head>

  <body>
    <div id="barra-menu" class="barra-menu">
      <ul>
        <li class="menu"><a href="index.jsp"><i class="fas fa-home"></i>Inicio</a></li>
        <li class="menu" ><a href="#"><i class="fas fa-user"></i>Quiénes Somos</a>
          <div class="menu-inferior">
            <ul>
              <li><a href="nosotros">Nosotros</a></li>
              <li><a href="metodo">Método</a></li>
              <li><a href="icaro">Ícaro</a></li>
            </ul>
          </div>
        </li>

        <li class="menu"><a href="#"><i class="fas fa-chalkboard-teacher"></i>Equipo</a>
          <div class="menu-inferior">
            <ul>
              <li><a href="#">Profesores</a></li>
              <li><a href="equipo">Equipo Directivo</a></li>
            </ul>
          </div>
        </li>
        <li class="menu"><a href="clases"><i class="fas fa-language"></i>Clases</a></li>
        <c:choose>
          <c:when test="${usertype == null}">
            <li class="menu"><a href="#"><i class="fas fa-sign-in-alt"></i>Acceso</a>
              <div class="menu-inferior">
                <ul>
                  <li><a href="acceso">Iniciar sesión</a></li>
                  <li><a href="registro">Registrarse</a></li>
                </ul>
              </div>
            </li>
          </c:when>

          <c:otherwise>
            <c:choose>
              <c:when test = "${usertype == 0}">
                <li class="menu"><a href="#"><i class="fas fa-sign-in-alt"></i>Alumno</a>
                  <div class="menu-inferior">
                    <ul>
                      <li><a href="#">Mis clases</a></li>
                      <li><a href="#">Mi perfil</a></li>
                      <li><a href="CierreSesion">Cerrar sesión</a></li>
                    </ul>
                  </div>
                </li>
              </c:when>

              <c:when test = "${usertype == 1}">
                <li class="menu"><a href="#"><i class="fas fa-sign-in-alt"></i>Profesor</a>
                  <div class="menu-inferior">
                    <ul>
                      <li><a href="#">Mis clases</a></li>
                      <li><a href="#">Mi perfil</a></li>
                      <li><a href="CierreSesion">Cerrar sesión</a></li>
                    </ul>
                  </div>
                </li>
              </c:when>

              <c:otherwise>
                <li class="menu"><a href="#"><i class="fas fa-sign-in-alt"></i>Administrador</a>
                  <div class="menu-inferior">
                    <ul>
                      <li><a href="#">Añadir profesor</a></li>
                      <li><a href="#">Añadir clase</a></li>
                      <li><a href="CierreSesion">Cerrar sesión</a></li>
                    </ul>
                  </div>
                </li>
              </c:otherwise>
            </c:choose>
          </c:otherwise>
        </c:choose>

        <li class="menu"><a href="contacto"><i class="fas fa-phone"></i>Contacto</a></li>
        <li class="menu"><a href="#"><i class="fas fa-shopping-basket"></i><p id="numero">0</p></a>
          <div class="menu-inferior cesta">
            <c:choose>
              <c:when test="${empty sessionScope.carrito}">
                <ul></ul>
              </c:when>
              <c:otherwise>
                <ul>
                  <c:forEach var="entry" items="${sessionScope.carrito.carrito}" >
                  <li class="numero-elem"><c:out value="${entry.asignatura}"/>&nbsp;<c:out value="${entry.curso}"/>º
                    &nbsp; de &nbsp; <c:out value="${entry.etapa}"/></li>
                  </c:forEach>
                  <form method="post" action="">
                    <input id="submit" class="submit btn btn-primary" type="submit" value="Solicitar Clase">
                  </form>
                </ul>
              </c:otherwise>
            </c:choose>
    </div>
  </body>
</html>
