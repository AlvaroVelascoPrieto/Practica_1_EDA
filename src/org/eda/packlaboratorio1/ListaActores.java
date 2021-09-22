package org.eda.packlaboratorio1;

import java.util.HashMap;

public class ListaActores {
    private HashMap<String,Actor> actores;

    //Constructora
    public ListaActores(){
        this.actores = new HashMap<String,Actor>();
    }

    //Otros Métodos
    public Actor buscarActor(String pNombre){
        if(this.actores.containsKey(pNombre)) {
            return actores.get(pNombre);
        }
        return null;
    }
}
