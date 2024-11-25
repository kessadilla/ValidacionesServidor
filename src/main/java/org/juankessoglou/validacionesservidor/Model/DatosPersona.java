package org.juankessoglou.validacionesservidor.Model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class DatosPersona {
    @Getter
    private static List<Persona> listaPersonas =
            Stream.of(
                    new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F),
                    new Persona(2L, "Charo", LocalDate.of(2000, 1, 2), 72.36F)
            ).toList();


    public static Persona getPersonaPorId(Long id){
        return listaPersonas.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
