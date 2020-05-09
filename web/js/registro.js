var etapa=document.getElementById("etapa");
var submit=document.getElementById("submit");
var mensaje=document.getElementById("mensaje");
var selectcurso=document.getElementById("cursos");
var formulario=null;
var mensaje_notificacion = document.getElementById("mensaje-notificacion-acceso");

selectcurso.addEventListener('click', function () {
    formulario=document.querySelectorAll('.formulario');
})

submit.addEventListener('click', function (e) {
    if(formulario==null)
    {
        // Se muestra el mensaje de aviso de rellenado erróneo
        e.preventDefault();
        mensaje.textContent="Debe rellenar todos los campos";
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);
    }else{

        formulario.forEach(function (elem) {
            if(elem.value.length==0 ){
                e.preventDefault();
                mensaje.textContent="Debe rellenar todos los campos";
                $(mensaje).fadeIn(0);
                $(mensaje).fadeOut(5000);
                // Se elimina un posible mensaje anterior que hubiera
                mensaje_notificacion.innerHTML = "";

            }
        })
    }
})

etapa.addEventListener('change',function (e) {
    VaciarLista();
    if(etapa.value=="Primaria"){
        GenerarOpciones(6);
    }else if(etapa.value=="ESO"){
        GenerarOpciones(4);
    }else if(etapa.value=="Bachillerato"){
        GenerarOpciones(2);
    }else if(etapa.value=="Universidad"){
        var option = document.createElement("option");
        option.text="No aplica";
        option.classList.add('curso');
        selectcurso.add(option);
    }else{}
 });



function VaciarLista() {
    var cursos=document.querySelectorAll('.curso');
    cursos.forEach(function (elem) {
        selectcurso.remove(elem);
    })

}

function GenerarOpciones(n) {
    for(var i = 1; i <= n+1; i++)
    {
        var option = document.createElement("option");
        if (i==1)
        {
            option.text="Seleccione un curso";
            option.disabled;

        }else{
            //option.text = String(i-1)+"º"; si no daba errores al meter en la BD
            option.text = String(i-1);
        }
        option.classList.add('curso');
        selectcurso.add(option);
    }
}

