function seleccionarCheckboxes(a) {
    const checkboxes = document.querySelectorAll(`input[type="checkbox"][name="${a}"]`);

    checkboxes.forEach(function(checkbox) {
        checkbox.checked = true;
    });
}

function deseleccionarCheckboxes(a) {
    const checkboxes = document.querySelectorAll(`input[type="checkbox"][name="${a}"]`);

    checkboxes.forEach(function(checkbox) {
        checkbox.checked = false;
    });
}