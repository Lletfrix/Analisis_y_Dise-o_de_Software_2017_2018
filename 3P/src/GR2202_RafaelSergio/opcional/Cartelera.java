package GR2202_RafaelSergio.opcional;
import GR2202_RafaelSergio.practica3.Genero;
import GR2202_RafaelSergio.practica3.Pelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cartelera implementada para cumplir la funcionalidad especificada en la
 * Practica 3 de ADSOF
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
 public class Cartelera {
    private ArrayList<Pelicula> peliculas;
    public Cartelera() {
        this.peliculas = new ArrayList<Pelicula>();
    }
    /**
     * Getter de la lista de Peliculas de la Cartelera
     * @return Lista de Peliculas de la Cartelera
     */
    public List<Pelicula> getPeliculas(){
        return this.peliculas;
    }
    /**
     * Metodo para anadir una Pelicula a la lista de Peliculas de la Cartelera dado un objeto Pelicula
     * @param p Pelicula a anadir a la lista
     * @return Pelicula anadida a la Cartelera
     */
    public Pelicula addPelicula(Pelicula p){
        this.peliculas.add(p);
        return p;
    }
    /**
     * Metodo para anadir una Pelicula a la lista de Peliculas de la Cartelera dados sus atributos
     * @param titulo Nombre de la Pelicula
     * @param director Nombre del director de la Pelicula
     * @param anno Ano de la Pelicula
     * @param sinopsis Sinopsis de la Pelicula
     * @param genero Genero de la pelicula
     * @return Pelicula anadida a la Cartelera
     */
    public Pelicula addPelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        Pelicula p = new Pelicula(titulo, director, anno, sinopsis, genero);
        if(this.peliculas.contains(p)){
            return null;
        }
        return this.addPelicula(p);
    }
    /**
     * Metodo para eliminar una Pelicula concreta de la Cartelera
     * @param pelicula Pelicula a eliminar de la Cartelera
     * @return Booleano que representa el exito o fracaso de la operacion
     */
    public boolean removePelicula(Pelicula pelicula){
        int i=0;
        if (!this.peliculas.contains(pelicula)){
            System.out.println("La pelicula no existe");
            return false;
        }
        for (Pelicula p : this.peliculas){
            if(p.equals(pelicula)){
                p.remove();
                this.peliculas.remove(i);
                return true;
            }
            ++i;
        }
        return false;
    }
    /**
     * Metodo para mostrar los datos de todas las Peliculas que hay en Cartelera
     */
    public void showPeliculas(){
        //String res = "";
        for (Pelicula pelicula : this.peliculas) {
            System.out.println(pelicula);
        }
    }
}
