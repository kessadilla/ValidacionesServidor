package org.juankessoglou.validacionesservidor.Model;

import lombok.Getter;
import org.juankessoglou.validacionesservidor.exception.PersonaNoEncontradaException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatosPersona {
    @Getter
    private static List<Persona> listaPersonas =
            Stream.of(
                    new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F),
                    new Persona(2L, "Charo", LocalDate.of(2000, 1, 2), 72.36F)
            ).collect(Collectors.toList());


    public static Persona getPersonaPorId(Long id){
        return listaPersonas.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void eliminarTodasPersonas(){
        listaPersonas.clear();
    }

    public static Boolean addPersona(Persona persona){
        //noinspection SimplifiableConditionalExpression
        return listaPersonas.stream()
                .anyMatch(p -> p.getId().equals(persona.getId())) ? false : listaPersonas.add(persona);
    }

    public static Boolean eliminarPersona(Persona persona){
        return listaPersonas.remove(listaPersonas.stream()
                .filter(p -> p.getId().equals(persona.getId()))
                .findFirst()
                .orElse(null));
    }

    public static Boolean actualizarPersona(Persona persona){
        Persona personaActual = getPersonaPorId(persona.getId());
        if(personaActual!=null){
            personaActual.setNombre(persona.getNombre());
            personaActual.setPeso(persona.getPeso());
            personaActual.setFechaNacimiento(persona.getFechaNacimiento());
            return true;
        }
        return false;
    }
}
