package org.eda.packlaboratorio1;
import org.eda;
import org.eda.packlaboratorio1.Actor;
import org.eda.packlaboratorio1.ListaPeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPeliculasTest {

    Actor a1;
    Actor a2;
    Actor a3;
    Pelicula p1;
    Pelicula p2;
    Pelicula p3;
    ListaPeliculas lp1;
    ListaPeliculas lp2;
    ListaActores la1;
    ListaActores la2;
    ListaActores la3;

    @Before
    public void setUp() throws Exception {

        a1 = new Actor("Alberto");
        a2 = new Actor("David");
        a3 = new Actor("Alvaro");
        p1 = new Pelicula(1000, la1, "Lo imposible");
        p2 = new Pelicula(1500, la2, "Oblivion");
        p3 = new Pelicula(500, la3, "Harry Potter");
        lp1 = ListaPeliculas.getListaPeliculas();
        la1 = new ListaActores();
        la2 = new ListaActores();
        la3 = new ListaActores();
        lp2 = ListaPeliculas.getListaPeliculas();

    }

    @After
    public void tearDown() throws Exception {
        a1 = null;
        a2 = null;
        a3 = null;
        p1 = null;
        p2 = null;
        p3 = null;
        la1 = null;
        la2 = null;
        la3 = null;
        lp1 = null;
        lp2 = null;
    }

    @Test
    public void testGetListaPeliculas() {
        assertNotNull(lp1);
    }

    @Test
    public void testBuscarActor() {
        assertEquals(lp1.buscarActor(a1.getNombre()), a1.nombre);
    }

    @Test
    public void testIncrementarRecaudacion() {
        assertEquals(lp1.incrementarRecaudacion(p1.nombre, 500), 1500);
    }

    @Test
    public void testInsertarActor() {
        lp1.insertarActor(a1);
        lp1.insertarActor(a2);
        lp2.insertarActor(a1);
        lp2.insertarActor(a2);
        lp2.insertarActor(a3);

        assertEquals(lp2.todos, lp1.insertarActor(a3.getNombre()));

    }

    @Test
    public void testBorrarActor() {
        lp1.insertarActor(a1);
        lp1.insertarActor(a2);
        lp1.insertarActor(a3);
        lp2.insertarActor(a1);
        lp2.insertarActor(a2);


        assertEquals(lp2.todos, lp1.borrarActor(a3.getNombre()));
    }

    @Test
    public void testDevolverActores() {
        lp1.insertarActor(a1);
        lp1.insertarActor(a2);
        lp1.insertarActor(a3);

        assertEquals(lp1.devolverActores(pPelicula), );
    }

    @Test
    public void testDevolverPeliculas() {
    }

    @Test
    public void testDevolverTodosLosActoresOrdenados() {
    }

}
