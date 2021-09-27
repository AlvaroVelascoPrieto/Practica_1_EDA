package org.eda.packlaboratorio1;

import java.util.HashMap;

public class ListaActores {
    private HashMap<String,Actor> actores;

    //Constructora
    public ListaActores(){
        this.actores = new HashMap<String,Actor>();
    }

    //Otros métodos
    public Actor buscarActor(String pNombre){
        if(this.actores.containsKey(pNombre)) {
            return actores.get(pNombre);
        }
        return null;
    }

    public void insertarActor(String pNombre,Actor pActor) {
        if (!(actores.containsKey(pNombre))) {
            actores.put(pNombre, pActor);
        }
    }

    //public ListaActores ordenarLista(){
    //    ListaActores listaordenada= new ListaActores();

    //}

    public void borrarActor(String pNombre){
        if (actores.containsKey(pNombre)) {
            actores.remove(pNombre);
        }
    }
}
