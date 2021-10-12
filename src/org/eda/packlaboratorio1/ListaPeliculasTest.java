package org.eda.packlaboratorio1;

import static org.junit.jupiter.api.Assertions.
import static org.junit.Assert.

class ListaPeliculasTest {
    private ListaPeliculas miListaPeliculas;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        miListaPeliculas = ListaPeliculas.getListaPeliculas();
    }

    @org.junit.jupiter.api.Test
    void getListaPeliculas() {
        assertNotEquals(miListaPeliculas, null);
    }

    @org.junit.jupiter.api.Test
    void lectorArchivo() {
    }

    @org.junit.jupiter.api.Test
    void buscarActor() {
    }

    @org.junit.jupiter.api.Test
    void incrementarRecaudacion() {
    }

    @org.junit.jupiter.api.Test
    void borrarActor() {
    }

    @org.junit.jupiter.api.Test
    void insertarActor() {
    }

    @org.junit.jupiter.api.Test
    void devolverActores() {
    }

    @org.junit.jupiter.api.Test
    void devolverPeliculas() {
    }

    @org.junit.jupiter.api.Test
    void guardarListaEnFichero() {
    }

    @org.junit.jupiter.api.Test
    void devolverTodosLosActoresOrdenados() {
    }
}