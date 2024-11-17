function deseleccionarRadios(name) {
    const radios = document.querySelectorAll(`input[name="${name}"]`);

    radios.forEach(function(radio) {
        radio.checked = false;
    });
}