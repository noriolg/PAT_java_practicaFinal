var submit=document.getElementById("submitClase");
var oculto=document.getElementById("oculto");
var oculto3=document.getElementById("oculto3");
var oculto2=document.getElementById("oculto2");
var lista=document.querySelectorAll('.clase');
var mensajeCesta=document.getElementById("mensajeCesta");
var contador=0;
var flag=0;
var tiempofundido=null;
var mensaje=document.getElementById("mensaje");
function Filtro() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        ul = document.getElementById("lista");
        li = ul.getElementsByTagName("li");
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("a")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
}
lista.forEach(function (elem) {
    elem.addEventListener('click', function(){
        oculto.value=elem.innerText;
    });
})
submit.addEventListener('click',function (e) {
    if(oculto3.value!="true" )
    {
        e.preventDefault()
        mensaje.textContent="Debe acceder con su usuario";
        mensaje.style.opacity=1;
        if(flag==0) {
            tiempofundido = setInterval(Opacidad(mensaje), 50);
        }

    }else if(oculto.value.length==0){
        e.preventDefault()
        mensaje.textContent="Debe seleccionar una clase";
        mensaje.style.opacity=1;
        if(flag==0) {
            tiempofundido = setInterval(Opacidad(mensaje), 50);
        }
    }else {

    }

});
function Opacidad(mensaje) {
    flag=1;
    if (contador < 100) {
        mensaje.style.opacity = mensaje.style.opacity - 0.01;
        contador++;
    } else {
        flag=0;
        clearInterval(tiempofundido);
        contador = 0;
    }
}
window.addEventListener('load',function () {
    mensajeCesta.style.opacity=1;
    if(flag==0) {
        tiempofundido = setInterval(Opacidad(mensajeCesta), 50);
    }
})