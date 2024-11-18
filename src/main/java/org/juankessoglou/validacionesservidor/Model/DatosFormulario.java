package org.juankessoglou.validacionesservidor.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.juankessoglou.validacionesservidor.Validations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@EdadCoincide(fecha = "fechaNacimiento", edad = "edad")
@ClavesCoinciden(clave1 = "clave", clave2 = "confirmarClave")
@Contacto(email = "email", tlf = "telefono")
public class DatosFormulario {

    @NotBlank @NotNull
    private String nombre = "Lola";

    @NotBlank @NotNull
    @Size(min = 6, max = 12, message = "{valid-form.err.clave.size}")
    @Caracter
    private String clave;

    @NotBlank @NotNull
    @Size(min = 6, max = 12, message = "{valid-form.err.clave.size}")
    @Caracter
    private String confirmarClave;

    @NotNull // TODO checkeo de siglas
    private String generoSeleccionado;

    @NotNull @FechaPasada(18)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;

    @NotNull
    private Integer edad;

    @NotNull
    private Float peso;

    @NotNull // TODO checkeo de prefijos
    private String prefijoTelefonicoPais = "33";

    @NotNull @Telefono
    private String telefono;

    @NotNull @EmailEstricto
    private String email;

    @NotNull
    private String url;

    private String paisSeleccionado = "pt";
    private MultipartFile archivosSeleccionados;

    @MusicaMinima(1)
    private List<String> musicasSeleccionadas = Arrays.asList("F", "R");

    @AficionesMinima(2)
    private List<String> aficionesSeleccionadas  = Arrays.asList("D", "P", "V");

    @NotNull
    private String comentarios;

    @NotNull @CheckboxOn
    private Boolean licencia;
}
