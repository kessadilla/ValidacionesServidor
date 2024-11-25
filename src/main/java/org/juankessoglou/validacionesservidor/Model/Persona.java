package org.juankessoglou.validacionesservidor.Model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Data
public class Persona {
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Float peso;
}
