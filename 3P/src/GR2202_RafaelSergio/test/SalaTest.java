package GR2202_RafaelSergio.test;
import GR2202_RafaelSergio.practica3.Genero;
import GR2202_RafaelSergio.practica3.Pelicula;
import GR2202_RafaelSergio.practica3.Sala;
import GR2202_RafaelSergio.practica3.Sesion;

public class SalaTest {

    public static void main (String[] args){
        Sala sala = new Sala(15, 15);
        int numTests, totalTests;
        numTests = totalTests = 0;
        Pelicula pelicula = new Pelicula("Los Teletubbies", "Magia", "1992", "Un grupo de amigos de 5 furries" +
                                         " que siguen la voz de un narrador sin control", Genero.SUSPENSE);
        Sesion sesion = new Sesion(2018, 03, 27, 23, 30, pelicula, sala);

        if(sala.addSesion(sesion)){
            System.out.println("Se puede añadir una sesion en una sala vacia");
            numTests++;
        }
        totalTests++;

        if(!sala.addSesion(sesion)){
            System.out.println("No se puede añadir una sesion a una sala a una hora en la que la sala este ocupada");
            numTests++;
        }
        totalTests++;

        if(sala.calcularButacas() == 15*15){
            System.out.println("El numero de butacas totales coincide con la multiplicacion de filas y columnas");
            numTests++;
        }
        totalTests++;

        System.out.println("Imprimiento informacion de la sala...");
        System.out.println(sala);
        System.out.println(numTests+"/"+totalTests+" test(s) fueron correctos.");

    }
}
