package org.juankessoglou.validacionesservidor.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DatosFormulario {
    @NotBlank
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
    private List<String> musicasSeleccionadas;
    private List<String> aficionesSeleccionadas;
    private String comentarios;
    private Boolean licencia;
}
