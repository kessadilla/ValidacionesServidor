function mostrarClaves() {
    var clave = document.getElementById("clave");
    var confirmarClave = document.getElementById("confirmarClave");

    if (clave.type === "password") {
        clave.type = "text";
        confirmarClave.type = "text";
    } else {
        clave.type = "password";
        confirmarClave.type = "password";
    }
}