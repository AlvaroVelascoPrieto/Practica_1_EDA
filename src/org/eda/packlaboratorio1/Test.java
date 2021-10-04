package org.eda.packlaboratorio1;

import java.util.ArrayList;

public class Test {

        public static void main(){
            ListaPeliculas.getListaPeliculas().lectorArchivo("ListaPeliculasPequeña.txt");
            ArrayList<Actor> actores = ListaPeliculas.getListaPeliculas().devolverTodosLosActoresOrdenados();
            int i;
            for (i=0; i<actores.size(); i++){
                System.out.println(actores.get(i));
            }
        }
    }

