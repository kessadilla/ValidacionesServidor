package org.juankessoglou.validacionesservidor.Controller;

import jakarta.validation.Valid;
import org.juankessoglou.validacionesservidor.Model.Colecciones;
import org.juankessoglou.validacionesservidor.Model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/formulario")
public class MainController {
    private static int iteraciones;

    public MainController() {
        iteraciones = 0;
    }

    @ModelAttribute
    public void modeloGlobal(Model model) {
        model.addAttribute("generoSeleccionado", Colecciones.getListaPaises());
        model.addAttribute("paisSeleccionado", Colecciones.getListaGeneros());
        model.addAttribute("musicasSeleccionadas", Colecciones.getListaAficiones());
        model.addAttribute("aficionesSeleccionadas", Colecciones.getListaMusicas());
    }

    @RequestMapping(value = "/devuelve-formulario", method = GET)
    public String devuelveFormulario(@ModelAttribute("datosFormulario") DatosFormulario datosFormulario){
        return "formulario";
    }

    // TODO cambiar a post
    @RequestMapping(value = "/recibe-parametros", method = GET)
    public String recibeParametrosYRepinta(Model modelo,
                                           @Valid @ModelAttribute("datosFormulario") DatosFormulario datosFormulario,
                                           BindingResult bindingResult){
        return "formulario";
    }
}
