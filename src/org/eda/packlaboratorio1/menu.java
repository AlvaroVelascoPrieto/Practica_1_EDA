package org.eda.packlaboratorio1;

public class menu {
    private static menu miMenu;
    private menu(){
        this.iniciar();
    }

    public static menu getMiMenu() {
        if(menu.miMenu==null) {
            menu.miMenu = new menu();
        }
        return getMiMenu();
    }

    public void iniciar(){
        boolean continuar = true;
        while (continuar) {
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
            int numeroPulsado = Teclado.getTeclado().leerInt();
            if (numeroPulsado == 0) {
                this.cargar();
            } else if (numeroPulsado == 1) {
                this.buscarActorActriz();
            } else if (numeroPulsado == 2) {
                this.anadirActor();
            } else if (numeroPulsado == 3) {
                this.obtenerPeliculasDeActor();
            } else if (numeroPulsado == 4) {
                this.obtenerActoresDeUnaPelicula();
            } else if (numeroPulsado == 5) {
                this.incrementarRecaudacion();
            } else if (numeroPulsado == 6) {
                this.eliminarActor();
            } else if (numeroPulsado == 7) {
                this.guardarLosDatosEnFichero();
            } else if (numeroPulsado == 8) {
                this.obtenerListaOrdenadaDeActores();
            } else if (numeroPulsado == 9) {
                break;
            } else {
                System.out.println("El numero introducido no es una opcion del menu");
            }
        }
    }

    private void cargar(){
        System.out.println("Introduce la direccion del archivo que quieras leer: ");
        String direccionArchivo = Teclado.getTeclado().leerString();
        ListaPeliculas.getListaPeliculas().lectorArchivo(direccionArchivo);
    }

    private void buscarActorActriz(){
        System.out.println("Introduce el nombre del actor que deseas buscar: (Apellido, Nombre)");
        String nombreActor = Teclado.getTeclado().leerString();
        ListaPeliculas.getListaPeliculas().buscarActor(nombreActor);
    }

    private void anadirActor(){
        System.out.println("Introduce el nombre del actor que deseas añadir: (Apellido, Nombre)");
        String nombreActor = Teclado.getTeclado().leerString();
        System.out.println("Escribe el nombre de la pelicula en la que participa el actor: ");
        String nombrePelicula = Teclado.getTeclado().leerString();
        ListaPeliculas.getListaPeliculas().insertarActor(nombrePelicula,nombreActor);
    }

    private void obtenerPeliculasDeActor(){
        System.out.println("Introduce el nombre del actor del que quieres obtener las peliculas: (Apellidos, Nombre)");
        //Añadir scanner de teclado
        String nombreActor = Teclado.getTeclado().leerString();
        ListaPeliculas.getListaPeliculas().devolverPeliculas(nombreActor);
    }

    private void obtenerActoresDeUnaPelicula(){
        System.out.println("Introduce el titulo de la pelicula de la que deseas obtener los actores: ");
        String tituloPelicula = Teclado.getTeclado().leerString();
        ListaPeliculas.getListaPeliculas().devolverActores(tituloPelicula);
    }

    private void incrementarRecaudacion(){
        System.out.println("Introduce el titulo de la pelicula de la que quieres incrementar la recaudación: ");
        String tituloPelicula = Teclado.getTeclado().leerString();
        System.out.println("Introduce el importe por el que deseas incrementar la recaudación");
        //Añadir scanner teclado
        double importeIncremento = Teclado.getTeclado().leerDouble();
        ListaPeliculas.getListaPeliculas().incrementarRecaudacion(tituloPelicula,importeIncremento);
    }

    private void eliminarActor(){
        System.out.println("Introduce el nombre del actor o actriz que deseas eliminar (Apellido, Nombre)");
        String nombreActor = Teclado.getTeclado().leerString();;
        ListaPeliculas.getListaPeliculas().borrarActor(nombreActor);
    }

    private void guardarLosDatosEnFichero(){
        System.out.println("Introduce la direccion del fichero en el que quieras escribir los datos: ");
        String direccionArchivo = Teclado.getTeclado().leerString();
        ListaPeliculas.getListaPeliculas().guardarListaEnFichero(direccionArchivo);
    }

    private void obtenerListaOrdenadaDeActores(){
        ListaPeliculas.getListaPeliculas().devolverTodosLosActoresOrdenados();
    }





}
