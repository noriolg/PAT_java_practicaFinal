var submit= document.getElementById("submitacceso");
var usuario=document.getElementById("usuario");
var contrasena=document.getElementById("contrasena");
var mensaje=document.getElementById("mensaje");
var mensajeacceso = document.getElementById("mensaje-notificacion-acceso");

submit.addEventListener("click",function (e) {
    if(usuario.value.length==0||contrasena.value.length==0)
    {
        e.preventDefault();
        mensaje.textContent="Debe rellenar ambos campos";
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);
    }
    mensajeacceso.textContent="";
});

