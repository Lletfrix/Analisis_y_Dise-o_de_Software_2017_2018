package com.practica3;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Cine implementada para cumplir la funcionalidad especificada en la
 * Práctica 3 de ADSOF
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Cine {
    private String nombre;
    private String direccion;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Entrada> listaEntradas;
    private Cartelera cartelera
    /**
    * Constructor de la clase Cine
    * @param nombre Nombre del Cine
    * @param direccion Direccion del Cine
    */
    public Cine(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaSalas = new ArrayList<Sala>();
        this.cartelera = new Cartelera();
        this.listaEntradas = new ArrayList<Entrada>();
    }
    /**
     * Método para añadir una Película a la Cartelera del Cine dados sus atributos
     * @param titulo Nombre de la Película
     * @param director Nombre del director de la Película
     * @param anno Año de la Película
     * @param sinopsis Sinopsis de la Película
     * @param genero Género de la película
     * @return Película añadida al Cine
     */
    public Pelicula addPelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        return this.addPelicula(String titulo, String director, String anno, String sinopsis, Genero genero);
    }
    /**
     * Método para añadir una Película a la lista de Películas del Cine dado un objeto Película
     * @param p Película a añadir a la lista
     * @return Película añadida al Cine
     */
    public Pelicula addPelicula(Pelicula p){
        this.cartelera.addPelicula(p);
        return p;
    }
    /**
     * Método para añadir una Sala al Cine dados sus atributos
     * @param numButacasFila Número de butacas por fila
     * @param numButacasColumna Número de butacas por columna
     * @return Sala añadida al Cine
     */
    public Sala addSala(int numButacasFila, int numButacasColumna){
        Sala s = new Sala(numButacasFila, numButacasColumna);
        return this.addSala(s);
    }
    /**
     * Método para añadir una Sala al Cine dado un objeto Sala
     * @param s Sala que añadir al Cine
     * @return Sala añadida al Cine
     */
    public Sala addSala(Sala s){
        if(s == null){
            return null;
        }
        this.listaSalas.add(s);
        return s;
    }
    /**
     * Método para añadir una Sesión al Cine dados sus atributos
     * @param anno Año de la Fecha de la Sesión
     * @param mes Mes de la Fecha de la Sesión
     * @param dia Día de la Fecha de la Sesión
     * @param hora Hora de la Sesión
     * @param minutos Minutos de la Sesión
     * @param pelicula Película que se proyecta en la Sesión
     * @param sala Sala en la que tiene lugar la Sesión
     * @return Sesión añadida al Cine
     */
    public Sesion addSesion(int anno, int mes, int dia, int hora, int minutos, Pelicula pelicula, Sala sala){
        Sesion sesion = new Sesion(anno, mes, dia, hora, minutos, pelicula, sala);
        return this.addSesion(sesion);
    }
    /**
     * Método para añadir una Sesión a la lista de Sesiones del Cine
     * @param sesion Objeto Sesión que queremos añadir al Cine
     * @return Sesión añadida al Cine o null en caso de error
     */
    public Sesion addSesion(Sesion sesion){
        if (!sesion.getSala().addSesion(sesion)){
            return null;
        }
        sesion.getPelicula().addSesion(sesion);
        return sesion;
    }
    /**
     * Método para vender cierto número de Entradas para cierta Sesión del Cine
     * @param sesion Sesión de la cual se quieren comprar Entradas
     * @param numEntradas Número de entradas que queremos comprar
     * @return Booleano indicando si la operación ha ido bien o no
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
     * Método para mostrar los datos de todas las Películas que hay en el Cine
     */
    public void showPeliculas(){
        for (Pelicula pelicula : this.cartelera.getPeliculas()) {
            System.out.println(pelicula);
        }
    }
    /**
     * Método para mostrar la recaudación del Cine
     */
    public void showRecaudacion(){
        float total = 0;
        for (Entrada entrada : listaEntradas){
            total += entrada.getPrecio();
        }
        System.out.println("Recaudacion: $" + total);
    }
    /**
     * Método para mostrar los datos de todas las Sesiones que hay en el Cine
     */
    public void showSesiones(){
        for (Pelicula pelicula : this.cartelera.getPeliculas()){
            pelicula.showSesiones();
        }
    }
    /**
     * Getter de una Película concreta del Cine, si existe en el Cine
     * @param titulo Título de la Película
     * @param director Director de la Película
     * @param anno Año de la Película
     * @return Película si la encuentra, en caso contrario null
     */
    public Pelicula getPelicula(String titulo, String director, String anno){
        Pelicula pelicula = new Pelicula(titulo, director, anno, "Sinopsis", Genero.DOCUMENTAL);
        for (Pelicula p : this.cartelera.getPeliculas()){
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
     * Método para eliminar una Película concreta del Cine
     * @param pelicula Película a eliminar del Cine
     * @return Booleano que representa el éxito o fracaso de la operación
     */
    public boolean removePelicula(Pelicula pelicula){
        int i=0;
        if (!this.cartelera.getPeliculas().contains(pelicula)){
            System.out.println("La pelicula no existe");
            return false;
        }
        for (Pelicula p : this.cartelera.getPeliculas()){
            if(p.equals(pelicula)){
                p.remove();
                this.cartelera.getPeliculas().remove(i);
                return true;
            }
            ++i;
        }
        return false;
    }
    /**
     * Método para eliminar una Sala concreta del Cine
     * @param sala Sala a eliminar del Cine
     * @return Booleano que representa el éxito o fracaso de la operación
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
