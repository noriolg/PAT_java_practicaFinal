var mensajeActualizacion = document.getElementById("mensaje-validacion");


function validarFormularioEdicionAlumno(){
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var codigo = document.getElementById("CP").value;
    var contrasena = document.getElementById("contrasena").value;
    var telefono = document.getElementById("telefono").value;
    var email = document.getElementById("email").value;
    var etapa = document.getElementById("etapa").value;
    var curso = document.getElementById("curso").value;

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

    if(etapa !== "") {
        contadorCamposRellenos += 1;
        if(etapa === "Primaria" || etapa === "ESO" || etapa === "Bachillerato" || etapa === "Universidad"){
            booleanCamposValidos = false;
            mensajeErrorRelleno = "Los valores válidos de etapa son: 'Primaria', 'ESO', 'Bachillerato' y 'Universidad'."
        }
    }

    if(curso !== "") {
        contadorCamposRellenos += 1;
        curso = parseInt(curso);
        if(curso > 6 || curso < 1){
            booleanCamposValidos = false;
            mensajeErrorRelleno = "Introduzca un curso válido";
        }
    }

    if (contadorCamposRellenos != 0){
        // Se quiere actualizar algún valor
        mensajeActualizacion.innerHTML = "";
        booleanCamposRellenos = true;
    }
    else{
        mensajeActualizacion.innerHTML = "Debe rellenar al menos un campo";
        booleanCamposRellenos = false;
    }

    // Si algún campo no es válido, se explica por qué.
    if(!booleanCamposValidos){
        mensajeActualizacion.innerHTML = mensajeErrorRelleno;
    }
    // Tienen que estar rellenos y validos
    return booleanCamposRellenos && booleanCamposValidos;
}



function validarFormularioEdicionProfesor(){
    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var codigo = document.getElementById("CP").value;
    var contrasena = document.getElementById("contrasena").value;
    var telefono = document.getElementById("telefono").value;
    var email = document.getElementById("email").value;
    var descripcion = document.getElementById("descripcion").value;

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
            mensajeErrorRelleno = "Introduzca un código postal válido.";
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

    if(descripcion !== "") {
        contadorCamposRellenos += 1;
        if(descripcion.length > 190){
            booleanCamposValidos = false;
            mensajeErrorRelleno = "La descripción es demasiado larga";
        }
    }

    if(email !== "") {
        contadorCamposRellenos += 1;
    }



    if (contadorCamposRellenos != 0){
        // Se quiere actualizar algún valor
        mensajeActualizacion.innerHTML = "";
        booleanCamposRellenos = true;
    }
    else{
        mensajeActualizacion.innerHTML = "Debe rellenar al menos un campo";
        booleanCamposRellenos = false;
    }

    // Si algún campo no es válido, se explica por qué.
    if(!booleanCamposValidos){
        mensajeActualizacion.innerHTML = mensajeErrorRelleno;
    }
    // Tienen que estar rellenos y validos
    return booleanCamposRellenos && booleanCamposValidos
}

