package org.eda.packlaboratorio1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

            while (archivo.hasNextLine()){
                linea = archivo.nextLine();
                String[] part =linea.split("\\s++-{1,}+>{1,}+\\s");
                String pelicula=part[0];
                String Actores=part[1];

                String[] tablaAct =Actores.split("\\s+#{1,}+\\s");
                peliculas.put(pelicula, new Pelicula(pelicula,0));
                int i=0;
                while (i<(tablaAct.length)){
                    if(todos.contiene(tablaAct[i])){
                        Actor miActor = todos.buscarActor(tablaAct[i]);
                        peliculas.get(pelicula).insertarActor(miActor);
                    }
                    else{
                        Actor miActor = new Actor(tablaAct[i]);
                        peliculas.get(pelicula).insertarActor(miActor);
                        todos.insertarActor(miActor);
                    }
                    i++;
                }
            }
            System.out.println("Leido");
            archivo.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public Actor buscarActor(String pNombre){
        //Pre: el método recibe un string que representa el nombre del actor abuscar
        //Post: el método devuelve un actor de la manera especificada en el método buscarActor de la clase ListaActores
        return todos.buscarActor(pNombre);
    }

    public void incrementarRecaudacion(String pPelicula, double pImporte){
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
        Actor miActor;
        if (todos.contiene(pNombre)){
            miActor = todos.buscarActor(pNombre);
        }
        else {
            miActor = new Actor(pNombre);
        }

        todos.insertarActor(miActor);
        if (peliculas.containsKey(pPelicula)){
            peliculas.get(pPelicula).insertarActor(miActor);
        }
        else{
            peliculas.put(pPelicula,new Pelicula(pPelicula, 0));
            peliculas.get(pPelicula).insertarActor(miActor);
        }

    }

    public HashMap<String, Actor> devolverActores(String pPelicula){
        //Pre: el método recibe un string representando el nombre de la pelicula de la que se desea obtener la lista
        //Post: si esa pelicula existe devuelve un HashMap conteniendo los actores con la siguiente estructura
        //HashMap<String nombreDelActor, Actor instanciaDelObjetoDelActor>
        HashMap<String,Actor> actoresADevolver = new HashMap<String, Actor>();
        if (peliculas.containsKey(pPelicula)){
             actoresADevolver = peliculas.get(pPelicula).devolverActores();
        }
        return actoresADevolver;
    }


    public HashMap<String,Pelicula> devolverPeliculas(String pActor){
        //Pre: el metodo recibe un parametro de tipo String que representa el nombre del actor
        //Post: se busca en cada pelicula si el actor esta en su lista de actores y se devuelve un ArrayList
        //con las peliculas en las que aparece el actor
        HashMap<String, Actor> actores;
        HashMap<String,Pelicula> peliculasADevolver = new HashMap<String,Pelicula>();
        for (Map.Entry<String, Pelicula> entry : peliculas.entrySet()) {
            actores = entry.getValue().devolverActores();
            if (actores.containsKey(pActor)){
                peliculasADevolver.put(entry.getKey(),entry.getValue());
            }
        }
        return peliculasADevolver;
    }

    public void guardarListaEnFichero(String pDireccionFichero){
        FileWriter fichero;
        PrintWriter pw;
        try{
            fichero = new FileWriter(pDireccionFichero);
            pw = new PrintWriter(fichero);
            if (!peliculas.isEmpty()){
                for (Map.Entry<String, Pelicula> entry : peliculas.entrySet()) {
                    pw.print(entry.getKey() + " --->>> ");
                    HashMap<String,Actor> actores = entry.getValue().devolverActores();
                    for (Map.Entry<String, Actor> entryAct : actores.entrySet()){
                        pw.print(entryAct.getKey() + " ##### ");
                    }
                    pw.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Actor> devolverTodosLosActoresOrdenados(){
        return todos.ordenarActores();
    }

    //Metodos para las pruebas
    public double getRecaudacion(String pPelicula){
        return this.peliculas.get(pPelicula).devolverRecaudacion();
    }





}
