package org.juankessoglou.validacionesservidor.exception;

public class PersonaNoEncontradaException extends RuntimeException {
    public PersonaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
