package org.eda.packlaboratorio1;

import java.util.ArrayList;
import java.util.Collection;
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

    public void insertarActor(Actor pActor) {
        if (!(actores.containsValue(pActor))) {
            actores.put(pActor.getNombre(), pActor);
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

    public HashMap<String,Actor> devolverActores(){

        return actores;
    }

    public boolean contiene(String pActor){
        return actores.containsKey(pActor);
    }

    public ArrayList<Actor> ordenarActores() {
        Collection<Actor> values = actores.values();
        ArrayList<Actor> arrayActores = new ArrayList<Actor>(values);
        return this.ordenarPorMezcla(arrayActores);


    }

    public ArrayList<Actor> ordenarPorMezcla(ArrayList<Actor> pArrayActores){

        ArrayList<Actor> izq = new ArrayList<Actor>();
        ArrayList<Actor> der = new ArrayList<Actor>();

        if (pArrayActores.size() == 1) {
            return pArrayActores;
        } else {
            int centro = pArrayActores.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<centro; i++) {
                izq.add(pArrayActores.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i=centro; i<pArrayActores.size(); i++) {
                der.add(pArrayActores.get(i));
            }

            // Sort the left and right halves of the arraylist.
            izq  = ordenarPorMezcla(izq);
            der = ordenarPorMezcla(der);

            // Merge the results back together.
            mezcla(izq, der, pArrayActores);
        }
        return pArrayActores;

    }

    private void mezcla(ArrayList<Actor> izq, ArrayList<Actor> der, ArrayList<Actor> pArrayActores) {
        int indIzq = 0;
        int indDer = 0;
        int indGrande = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (indIzq < izq.size() && indDer < der.size()) {
            if ( (izq.get(indIzq).getNombre().compareTo(der.get(indDer).getNombre())) < 0) {
                pArrayActores.set(indGrande, izq.get(indIzq));
                indIzq++;
            } else {
                pArrayActores.set(indGrande, der.get(indDer));
                indDer++;
            }
            indGrande++;
        }

        ArrayList<Actor> rest;
        int restIndex;
        if (indIzq >= izq.size()) {
            // The left ArrayList has been use up...
            rest = der;
            restIndex = indDer;
        } else {
            // The right ArrayList has been used up...
            rest = izq;
            restIndex = indIzq;
        }


        for (int i=restIndex; i<rest.size(); i++) {
            pArrayActores.set(indGrande, rest.get(i));
            indGrande++;
        }
    }
}
