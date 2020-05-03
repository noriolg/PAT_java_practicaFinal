<%--
  Created by IntelliJ IDEA.
  User: norio
  Date: 30/04/2020
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zona Clases</title>
    <link rel="stylesheet" type="text/css" href="css/clases.css">
    <script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel='shortcut icon' type='image/x-icon' href="images/favicon.ico" >
</head>
<body>
    <div class="header">
        <jsp:include page="/cabecera" />
    </div>
    <div class="contenido">
        <div class="row">
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="images/primaria.svg" alt=""></a>
                    <div class="primaria" class="card-body">
                        <h4 class="card-title">
                            <a href="#">Primaria</a>
                        </h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="images/ESO.svg" alt=""></a>
                    <div class="ESO" class="card-body">
                        <h4  class="card-title">
                            <a href="#">ESO</a>
                        </h4>
                    </div>
                </div>
            </div>
            <div class="abajo" class="col-lg-4 col-sm-6 mb-4">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="images/Bachillerato.svg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">Bachillerato</a>
                        </h4>
                    </div>
                </div>
            </div>
            <div class="abajo1" class="col-lg-4 col-sm-6 mb-4">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="images/Universidad.svg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">Universidad</a>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
