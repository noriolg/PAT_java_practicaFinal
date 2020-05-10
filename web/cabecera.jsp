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
        <li class="menu" ><a href="javascript:void(0)"><i class="fas fa-user"></i>Quiénes Somos</a>
          <div class="menu-inferior">
            <ul>
              <li><a href="nosotros">Nosotros</a></li>
              <li><a href="metodo">Método</a></li>
              <li><a href="icaro">Ícaro</a></li>
            </ul>
          </div>
        </li>

        <li class="menu"><a href="javascript:void(0)"><i class="fas fa-chalkboard-teacher"></i>Equipo</a>
          <div class="menu-inferior">
            <ul>
              <li><a href="GestorPeticionBDProfesores">Profesores</a></li>
              <li><a href="equipo">Equipo Directivo</a></li>
            </ul>
          </div>
        </li>
        <c:choose >
          <c:when test="${empty usertype ||usertype == 0 }">
            <li class="menu"><a href="clases"><i class="fas fa-language"></i>Clases</a></li>
          </c:when>
          <c:otherwise></c:otherwise>
        </c:choose>

        <li class="menu"><a href="contacto"><i class="fas fa-phone"></i>Contacto</a></li>
        <c:if test="${usertype==1}">
            <li class="menu" style="font-size:12px;">Bienvenido de nuevo, ${objetoProfesor.usuario}</li>
        </c:if>
        <c:if test="${usertype==2}">
            <li class="menu" style="font-size:12px;">Bienvenido de nuevo, administrador</li>
        </c:if>
        <c:choose>
          <c:when test="${usertype == null}">
            <li class="menu"><a href="javascript:void(0)"><i class="fas fa-sign-in-alt"></i>Acceso</a>
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
                <li class="menu"><a href="javascript:void(0)"><i class="fas fa-sign-in-alt"></i>Alumno</a>
                  <div class="menu-inferior">
                    <ul>
                      <li><a href="GestionDashBoardAlumnoProfesor">Zona alumno</a></li>
                      <li><a href="EditarPerfil">Mi perfil</a></li>
                      <li><a href="CierreSesion">Cerrar sesión</a></li>
                    </ul>
                  </div>
                </li>
              </c:when>

              <c:when test = "${usertype == 1}">
                <li class="menu"><a href="javascript:void(0)"><i class="fas fa-sign-in-alt"></i>Profesor</a>
                  <div class="menu-inferior">
                    <ul>
                      <li><a href="GestionDashBoardAlumnoProfesor">Zona profesor</a></li>
                      <li><a href="EditarPerfil">Mi perfil</a></li>
                      <li><a href="CierreSesion">Cerrar sesión</a></li>
                    </ul>
                  </div>
                </li>
              </c:when>

              <c:otherwise>
                <li class="menu"><a href="javascript:void(0)"><i class="fas fa-sign-in-alt"></i>Administrador</a>
                  <div class="menu-inferior">
                    <ul>
                      <li><a href="GestionDashboardAdmin">Dashboard</a></li>
                      <li><a href="GestorPeticionBDAcciones">Registro</a></li>
                      <li><a href="anadir">Añadir</a></li>
                      <li><a href="CierreSesion">Cerrar sesión</a></li>
                    </ul>
                  </div>
                </li>
              </c:otherwise>
            </c:choose>
          </c:otherwise>
        </c:choose>
        <c:choose >
          <c:when test="${usertype == 0 || empty usertype}">
            <li class="menu"><a href="javascript:void(0)"><i class="fas fa-shopping-basket"></i><p id="numero">
              <c:choose>
                <c:when test="${not empty sessionScope.carrito}">
                  <p id="numero"><c:out value="${sessionScope.carrito.carrito.size()}"></c:out></p></a>
                </c:when>
              <c:otherwise>
                <p id="numero">0</p></a>
              </c:otherwise>
              </c:choose>
              <div id="cesta" class="menu-inferior cesta">
                <c:choose>
                  <c:when test="${empty sessionScope.carrito.carrito}">
                    <ul></ul>
                  </c:when>
                  <c:otherwise>
                    <ul>
                      <c:forEach var="entry" items="${sessionScope.carrito.carrito}" >
                        <li class="numero-elem"><c:out value="${entry.toString()}"/></li>
                      </c:forEach>
                      <form id="comprar" method="post" action="FinalizarCompra">
                        <input name="submit" id="submitFin" class="submitFin" type="submit" value="Solicitar">
                      </form>
                      <form id="vaciar" method="post" action="GestorClasesProducto">
                        <input name="submit" id="submitVaciar" class="submitVacio " type="submit" value="Vaciar">
                      </form>
                    </ul>
                  </c:otherwise>
                </c:choose>
              </div>
            </li>
          </c:when>
          <c:otherwise></c:otherwise>
        </c:choose>
    </ul>
  </div>
</body>
</html>
