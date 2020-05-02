var boton=document.getElementById("enviar");
var nombre=document.getElementById("nombre");
var mail=document.getElementById("mail");
var mensaje=document.getElementById("mensaje");
var telefono=document.getElementById("telefono");
var mensaje=document.getElementById("mensaje-error");
var contador=0;
var flag=0;

boton.addEventListener('click',function (e) {
    if(nombre.value.length==0 || mail.value.length==0 || mensaje.value.length==0 || telefono.value.length==0)
    {
        e.preventDefault();
        mensaje.textContent="Debe rellenar todos los campos";
        mensaje.style.opacity=1;
        if(flag==0) {
            tiempofundido = setInterval(Opacidad, 50);
        }
    }
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
