package GR2202_RafaelSergio.test;

import GR2202_RafaelSergio.practica3.Genero;
import GR2202_RafaelSergio.practica3.Pelicula;
import GR2202_RafaelSergio.practica3.Sala;
import GR2202_RafaelSergio.practica3.Sesion;

public class PeliculaTest {

    public static void main(String[] args) {

        int numTests, totalTests;
        numTests=totalTests=0;

        String titulo = "Los Teletubbies";
        String director = "Magia";
        String anno = "1992";
        String sinopsis = "5 furries siguen la voz de un narrador que les dicta lo que tienen que hacer de " +
                          "forma continua.";
        Pelicula p = new Pelicula(titulo, director, anno,  sinopsis, Genero.SUSPENSE);
        Sala sala = new Sala(15, 15);
        Sesion s = new Sesion(2018, 3, 27, 23, 30, p, sala);

        if(p.getSinopsis().equals(sinopsis) && p.getDirector().equals(director) && p.getAnno().equals(anno) &&
                p.getTitulo().equals(titulo) && p.getGenero().equals(Genero.SUSPENSE)){
            System.out.println("Los getters funcionan correctamente.");
            numTests++;
        }
        totalTests++;

        titulo = titulo+" atacan de nuevo";
        director = director+" de la buena";
        anno = "1994";
        sinopsis = sinopsis + " Parte 2";
        p.setAnno(anno);
        p.setDirector(director);
        p.setSinopsis(sinopsis);
        p.setTitulo(titulo);
        if(p.getSinopsis().equals(sinopsis) && p.getDirector().equals(director) && p.getAnno().equals(anno) &&
                p.getTitulo().equals(titulo) && p.getGenero().equals(Genero.SUSPENSE)){
            System.out.println("Los setters funcionan correctamente.");
            numTests++;
        }
        totalTests++;

        p.addSesion(s);
        System.out.println("Mostrando informacion de las sesiones...");
        p.showSesiones();
        numTests++;totalTests++;
        System.out.println("Se pueden anadir sesiones correctamente");
        System.out.println("Mostrando informacion de la pelicula...");
        System.out.println(p);
        System.out.println(numTests+"/"+totalTests+" test(s) fueron correctos.");
    }
}
