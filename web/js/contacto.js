var boton=document.getElementById("enviar");
var nombre=document.getElementById("nombre");
var mail=document.getElementById("mail");
var mensaje=document.getElementById("mensaje");
var telefono=document.getElementById("telefono");
var mensaje=document.getElementById("mensaje-error");

boton.addEventListener('click',function (e) {
    if(nombre.value.length==0 || mail.value.length==0 || mensaje.value.length==0 || telefono.value.length==0)
    {
        e.preventDefault();
        mensaje.textContent="Debe rellenar todos los campos";
        $(mensaje).fadeIn(0);
        $(mensaje).fadeOut(5000);
    }
})
