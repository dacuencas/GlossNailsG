const nombre = document.getElementById("nombre");
const correo = document.getElementById("correo");
const pass = document.getElementById("pass");
const verfContraseña = document.getElementById("verfContraseña");
const form = document.getElementById("form");
const parrafo = document.getElementById("warnings");



form.addEventListener("submit", event=>{
    event.preventDefault();
    var warnings = "";
    var entrar = false;
    var regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    var regexTelefono = /\d/;
    parrafo.innerHTML = "";

    
    if(nombre.value.length <6){
        warnings += " El nombre no es valido <br>";
        entrar = true;
    }
    if(!regexEmail.test(correo.value)){
        warnings += "  El email no es valido <br>";
        entrar = true;
    }
     if(pass.value.length < 8){
        warnings += " La contraseña no es valida <br>";
        entrar = true;
    }
    if(pass.value.length !==  verfContraseña.value.length){
        warnings += " Las contraseñas no coinciden <br>";
        entrar = true;
    }
    if(entrar){
        parrafo.innerHTML = warnings;
    }else{
         parrafo.innerHTML = "Registro satisfactorio";
        location.href = "#";
    }
   

});
    const usuarios = document.getElementById("usuarios");
    const contras = document.getElementById("contras");
    const form2 = document.getElementById("form2");
    const parrafo2 = document.getElementById("warnings2");
    form2.addEventListener("submit", event=>{
            event.preventDefault();
            let warnings2 = "";
            let entrar = false;
            parrafo2.innerHTML = "";


            if(usuarios.value !==  "cliente"){
                warnings2 += "El email es incorrecto <br>";
                entrar = true;
            }
            if(contras.value !== "cliente123"){
                warnings2 += "La contraseña es incorrecta <br>";
                entrar = true;
            }
           
            if(entrar){
                parrafo2.innerHTML = warnings2;
            }else{
                parrafo2.innerHTML = "Login Satisfactorio";
                location.href = "#";
            }
});