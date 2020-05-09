var submit=document.getElementById("submitClase");
var oculto=document.getElementById("oculto");
var oculto3=document.getElementById("oculto3");
var lista=document.querySelectorAll('.clase');
var mensajeCesta=document.getElementById("mensajeCesta");
var submituni=document.getElementById("universidadEnviar");
var ocultouni=document.getElementById("ocultouni");
var mensajetext=document.getElementById("mensajeasig");
var asignatura=document.getElementById("asignatura")
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
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);

    }else if(oculto.value.length==0){
        e.preventDefault()
        mensaje.textContent="Debe seleccionar una clase";
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);
    }else {

    }

});
submituni.addEventListener('click',function (e) {
    if(ocultouni.value!="true")
    {
        e.preventDefault()
        mensaje.textContent="Debe acceder con su usuario";
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);
    }else if(asignatura.value.length==0 || mensajetext.value.length==0){
        e.preventDefault()
        mensaje.textContent="Debe rellenar ambos campos";
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);

    }
})
window.addEventListener('load',function () {

    if(mensajeCesta!=null){
        mensajeCesta.textContent="Se ha añadido correctamente a la cesta";
        $(mensajeCesta).fadeIn(0);
        $(mensajeCesta).fadeOut(5000);
    }
});
