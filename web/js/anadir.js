var mensajeActualizacionProfesor = document.getElementById("mensaje-validacion-profesor");
var mensajeActualizacionAsignatura = document.getElementById("mensaje-validacion-asignatura");

function validarFormularioNuevoProfesor(){
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var codigo = document.getElementById("CP").value;
    var contrasena = document.getElementById("contrasena").value;
    var telefono = document.getElementById("telefono").value;
    var email = document.getElementById("email").value;

    var mensajeErrorRelleno;
    var contadorCamposRellenos = 0;
    var booleanCamposRellenos; // Esto se calcula más adelante
    var booleanCamposValidos = true; // Se asume true hasta que no se demuestre lo contrario

    if(nombre !== "") {
        contadorCamposRellenos += 1;
    }

    if(apellidos !== "") {
        contadorCamposRellenos += 1;
    }

    if(codigo !== "") {
        contadorCamposRellenos += 1;
        codigo = parseInt(codigo);
        if(codigo < 10000 || codigo > 99999){
            booleanCamposValidos = false;
            mensajeErrorRelleno = "Introduzca un código postal válido."
        }
    }

    if(contrasena !== "") {
        contadorCamposRellenos += 1;
    }

    if(telefono !== "") {
        contadorCamposRellenos += 1;
        if(telefono.length !== 9){
            booleanCamposValidos = false;
            mensajeErrorRelleno = "La longitud del teléfono debe ser 9 cifras.";
            telefono = parseInt(telefono);
            if(telefono<0){
                booleanCamposValidos = false;
                mensajeErrorRelleno = "El telefono debe ser un número válido.";
            }
        }
    }

    if(email !== "") {
        contadorCamposRellenos += 1;
    }


    if (contadorCamposRellenos === 7){
        // Se quiere actualizar algún valor
        mensajeActualizacionProfesor.innerHTML = "";
        booleanCamposRellenos = true;
    }
    else{
        mensajeActualizacionProfesor.innerHTML = "Debe rellenar todos los campos";
        booleanCamposRellenos = false;
    }

    // Si algún campo no es válido, se explica por qué.
    if(!booleanCamposValidos){
        mensajeActualizacionProfesor.innerHTML = mensajeErrorRelleno;
    }
    // Tienen que estar rellenos y validos
    return booleanCamposRellenos && booleanCamposValidos;
}



function validarFormularioNuevaAsignatura(){
    var asignatura = document.getElementById("asignatura").value;
    var curso = document.getElementById("curso").value;
    var etapa = document.getElementById("etapa").value;

    var mensajeErrorRelleno;
    var contadorCamposRellenos = 0;
    var booleanCamposRellenos; // Esto se calcula más adelante
    var booleanCamposValidos = true; // Se asume true hasta que no se demuestre lo contrario

    if(asignatura !== ""){
        contadorCamposRellenos +=1;
    }

    if(curso !== "") {
        contadorCamposRellenos += 1;
        curso = parseInt(curso);
        if(curso > 6 || curso < 1){
            booleanCamposValidos = false;
            mensajeErrorRelleno = "Introduzca un curso válido";
        }
    }

    if(etapa !== "") {
        contadorCamposRellenos += 1;
        if(etapa === "Primaria" || etapa === "ESO" || etapa === "Bachillerato" || etapa === "Universidad"){
            //Nothing
        }
        else{
            booleanCamposValidos = false;
            mensajeErrorRelleno = "Los valores válidos de etapa son: 'Primaria', 'ESO', 'Bachillerato' y 'Universidad'."
        }
    }

    if (contadorCamposRellenos === 3){
        // Se quiere actualizar algún valor
        mensajeActualizacionAsignatura.innerHTML = "";
        booleanCamposRellenos = true;
    }
    else{
        mensajeActualizacionAsignatura.innerHTML = "Debe rellenar todos los campos";
        booleanCamposRellenos = false;
    }

    // Si algún campo no es válido, se explica por qué.
    if(!booleanCamposValidos){
        mensajeActualizacionAsignatura.innerHTML = mensajeErrorRelleno;
    }
    // Tienen que estar rellenos y validos
    return booleanCamposRellenos && booleanCamposValidos
}

