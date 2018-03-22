package GR2202_RafaelSergio.test;

import GR2202_RafaelSergio.practica3.*;

public class CineTest {

    public static void main (String[] args){
        Cine cine = new Cine("Cinemas7", "C/Erasmo de Rotterdam, 7, 28049, Madrid");
        int numTests, totalTests;
        numTests = totalTests = 0;
        Pelicula p1;
        Sala s1;
        Sesion sesion;

        p1 = cine.addPelicula("Los Teletubbies", "Magia", "1992", "Un grupo de amigos de 5 furries" +
                " que siguen la voz de un narrador sin control", Genero.SUSPENSE);
        if(p1 != null){
            System.out.println("Puede añadir una pelicula al cine");
            numTests++;
        }
        totalTests++;

        s1 = cine.addSala(15, 30);
        if(s1 != null){
            System.out.println("Puede añadir una sala al cine");
            numTests++;
        }
        totalTests++;

        sesion = cine.addSesion(2018, 03, 27, 23, 30, p1, s1);
        if(sesion != null){
            System.out.println("Puede añadir una sesion dada una pelicula y una sala.");
            numTests++;
        }
        totalTests++;

        s1 = cine.addSala(10, 20);
        if(s1 != null){
            System.out.println("Puede añadir una sala nueva al cine");
            numTests++;
        }
        totalTests++;

        s1 = cine.getSala(1);
        sesion = cine.addSesion(2018, 03, 27, 23, 30, p1, s1);
        if(sesion == null){
            System.out.println("No puede añadir una sesion a una sala ocupada. Puede encontrar una sala dado su id");
            numTests++;
        }
        totalTests++;

        p1 = cine.addPelicula("A", "B", "C", "D", Genero.ACCION);
        sesion = cine.addSesion(2018, 03, 27, 18, 30, p1, cine.getSala(2));

        p1 = cine.getPelicula("Los Teletubbies", "Magia", "1992");
        if(p1 != null){
            System.out.println("Se puede encontrar una pelicula dados ciertos parametros.");
            numTests++;
        }
        totalTests++;

        sesion = p1.getSesion(2018, 03, 27, 23, 30);
        if(sesion != null){
            System.out.println("Se puede encontrar una sesion en la lista de sesiones de una pelicula.");
            numTests++;
        }
        totalTests++;

        if(cine.venderEntradas(sesion, 450)){
            System.out.println("Se pueden vender todas las entradas de una sala");
            numTests++;
        }
        totalTests++;

        if(!cine.venderEntradas(sesion, 1)){
            System.out.println(("No se pueden vender mas entradas de las totales"));
            numTests++;
        }
        totalTests++;

        System.out.println("Mostrando la lista de peliculas...");
        cine.showPeliculas();
        System.out.println("Mostrando la lista de sesiones...");
        cine.showSesiones();
        System.out.println("Mostrando la recaudacion...");
        cine.showRecaudacion();

        if(cine.removePelicula(cine.getPelicula("Los Teletubbies", "Magia", "1992"))){
            System.out.println("Se puede borrar una pelicula y sus sesiones de forma satisfactoria.");
            numTests++;
        }
        totalTests++;


        System.out.println("Mostrando la lista de peliculas...");
        cine.showPeliculas();
        System.out.println("Mostrando la lista de sesiones...");
        cine.showSesiones();
        System.out.println("Mostrando la recaudacion...");
        cine.showRecaudacion();

        if(cine.removeSala(cine.getSala(2))){
            System.out.println("Se puede borrar una sala y sus sesiones de forma satisfactoria.");
            numTests++;
        }
        totalTests++;

        System.out.println("Mostrando la lista de peliculas...");
        cine.showPeliculas();
        System.out.println("Mostrando la lista de sesiones...");
        cine.showSesiones();
        System.out.println("Mostrando la recaudacion...");
        cine.showRecaudacion();

        System.out.println(numTests+"/"+totalTests+" test(s) fueron correctos.");
    }
}
