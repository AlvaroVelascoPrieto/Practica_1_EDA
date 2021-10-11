package org.eda.packlaboratorio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

        public static void main(String[] args){
            Stopwatch timer = new Stopwatch();
            ListaPeliculas.getListaPeliculas().lectorArchivo("C:/Users/alvar/IdeaProjects/Practica 1/src/org/eda/packlaboratorio1/FilmsActors20212022.txt");
            ListaPeliculas.getListaPeliculas().guardarListaEnFichero("C:/Users/alvar/IdeaProjects/Practica 1/src/org/eda/packlaboratorio1/FicheroActores.txt");
            //ArrayList<Actor> actores = ListaPeliculas.getListaPeliculas().devolverTodosLosActoresOrdenados();
            //int i;
            //for (i=0; i<actores.size(); i++){
            //    System.out.println(actores.get(i).getNombre());
            //}
            //for (Map.Entry<String, Actor> entry : actores.entrySet()) {
            //    System.out.println(entry.getKey());
            //}
            System.out.println(timer.elapsedTime());
        }

        public void menu(){
            System.out.println("MENU PRINCIPAL");
            System.out.println("-0: Cargar los datos");
            System.out.println("-1: Buscar actor/actriz");
            System.out.println("-2: Añadir actor/actriz");
            System.out.println("-3: Obtener las películas de un actor/actriz");
            System.out.println("-4: Obtener los actores/actrices de una película");
            System.out.println("-5: Incrementar la recaudación de una película");
            System.out.println("-6: Eliminar un actor/actriz");
            System.out.println("-7: Guardar los datos en un fichero");
            System.out.println("-8: Obtener lista ordenada de actores");
            System.out.println("-9: Finalizar programa");
        }

        public void cargar(){
            System.out.println("Introduce la direccion del archivo que quieras leer: ");
            String direccionArchivo = Teclado.getTeclado().leerString();
            ListaPeliculas.getListaPeliculas().lectorArchivo(direccionArchivo);
        }

        public void buscarActorActriz(){
            System.out.println("Introduce el nombre del actor que deseas buscar: (Apellido, Nombre)");
            String nombreActor = Teclado.getTeclado().leerString();
            ListaPeliculas.getListaPeliculas().buscarActor(nombreActor);
        }

        public void anadirActor(){
            System.out.println("Introduce el nombre del actor que deseas añadir: (Apellido, Nombre)");
            String nombreActor = Teclado.getTeclado().leerString();
            System.out.println("Escribe el nombre de la pelicula en la que participa el actor: ");
            String nombrePelicula = Teclado.getTeclado().leerString();
            ListaPeliculas.getListaPeliculas().insertarActor(nombrePelicula,nombreActor);
        }

        public void obtenerPeliculasDeActor(){
            System.out.println("Introduce el nombre del actor del que quieres obtener las peliculas: (Apellidos, Nombre)");
            //Añadir scanner de teclado
            String nombreActor = Teclado.getTeclado().leerString();
            ListaPeliculas.getListaPeliculas().devolverPeliculas(nombreActor);
        }

        public void obtenerActoresDeUnaPelicula(){
            System.out.println("Introduce el titulo de la pelicula de la que deseas obtener los actores: ");
            String tituloPelicula = Teclado.getTeclado().leerString();
            ListaPeliculas.getListaPeliculas().devolverActores(tituloPelicula);
        }

        public void incrementarRecaudacion(){
            System.out.println("Introduce el titulo de la pelicula de la que quieres incrementar la recaudación: ");
            String tituloPelicula = Teclado.getTeclado().leerString();
            System.out.println("Introduce el importe por el que deseas incrementar la recaudación");
            //Añadir scanner teclado
            double importeIncremento = Teclado.getTeclado().leerDouble();
            ListaPeliculas.getListaPeliculas().incrementarRecaudacion(tituloPelicula,importeIncremento);
        }

        public void eliminarActor(){
            System.out.println("Introduce el nombre del actor o actriz que deseas eliminar (Apellido, Nombre)");
            String nombreActor = Teclado.getTeclado().leerString();;
            ListaPeliculas.getListaPeliculas().borrarActor(nombreActor);
        }

        public void guardarLosDatosEnFichero(){
            System.out.println("Introduce la direccion del fichero en el que quieras escribir los datos: ");
            String direccionArchivo = Teclado.getTeclado().leerString();
            ListaPeliculas.getListaPeliculas().guardarListaEnFichero(direccionArchivo);
        }

        public void obtenerListaOrdenadaDeActores(){
           ListaPeliculas.getListaPeliculas().devolverTodosLosActoresOrdenados();
        }




    }

