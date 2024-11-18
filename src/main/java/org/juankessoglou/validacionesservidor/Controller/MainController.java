package org.juankessoglou.validacionesservidor.Controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.juankessoglou.validacionesservidor.Model.Colecciones;
import org.juankessoglou.validacionesservidor.Model.DatosFormulario;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/formulario")
public class MainController {
    @NotNull
    private static int iteraciones;

    public MainController() {
        iteraciones = 0;
    }

    @ModelAttribute
    public void modeloGlobal(Model model) {
        model.addAttribute("listaPaises", Colecciones.getListaPaises());
        model.addAttribute("listaGeneros", Colecciones.getListaGeneros());
        model.addAttribute("listaAficiones", Colecciones.getListaAficiones());
        model.addAttribute("listaMusicas", Colecciones.getListaMusicas());
        model.addAttribute("iteraciones", ++iteraciones);
    }

    @RequestMapping(value = "/devuelve-formulario", method = GET)
    public String devuelveFormulario(@ModelAttribute("datosFormulario") DatosFormulario datosFormulario, Model model) {
        return "formulario";
    }

    @RequestMapping(value = "/recibe-parametros", method = POST)
    public String recibeParametrosYRepinta(Model model,
                                           @Valid @ModelAttribute("datosFormulario") DatosFormulario datosFormulario,
                                           BindingResult bindingResult,
                                           @RequestParam Map<String, String> mapaParametros,
                                           @RequestParam(required = false, name = "enviar_imagen.x") String enviarImagen_x,
                                           @RequestParam(required = false, name = "enviar_imagen.y") String enviarImagen_y) {

        List<String> erroresEdadCoincide = new ArrayList<>();
        List<String> erroresClavesCoinciden = new ArrayList<>();
        List<String> erroresContactoRequerido = new ArrayList<>();
        List<String> otrosErrores = new ArrayList<>();

        for (ObjectError error : bindingResult.getGlobalErrors()) {
            if (error.getCode() != null && error.getCode().equals("EdadCoincide")) {
                erroresEdadCoincide.add(error.getDefaultMessage());
            }
            if (error.getCode() != null && error.getCode().equals("ClavesCoinciden")) {
                erroresClavesCoinciden.add(error.getDefaultMessage());
            }
            if (error.getCode() != null && error.getCode().equals("Contacto")) {
                erroresContactoRequerido.add(error.getDefaultMessage());
            }
        }

        model.addAttribute("erroresEdadCoincide", erroresEdadCoincide);
        model.addAttribute("erroresClavesCoinciden", erroresClavesCoinciden);
        model.addAttribute("erroresContactoRequerido", erroresContactoRequerido);

        model.addAttribute("enviar_img_x", enviarImagen_x = (enviarImagen_x == null) ? "0" : enviarImagen_x);
        model.addAttribute("enviar_img_y", enviarImagen_y = (enviarImagen_y == null) ? "0" : enviarImagen_y);

        model.addAttribute(mapaParametros.size());

        if (bindingResult.hasErrors()) {
            model.addAttribute("mensajeNOK", "ALERTA: Formulario con errores");
            return "formulario";
        }
        model.addAttribute("mensajeOK", "ALELUYA. Formulario sin errores");
        return "formulario";
    }
}
