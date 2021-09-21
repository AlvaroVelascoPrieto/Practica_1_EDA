package org.eda.packlaboratorio1;


import java.util.HashMap;

public class ListaPeliculas {
    private HashMap<String,Pelicula> peliculas;
    private ListaActores todos;
    private static ListaPeliculas miLista;

    //Constructora
    private ListaPeliculas(){
        this.peliculas = new HashMap<String,Pelicula>();
        this.todos = new ListaActores();
    }

    //Patron singleton que devuelve la unica instancia de ListaPeliculas
    public static ListaPeliculas getListaPeliculas() {
        if(ListaPeliculas.miLista==null) {
            ListaPeliculas.miLista = new ListaPeliculas();
        }
        return miLista;
    }

    //Métodos


}
