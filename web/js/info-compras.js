var fechaInicial = document.getElementById("fechainicio");
var fechaFinal = document.getElementById("fechafin");

function validar(){
    var relleno;
    var coherente;

    if (fechaInicial.value == "" || fechaFinal.value == ""){
        relleno = false;
    }else{
        relleno = true;
    }

    if(fechaInicial.value > fechaFinal.value){
        coherente = false;
    }else{
        coherente = true;
    }

    return coherente && relleno;
}
