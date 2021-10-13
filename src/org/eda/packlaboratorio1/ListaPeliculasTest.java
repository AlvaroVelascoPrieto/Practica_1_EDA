package org.eda.packlaboratorio1;
import org.eda;
import org.eda.packlaboratorio1.Actor;
import org.eda.packlaboratorio1.ListaPeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.attribute.DosFileAttributeView;

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
        p1 = new Pelicula("Lo imposible", 2500);
        p2 = new Pelicula("Oblivion", 5000);
        p3 = new Pelicula("Harry Potter", 1000);
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
        assertEquals(lp1.buscarActor(a1.getNombre()), a1);
    }

    @Test
    public void testIncrementarRecaudacion() {
        assertEquals(lp1.incrementarRecaudacion(p1.nombre, 500), 3000);
    }

    @Test
    public void testInsertarActor() {

        la1.insertarActor("David");
        p1.insertarActor("David");
        ListaActores uno = lp1.insertarActor("Oblivion", "David")

        assertEquals(la1, uno.devolverActores());
        asserEquals(p1.devolverActores(), uno.devolverActores());
    }

    @Test
    public void testBorrarActor() {
        lp1.insertarActor("Harry Potter", "Alberto");
        lp1.insertarActor("Harry Potter", "Alvaro");
        ListaActores uno = lp1.borrarActor("Oblivion", "Alberto");
        la1.insertarActor("Alvaro");
        p1.insertarActor("Alvaro");

        assertEquals(la1, uno.devolverActores());
        asserEquals(p1.devolverActores(), uno.devolverActores());
    }

    @Test
    public void testDevolverActores() {
        lp1.insertarActor("Oblivion", "Alberto");
        lp1.insertarActor("Oblivion", "Alvaro");
        lp1.insertarActor("Oblivion", "David");

        la1.insertarActor( "Alberto");
        la1.insertarActor( "Alvaro");
        la1.insertarActor("David");

        assertEquals(la1.devolverActores(), lp1.devolverActores(Oblivion))
    }

    @Test
    public void testDevolverPeliculas() {
    }

    @Test
    public void testDevolverTodosLosActoresOrdenados() {
        lp1.insertarActor("Oblivion", "Alberto");
        lp1.insertarActor("Oblivion", "Alvaro");
        lp1.insertarActor("Oblivion", "David");

        lp1.insertarActor("Oblivion", "David");
        lp1.insertarActor("Oblivion", "Alberto");
        lp1.insertarActor("Oblivion", "Alvaro");

        //Me faltaría un metodo borrar primerActor para hacer un assertEQuals entre lp1 y lp2 despues de haber sido ordenada lp2

    }

}
