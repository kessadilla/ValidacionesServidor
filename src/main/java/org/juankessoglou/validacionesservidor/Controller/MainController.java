package org.juankessoglou.validacionesservidor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        // TODO añadir aqui las colecciones
    }

    @RequestMapping(value = "/devuelve-formulario", method = GET)
    public String devuelveFormulario(){
        return "formulario";
    }

    // TODO cambiar a post
    @RequestMapping(value = "/recibe-parametros", method = GET)
    public String recibeParametrosYRepinta(){
        return "formulario";
    }
}
