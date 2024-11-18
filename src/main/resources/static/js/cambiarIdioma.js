function cambiarIdioma() {
    const selectedLanguage = document.getElementById('lang').value;

    const baseUrl = '/formulario/devuelve-formulario';
    const currentUrl = new URL(baseUrl, window.location.origin);

    currentUrl.searchParams.set('lang', selectedLanguage);

    window.location.href = currentUrl.toString();
}
