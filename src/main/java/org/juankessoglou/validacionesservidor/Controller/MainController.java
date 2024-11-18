package org.juankessoglou.validacionesservidor.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.juankessoglou.validacionesservidor.Model.Colecciones;
import org.juankessoglou.validacionesservidor.Model.DatosFormulario;
import org.juankessoglou.validacionesservidor.Model.RequestInfoDTO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    public void modeloGlobal(Model model, HttpServletRequest request) {
        model.addAttribute("listaPaises", Colecciones.getListaPaises());
        model.addAttribute("listaGeneros", Colecciones.getListaGeneros());
        model.addAttribute("listaAficiones", Colecciones.getListaAficiones());
        model.addAttribute("listaMusicas", Colecciones.getListaMusicas());
        model.addAttribute("iteraciones", ++iteraciones);

        RequestInfoDTO requestInfoDTO = extractRequestInfo(request);
        model.addAttribute("requestInfo", requestInfoDTO);
    }


    @RequestMapping(value = "/devuelve-formulario", method = GET)
    public String devuelveFormulario(@ModelAttribute("datosFormulario") DatosFormulario datosFormulario, Model model) {
        return "formulario";
    }

    @RequestMapping(value = "/recibe-parametros", method = POST)
    public String recibeParametrosYRepinta(Model model,
                                           @Valid @ModelAttribute("datosFormulario") DatosFormulario datosFormulario,
                                           BindingResult bindingResult,
                                           @RequestParam(required = false, name = "enviar_imagen.x") String enviarImagen_x,
                                           @RequestParam(required = false, name = "enviar_imagen.y") String enviarImagen_y,
                                           @RequestParam Map<String, String> mapaParametros) {

        List<String> erroresEdadCoincide = new ArrayList<>();
        List<String> erroresClavesCoinciden = new ArrayList<>();
        List<String> erroresContactoRequerido = new ArrayList<>();

        for (ObjectError error : bindingResult.getGlobalErrors()) {
            if (error.getCode() != null && error.getCode().equals("EdadCoincide")) {
                erroresEdadCoincide.add(error.getDefaultMessage());
            }
            else if (error.getCode() != null && error.getCode().equals("ClavesCoinciden")) {
                erroresClavesCoinciden.add(error.getDefaultMessage());
            }
            else if (error.getCode() != null && error.getCode().equals("Contacto")) {
                erroresContactoRequerido.add(error.getDefaultMessage());
            }
        }

        model.addAttribute("erroresEdadCoincide", erroresEdadCoincide);
        model.addAttribute("erroresClavesCoinciden", erroresClavesCoinciden);
        model.addAttribute("erroresContactoRequerido", erroresContactoRequerido);

        model.addAttribute("enviar_img_x", enviarImagen_x = (enviarImagen_x == null) ? "0" : enviarImagen_x);
        model.addAttribute("enviar_img_y", enviarImagen_y = (enviarImagen_y == null) ? "0" : enviarImagen_y);

        model.addAttribute("params" , mapaParametros);

        if (bindingResult.hasErrors()) {
            model.addAttribute("mensajeNOK", "ALERTA: Formulario con errores");
            System.out.println(bindingResult.getAllErrors());
            return "formulario";
        }
        model.addAttribute("mensajeOK", "ALELUYA. Formulario sin errores");
        return "formulario";
    }

    private RequestInfoDTO extractRequestInfo(HttpServletRequest request) {
        // Crear el DTO para almacenar la información extraída
        RequestInfoDTO requestInfoDTO = new RequestInfoDTO();

        // Obtener la IP del cliente
        String clientIp = getClientIp(request);
        requestInfoDTO.setClientIp(clientIp);

        // Obtener el User-Agent (para saber navegador y sistema operativo)
        String userAgent = request.getHeader("User-Agent");
        requestInfoDTO.setUserAgent(userAgent);

        // Obtener el sistema operativo (extraído del User-Agent)
        String operatingSystem = getOperatingSystem(userAgent);
        requestInfoDTO.setOperatingSystem(operatingSystem);

        // Obtener el motor de renderización del navegador (extraído del User-Agent)
        String renderingEngine = getRenderingEngine(userAgent);
        requestInfoDTO.setRenderingEngine(renderingEngine);

        // Obtener el nombre del host remoto
        String remoteHost = request.getRemoteHost();
        requestInfoDTO.setRemoteHost(remoteHost);

        // Obtener el idioma preferido del cliente
        String preferredLanguage = request.getHeader("Accept-Language");
        requestInfoDTO.setPreferredLanguage(preferredLanguage);

        // Obtener el Locale preferido del cliente
        Locale locale = request.getLocale();
        requestInfoDTO.setLocale(locale.toString());

        return requestInfoDTO;
    }

    // Métdo para obtener la IP del cliente, considerando el caso de proxies
    private String getClientIp(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }

    // Métdo para extraer el sistema operativo a partir del User-Agent
    private String getOperatingSystem(String userAgent) {
        if (userAgent == null) return "Unknown OS";

        if (userAgent.contains("Windows")) {
            return "Windows";
        } else if (userAgent.contains("Mac")) {
            return "Mac OS";
        } else if (userAgent.contains("Linux")) {
            return "Linux";
        } else if (userAgent.contains("Android")) {
            return "Android";
        } else if (userAgent.contains("iOS")) {
            return "iOS";
        }
        return "Unknown OS";
    }

    // Métdo para extraer el motor de renderización a partir del User-Agent
    private String getRenderingEngine(String userAgent) {
        if (userAgent == null) return "Unknown Engine";

        if (userAgent.contains("WebKit")) {
            return "WebKit";
        } else if (userAgent.contains("Gecko")) {
            return "Gecko";
        } else if (userAgent.contains("Trident")) {
            return "Trident (used by Internet Explorer)";
        } else if (userAgent.contains("Blink")) {
            return "Blink (used by Chrome, Opera)";
        }
        return "Unknown Engine";
    }
}
