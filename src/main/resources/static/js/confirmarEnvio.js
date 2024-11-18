function confirmarEnvio(nombreFormulario) {
    var mensaje = "Pulsa Aceptar para enviar el formulario. Pulsa Cancelar para abortar esta operación.";
    if (confirm(mensaje)) {

        document.getElementById(nombreFormulario).submit();
    }
}