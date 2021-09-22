package org.eda.packlaboratorio1;

public class Pelicula {
    private float recaudacion;
    private String nombre;

    //Constructora
    public Pelicula(String pNombre, float pRecaudacion){
        this.nombre = pNombre;
        this.recaudacion = pRecaudacion;
    }

    //otros métodos


    //Métodos
    public void incrementarRecaudacion(float pImporte) {
        //Pre: El atributo recaudación contiene un valor inicial
        //Post: El atributo recaudacion contiene el valor correspondiente a el valor inicial mas el importe de
        // incremento recibido como parámetro del método
        this.recaudacion = this.recaudacion + pImporte;
    }
}
