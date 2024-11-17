function vaciarFormulario() {
    const formulario = document.getElementById('formulario');
    const elementos = formulario.elements;

    for (let i = 0; i < elementos.length; i++) {
        const campo = elementos[i];

        if (campo.type === "text" || campo.type === "email" || campo.type === "password") {
            campo.value = "";
        }
        else if (campo.type === "radio" || campo.type === "checkbox") {
            campo.checked = false;
        }
        else if (campo.tagName === "SELECT") {
            campo.selectedIndex = -1;
        }
        else if (campo.tagName === "TEXTAREA") {
            campo.value = "";
        }
    }
}