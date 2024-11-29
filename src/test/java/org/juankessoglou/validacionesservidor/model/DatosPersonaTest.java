package org.juankessoglou.validacionesservidor.model;

import org.juankessoglou.validacionesservidor.Model.DatosPersona;
import org.juankessoglou.validacionesservidor.Model.Persona;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    public void testGetPersonaPorId_NoEncontrado(){

        Persona personaRecuperada = DatosPersona.getPersonaPorId(3L);

        assertNull(personaRecuperada);
    }

    @Test
    public void testAddPersona_YaExiste(){

        Long id = 1L;

        Persona personaPrueba = new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F);

        assertFalse(DatosPersona.addPersona(personaPrueba));

    }

    @Test
    public void testAddPersona_NoExiste(){

        Long id = 3L;

        Persona personaPrueba = new Persona(id, "Lolo", LocalDate.of(2023,3,23), 45.36F);

        assertTrue(DatosPersona.addPersona(personaPrueba));
    }

    @Test
    public void listaContiene2Personas(){
        List<Persona> listaPersonas = DatosPersona.getListaPersonas();

        assertEquals(1, listaPersonas.size());
    }

    @Test
    public void testEliminaPersonaPorId_Existe(){
        Long id = 1L;

        Persona personaPrueba = new Persona(id, "Pepe", LocalDate.of(2000,1,2), 72.36F);

        assertTrue(DatosPersona.eliminarPersona(personaPrueba));
    }

    @Test
    public void testEliminaPersonaPorId_NoExiste(){
        Long id = 5L;

        Persona personaPrueba = new Persona(id, "Pepe", LocalDate.of(2000,1,2), 72.36F);

        assertFalse(DatosPersona.eliminarPersona(personaPrueba));
    }

    @Test public void testActualizarPersona_NoExiste(){
        Long id = 4L;

        Persona prueba = new Persona(id, "Pepe", LocalDate.of(2000,1,2), 72.36F);
        assertFalse(DatosPersona.actualizarPersona(prueba));
    }

    @Test public void testActualizarPersona_Existe(){
        Long id = 1L;

        Persona prueba = new Persona(id, "Pepe", LocalDate.of(2000,1,2), 72.36F);
        assertTrue(DatosPersona.actualizarPersona(prueba));
    }
}
