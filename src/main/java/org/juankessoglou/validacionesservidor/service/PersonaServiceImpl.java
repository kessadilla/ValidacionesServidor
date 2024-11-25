package org.juankessoglou.validacionesservidor.service;

import org.juankessoglou.validacionesservidor.Model.DatosPersona;
import org.juankessoglou.validacionesservidor.Model.Persona;
import org.juankessoglou.validacionesservidor.exception.PersonaNoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Override
    public List<Persona> devuelveTodasPersonas() {
        return DatosPersona.getListaPersonas();
    }

    @Override
    public Persona devuelvePersonaPorId(Long id) {
        Persona p = DatosPersona.getPersonaPorId(id);
        if (p == null) {
            throw new PersonaNoEncontradaException("La persona con id " + id + " no existe.");
        }else{
            return p;
        }
    }

    @Override
    public void creaPersona(Persona persona) {

    }

    @Override
    public void actualizaPersona(Persona persona) {

    }

    @Override
    public void eliminaPersona(Persona persona) {

    }

    @Override
    public void eliminaTodasPersonas() {

    }
}
