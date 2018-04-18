package GR2202_RafaelSergio.practica3;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Cine implementada para cumplir la funcionalidad especificada en la
 * Practica 3 de ADSOF
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Cine {
    private String nombre;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Entrada> listaEntradas;
    /**
    * Constructor de la clase Cine
    * @param nombre Nombre del Cine
    * @param direccion Direccion del Cine
    */
    public Cine(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaPeliculas = new ArrayList<Pelicula>();
        this.listaSalas = new ArrayList<Sala>();
        this.listaEntradas = new ArrayList<Entrada>();
    }
    /**
     * Metodo para anadir una Pelicula a la lista de Peliculas del Cine dados sus atributos
     * @param titulo Nombre de la Pelicula
     * @param director Nombre del director de la Pelicula
     * @param anno Ano de la Pelicula
     * @param sinopsis Sinopsis de la Pelicula
     * @param genero Genero de la pelicula
     * @return Pelicula anadida al Cine
     */
    public Pelicula addPelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        Pelicula p = new Pelicula(titulo, director, anno, sinopsis, genero);
        if(this.listaPeliculas.contains(p)){
            return null;
        }
        return this.addPelicula(p);
    }
    /**
     * Metodo para anadir una Pelicula a la lista de Peliculas del Cine dado un objeto Pelicula
     * @param p Pelicula a anadir a la lista
     * @return Pelicula anadida al Cine
     */
    public Pelicula addPelicula(Pelicula p){
        this.listaPeliculas.add(p);
        return p;
    }
    /**
     * Metodo para anadir una Sala al Cine dados sus atributos
     * @param numButacasFila Numero de butacas por fila
     * @param numButacasColumna Numero de butacas por columna
     * @return Sala anadida al Cine
     */
    public Sala addSala(int numButacasFila, int numButacasColumna){
        Sala s = new Sala(numButacasFila, numButacasColumna);
        return this.addSala(s);
    }
    /**
     * Metodo para anadir una Sala al Cine dado un objeto Sala
     * @param s Sala que anadir al Cine
     * @return Sala anadida al Cine
     */
    public Sala addSala(Sala s){
        if(s == null){
            return null;
        }
        this.listaSalas.add(s);
        return s;
    }
    /**
     * Metodo para anadir una Sesion al Cine dados sus atributos
     * @param anno Ano de la Fecha de la Sesion
     * @param mes Mes de la Fecha de la Sesion
     * @param dia Dia de la Fecha de la Sesion
     * @param hora Hora de la Sesion
     * @param minutos Minutos de la Sesion
     * @param pelicula Pelicula que se proyecta en la Sesion
     * @param sala Sala en la que tiene lugar la Sesion
     * @return Sesion anadida al Cine
     */
    public Sesion addSesion(int anno, int mes, int dia, int hora, int minutos, Pelicula pelicula, Sala sala){
        Sesion sesion = new Sesion(anno, mes, dia, hora, minutos, pelicula, sala);
        return this.addSesion(sesion);
    }
    /**
     * Metodo para anadir una Sesion a la lista de Sesiones del Cine
     * @param sesion Objeto Sesion que queremos anadir al Cine
     * @return Sesion anadida al Cine o null en caso de error
     */
    public Sesion addSesion(Sesion sesion){
        if (!sesion.getSala().addSesion(sesion)){
            return null;
        }
        sesion.getPelicula().addSesion(sesion);
        return sesion;
    }
    /**
     * Metodo para vender cierto numero de Entradas para cierta Sesion del Cine
     * @param sesion Sesion de la cual se quieren comprar Entradas
     * @param numEntradas Numero de entradas que queremos comprar
     * @return Booleano indicando si la operacion ha ido bien o no
     */
    public boolean venderEntradas(Sesion sesion, int numEntradas){
        int i;
        if(sesion.getButacasDisponibles() < numEntradas){
            return false;
        }
        if(sesion.getFecha().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
            for (i = 0; i < numEntradas; ++i) {
                listaEntradas.add(new EntradaDiaEspectador());
            }
        }else{
            for (i = 0; i < numEntradas; ++i) {
                listaEntradas.add(new Entrada());
            }
        }
        for(i = 0; i < numEntradas; ++i){
            sesion.actualizarButacasVendidas();
        }
        return true;
    }
    /**
     * Metodo para mostrar los datos de todas las Peliculas que hay en el Cine
     */
    public void showPeliculas(){
        for (Pelicula pelicula : this.listaPeliculas) {
            System.out.println(pelicula);
        }
    }
    /**
     * Metodo para mostrar la recaudacion del Cine
     */
    public void showRecaudacion(){
        float total = 0;
        for (Entrada entrada : listaEntradas){
            total += entrada.getPrecio();
        }
        System.out.println("Recaudacion: $" + total);
    }
    /**
     * Metodo para mostrar los datos de todas las Sesiones que hay en el Cine
     */
    public void showSesiones(){
        for (Pelicula pelicula : this.listaPeliculas){
            pelicula.showSesiones();
        }
    }
    /**
     * Getter de una Pelicula concreta del Cine, si existe en el Cine
     * @param titulo Titulo de la Pelicula
     * @param director Director de la Pelicula
     * @param anno Ano de la Pelicula
     * @return Pelicula si la encuentra, en caso contrario null
     */
    public Pelicula getPelicula(String titulo, String director, String anno){
        Pelicula pelicula = new Pelicula(titulo, director, anno, "Sinopsis", Genero.DOCUMENTAL);
        for (Pelicula p : this.listaPeliculas){
            if(p.equals(pelicula)){
                return p;
            }
        }
        return null;
    }
    /**
     * Getter de una Sala concreta del Cine, si existe en el Cine
     * @param id id de la Sala que buscamos
     * @return Sala si la encuentra, en caso contrario null
     */
    public Sala getSala(int id){
        for (Sala s : this.listaSalas){
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    /**
     * Metodo para eliminar una Pelicula concreta del Cine
     * @param pelicula Pelicula a eliminar del Cine
     * @return Booleano que representa el exito o fracaso de la operacion
     */
    public boolean removePelicula(Pelicula pelicula){
        int i=0;
        if (!this.listaPeliculas.contains(pelicula)){
            System.out.println("La pelicula no existe");
            return false;
        }
        for (Pelicula p : this.listaPeliculas){
            if(p.equals(pelicula)){
                p.remove();
                this.listaPeliculas.remove(i);
                return true;
            }
            ++i;
        }
        return false;
    }
    /**
     * Metodo para eliminar una Sala concreta del Cine
     * @param sala Sala a eliminar del Cine
     * @return Booleano que representa el exito o fracaso de la operacion
     */
    public boolean removeSala(Sala sala){
        int i=0;
        if (!this.listaSalas.contains(sala)){
            System.out.println("La sala no existe");
            return false;
        }
        for (Sala s : this.listaSalas){
            if(s.equals(sala)){
                sala.remove();
                this.listaSalas.remove(i);
                return true;
            }
            ++i;
        }
        return false;
    }
}
