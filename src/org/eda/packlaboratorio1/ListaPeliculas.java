package org.eda.packlaboratorio1;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    //Métodos
    public void lectorArchivo(String pNombreArchivo){
        try {
            Scanner archivo = new Scanner(new FileReader(pNombreArchivo));
            String linea;

            while (archivo.hasNext()){
                linea = archivo.nextLine();
                //AÑADIR COMO SEPARAR LOS ELEMENTOS DE LAS LINEAS
            }
        }
        catch (IOException e) {e.printStackTrace();}
    }

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

    public void borrarActor(String pActor){
        //Pre: el metodo recibe un string con el nombre del actor
        //Post: se busca el nombre del actor en todas las peliculas y se borran todas sus apariciones
        //ademas se borra de la lista general de actores
        peliculas.forEach((k,v) -> v.borrarActor(pActor));
        todos.borrarActor(pActor);
    }

    public void insertarActor(String pPelicula, String pNombre){
        //Pre: el método recibe dos strings como parametros representandoel titulo de la pelicula
        //a la que se desea añadir el actor y el nombre del actor
        //Post: el método inserta al actor en la lista general de actores (si no se encuentra presente)
        //y tambien lo inserta en la lista de actores de dicha pelicula si se encuentra ya registrada,
        //sino crea una pelicula con ese titulo e inserta el actor.
        todos.insertarActor(pNombre);
        if (peliculas.containsKey(pPelicula)){
            peliculas.get(pPelicula).insertarActor(pNombre);
        }
        else{
            peliculas.put(pPelicula,new Pelicula(pPelicula, 0));
            peliculas.get(pPelicula).insertarActor(pNombre);
        }

    }

    public HashMap<String, Actor> devolverActores(String pPelicula){
        //Pre: el método recibe un string representando el nombre de la pelicula de la que se desea obtener la lista
        //Post: si esa pelicula existe devuelve un HashMap conteniendo los actores con la siguiente estructura
        //HashMap<String nombreDelActor, Actor instanciaDelObjetoDelActor>
        if (peliculas.containsKey(pPelicula)){
             return peliculas.get(pPelicula).devolverActores();
        }
        else {
            return null;
        }
    }





}
