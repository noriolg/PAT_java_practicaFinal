var labelAlumno = document.getElementById("label-alumno");
var labelProfesor = document.getElementById("label-profesor");
var profesorSeleccionado = document.getElementById("profesor-seleccionado");
var claseSeleccionada = document.getElementById("clase-seleccionada");


var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.4.1.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);


$("#tabla-datos-clases tr").click(function(){
    $(this).addClass('selected').siblings().removeClass('selected');
    var value=$(this).find('td:first').html();
    var alumno=$(this).closest("tr").find('td:eq(1)').text();
    claseSeleccionada.value = value;
    labelAlumno.innerHTML =  "ID:" + value + "  User: " + alumno;
});


$("#tabla-datos-profesores tr").click(function(){
    $(this).addClass('selected').siblings().removeClass('selected');
    var profesor=$(this).closest("tr").find('td:eq(2)').text();
    profesorSeleccionado.value = profesor;
    labelProfesor.innerHTML =  "User: " + profesor;

});


$('.asignar').on('click', function(e){

    if(labelProfesor.innerText !== "Seleccione un profesor..." && labelAlumno.innerText !== "Seleccione un alumno..."){
        labelProfesor.innerHTML =  "Seleccione un profesor...";
        labelAlumno.innerHTML =  "Seleccione un alumno...";

    }else{
        e.preventDefault();
    }
});


function validar(){
    var validacion;
    if(labelProfesor.innerHTML !== "Seleccione un profesor..." && labelAlumno.innerHTML !== "Seleccione un alumno..."){
        labelProfesor.innerHTML =  "Seleccione un profesor...";
        labelAlumno.innerHTML =  "Seleccione un alumno...";
        validacion =true;
    }else{
       validacion = false;
    }
    return validacion;
}

/*
function loadDoc(){
    alert("test");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("teest").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/dashboard-admin-ajax.txt", true);
    xhttp.send();
}

 */