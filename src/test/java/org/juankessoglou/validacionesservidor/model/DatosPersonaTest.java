package org.juankessoglou.validacionesservidor.model;

import org.juankessoglou.validacionesservidor.Model.DatosPersona;
import org.juankessoglou.validacionesservidor.Model.Persona;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DatosPersonaTest {

    @Test
    public void testGetPersonaPorId(){
        
        Long empleadoId = 1L;
        Persona personaPrueba = new Persona(empleadoId, "Pepe", LocalDate.of(2000,1,2), 72.36F);

        Persona personaRecuperada = DatosPersona.getPersonaPorId(1L);

        assertNotNull(personaRecuperada);
        assertEquals(personaPrueba.getId(), personaRecuperada.getId());
        assertEquals(personaPrueba.getNombre(), personaRecuperada.getNombre());
        assertEquals(personaPrueba.getFechaNacimiento(), personaRecuperada.getFechaNacimiento());

    }
}
