package org.eda.packlaboratorio1;

import java.util.ArrayList;
import java.util.HashMap;

public class Pelicula {
    private float recaudacion;
    private ListaActores actores;
    private String nombre;

    //Constructora
    public Pelicula(String pNombre, float pRecaudacion){
        this.actores = new ListaActores();
        this.nombre = pNombre;
        this.recaudacion = pRecaudacion;
    }


    //Métodos
    public void incrementarRecaudacion(float pImporte) {
        //Pre: El atributo recaudación contiene un valor inicial
        //Post: El atributo recaudacion contiene el valor correspondiente a el valor inicial mas el importe de
        // incremento recibido como parámetro del método
        this.recaudacion = this.recaudacion + pImporte;
    }

    public void borrarActor(String pActor){
        this.actores.borrarActor(pActor);
    }

    public void insertarActor(Actor pActor) { actores.insertarActor(pActor); }

    public HashMap<String ,Actor> devolverActores (){
        return actores.devolverActores();
    }


}
