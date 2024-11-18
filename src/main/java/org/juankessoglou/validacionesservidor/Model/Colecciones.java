package org.juankessoglou.validacionesservidor.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class Colecciones {
    private static final Map<String, String> listaGeneros = new HashMap<>();
    private static final Map<String, Pais> listaPaises = new HashMap<>();
    private static final Map<String, String> listaMusicas = new HashMap<>();
    private static final Map<String, String> listaAficiones = new HashMap<>();

    static{
        listaGeneros.put("F", "{valid-form.generos-femenino}");
        listaGeneros.put("M", "{valid-form.generos-masculino}");
        listaGeneros.put("O", "{valid-form.generos-otro}");

        listaPaises.put("es", new Pais("{valid-form.paises-pais-espania}", "{valid-form.paises-idioma-castellano}", "34", false, "espania.png"));
        listaPaises.put("fr", new Pais("{valid-form.paises-pais-francia}", "{valid-form.paises-idioma-frances}", "33", false, "francia.png"));
        listaPaises.put("it", new Pais("{valid-form.paises-pais-italia}", "{valid-form.paises-idioma-italiano}", "39", true, "italia.png"));
        listaPaises.put("pt", new Pais("{valid-form.paises-pais-portugal}", "{valid-form.paises-idioma-portugues}", "351", false, "portugal.png"));
        listaPaises.put("en", new Pais("{valid-form.paises-pais-uk}", "{valid-form.paises-idioma-ingles}", "44", true, "uk.png"));

        listaMusicas.put("E", "{valid-form.musicas-electronica}");
        listaMusicas.put("F", "{valid-form.musicas-funky}");
        listaMusicas.put("N", "{valid-form.musicas-newage}");
        listaMusicas.put("P", "{valid-form.musicas-pop}");
        listaMusicas.put("R", "{valid-form.musicas-rock}");

        listaAficiones.put("D", "{valid-form.aficiones-deporte}");
        listaAficiones.put("L", "{valid-form.aficiones-lectura}");
        listaAficiones.put("P", "{valid-form.aficiones-pintura}");
        listaAficiones.put("V", "{valid-form.aficiones-viajes}");
    }

    public static Map<String, String> getListaGeneros() { return listaGeneros; }
    public static Map<String, Pais> getListaPaises() { return listaPaises; }
    public static Map<String, String> getListaMusicas() { return listaMusicas; }
    public static Map<String, String> getListaAficiones() { return listaAficiones; }

}
