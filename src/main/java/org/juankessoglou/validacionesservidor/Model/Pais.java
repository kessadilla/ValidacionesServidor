package org.juankessoglou.validacionesservidor.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Pais {
    private String pais;
    private String idioma;
    private String prefijoTelefonicoPais;
    private boolean muestraIdioma;
    private String nombreArchivoBandera;

}
