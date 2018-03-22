package GR2202_RafaelSergio.test;

import GR2202_RafaelSergio.practica3.Genero;
import GR2202_RafaelSergio.practica3.Pelicula;
import GR2202_RafaelSergio.practica3.Sala;
import GR2202_RafaelSergio.practica3.Sesion;

public class SesionTest {

    public static void main(String[] args){
        Sesion sesion;
        Sala sala;
        Pelicula pelicula;
        int numTests = 0, totalTests = 0;

        pelicula = new Pelicula("Los Teletubbies", "Magia", "1992", "5 furries siguen la voz de un narrador" +
                                " que les dicta lo que tienen que hacer de forma continua.", Genero.SUSPENSE);
        sala = new Sala(15, 15);
        sesion = new Sesion(2018, 3, 27, 23, 30, pelicula, sala);

        if(sesion.actualizarButacasVendidas()){
            System.out.println("Se puede asignar una butaca vendida, reduciendo en 1 el numero de butacas disponibles");
            numTests++;
        }
        totalTests++;

        if(sesion.actualizarButacasVendidas(7, 7)){
            System.out.println("Se puede asignar la butaca (7,7) especificamente, reduciendo en 1 el numero de butacas" +
                                " disponibles.");
            numTests++;
        }
        totalTests++;

        if(!sesion.actualizarButacasVendidas(7,7)){
            System.out.println("No se puede asignar una butaca ya asignada.");
            numTests++;
        }
        totalTests++;

        while(sesion.actualizarButacasVendidas());

        if(!sesion.actualizarButacasVendidas()){
            System.out.println("No se puede asignar una butaca si la sala esta llena");
            numTests++;
        }
        totalTests++;

        System.out.println("Mostrando informacion de la sesion...");
        System.out.println(sesion);
        System.out.println(numTests+"/"+totalTests+" test(s) fueron correctos.");
    }
}
