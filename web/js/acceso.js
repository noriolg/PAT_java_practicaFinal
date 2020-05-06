var submit= document.getElementById("submitacceso");
var usuario=document.getElementById("usuario");
var contrasena=document.getElementById("contrasena");
var contador=0;
var flag=0;
var mensaje=document.getElementById("mensaje");
var mensajeacceso = document.getElementById("mensaje-notificacion-acceso");

submit.addEventListener("click",function (e) {
    if(usuario.value.length==0||contrasena.value.length==0)
    {
        e.preventDefault();
        mensaje.textContent="Debe rellenar ambos campos";
        mensaje.style.opacity=1;
        if(flag==0) {
            tiempofundido = setInterval(Opacidad, 50);
        }
    }
    mensajeacceso.textContent="";
})
function Opacidad() {
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

