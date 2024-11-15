package org.juankessoglou.validacionesservidor.Model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DatosFormulario {
    private String nombre;
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Float peso;
    private String prefijoTelefonicoPais;
    private String telefono;
    private String email;
    private String url;
    private String paisSeleccionado;
    private MultipartFile archivosSeleccionados;
    private String musicasSeleccionadas;
    private String aficionesSeleccionadas;
    private String comentarios;
    private Boolean licencia;
}
