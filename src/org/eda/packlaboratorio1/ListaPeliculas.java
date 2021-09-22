package org.eda.packlaboratorio1;


import java.util.HashMap;

public class ListaPeliculas {
    private HashMap<String,Pelicula> peliculas;
    private ListaActores todos;
    private static ListaPeliculas miListaPeliculas;

    //Constructora
    private ListaPeliculas(){
        this.peliculas = new HashMap<String,Pelicula>();
        this.todos = new ListaActores();
    }

    //Patron singleton que devuelve la unica instancia de ListaPeliculas
    public static ListaPeliculas getListaPeliculas() {
        if(ListaPeliculas.miListaPeliculas==null) {
            ListaPeliculas.miListaPeliculas = new ListaPeliculas();
        }
        return miListaPeliculas;
    }

    //Otros Métodos
    public Actor buscarActor(String pNombre){
        //Pre: el método recibe un string que representa el nombre del actor abuscar
        //Post: el método devuelve un actor de la manera especificada en el método buscarActor de la clase ListaActores
        return ListaPeliculas.getListaPeliculas().todos.buscarActor(pNombre);
    }

    public void incrementarRecaudacion(String pPelicula, float pImporte){
        //Pre: La película con el titulo que recibe este método como parámetro puede estar contenida en nuestra lista o no
        //Post: Si esta pelicula esta contenida en la lista de películas entonces se ejecuta el método
        // incrementar recaudacion de dicha clase sino no se incrementa la recaudacion.
        if(ListaPeliculas.getListaPeliculas().peliculas.containsKey(pPelicula)) {
            ListaPeliculas.getListaPeliculas().peliculas.get(pPelicula).incrementarRecaudacion(pImporte);
        }
    }



}
