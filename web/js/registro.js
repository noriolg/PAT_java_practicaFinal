var etapa=document.getElementById("etapa");
var selectcurso=document.getElementById("cursos");
var submit=document.getElementById("submit");
var contador=0;
var flag=0;
var mensaje=document.getElementById("mensaje");
var formulario=null;

submit.addEventListener('click', function (e) {
    if(formulario==null)
    {
        e.preventDefault();
        mensaje.textContent="Debe rellenar todos los campos";
        mensaje.style.opacity=1;
        if(flag==0) {
            tiempofundido = setInterval(Opacidad, 50);
        }
    }else{
        formulario.forEach(function (elem) {
            if(elem.value.length==0 ){
                e.preventDefault();
                mensaje.textContent="Debe rellenar todos los campos";
                mensaje.style.opacity=1;
                if(flag==0) {
                    tiempofundido = setInterval(Opacidad, 50);
                }

            }
        })
    }
})

etapa.addEventListener('change',function (e) {
    formulario=document.querySelectorAll('.formulario');
    VaciarLista();
    if(etapa.value=="Primaria"){
        GenerarOpciones(6);
    }else if(etapa.value=="ESO"){
        GenerarOpciones(4);
    }else if(etapa.value=="Bachillerato"){
        GenerarOpciones(2);
    }else{
        var option = document.createElement("option");
        option.text="No aplica";
        option.disabled;
    }


})

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
function Opacidad() {
    flag=1;
    if (contador < 1000) {
        mensaje.style.opacity = mensaje.style.opacity - 0.001;
        contador++;
    } else {
        flag=0;
        clearInterval(tiempofundido);
        contador = 0;
    }
}
