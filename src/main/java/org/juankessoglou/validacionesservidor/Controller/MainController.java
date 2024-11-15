package org.juankessoglou.validacionesservidor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/formulario")
public class MainController {
    private static int iteraciones;

    public MainController() {
        this.iteraciones = 0;
    }

    @ModelAttribute
    public void modeloGlobal(Model model) {
        //TODO añadir aqui las colecciones
    }
}
