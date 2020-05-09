
var array=document.querySelectorAll('.menu');
array.forEach(function (elem) {
    elem.addEventListener("click",function () {
        array.forEach(function (elem) {
            elem.classList.remove('activo');
        })
        elem.classList.add('activo');
    })

});
