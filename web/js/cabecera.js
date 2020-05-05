var numero=document.getElementById("numero");
var numeroelem=document.querySelectorAll('.numero-elem');
var array=document.querySelectorAll('.menu');
var navbar = document.getElementById("barra-menu");
var sticky = navbar.offsetTop;
//array[0].classList.add('activo');
array.forEach(function (elem) {
    elem.addEventListener("click",function () {
        array.forEach(function (elem) {
            elem.classList.remove('activo');
        })
        elem.classList.add('activo');
    })

})
numero.textContent=numeroelem.length;
