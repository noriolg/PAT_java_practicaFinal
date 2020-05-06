var numero=document.getElementById("numero");
var numeroelem=document.querySelectorAll('.numero-elem');
var array=document.querySelectorAll('.menu');
var cesta=document.getElementById("cesta");
var comprarform=document.getElementById("comprar");
var vaciarform=document.getElementById("vaciar");
//array[0].classList.add('activo');
array.forEach(function (elem) {
    elem.addEventListener("click",function () {
        array.forEach(function (elem) {
            elem.classList.remove('activo');
        })
        elem.classList.add('activo');
    })

});
numero.textContent=numeroelem.length;

function Eliminar(){
    vaciarform.removeChild(document.getElementById("submitVaciar"));
    comprarform.removeChild(document.getElementById("submitFin"));

}