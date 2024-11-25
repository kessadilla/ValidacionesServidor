package org.juankessoglou.validacionesservidor.service;

import org.juankessoglou.validacionesservidor.Model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> devuelveTodasPersonas();
    Persona devuelvePersonaPorId(Long id);
    void creaPersona(Persona persona);
    void actualizaPersona(Persona persona);
    void eliminaPersona(Persona persona);
    void eliminaTodasPersonas();
}
