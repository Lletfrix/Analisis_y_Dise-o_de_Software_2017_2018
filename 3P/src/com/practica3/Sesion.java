package com.practica3;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase Sesion implementada para cumplir la funcionalidad especificada en la
 * Práctica 3 de ADSOF
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Sesion {
    private Calendar fecha;
    private Pelicula pelicula;
    private ArrayList<Butaca> butacas;
    private int butacasDisponibles;
    private Sala sala;
    /**
     * Constructor de la clase Sesion
     * @param anno Año de la Fecha de la Sesión
     * @param mes Mes de la Fecha de la Sesión
     * @param dia Día de la Fecha de la Sesión
     * @param hora Hora de la Sesión
     * @param min Minutos de la hora de la Sesión
     * @param pelicula Película de la Sesión
     * @param sala Sala de la Película
     */
    public Sesion (int anno, int mes, int dia, int hora, int min, Pelicula pelicula, Sala sala) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, anno);
        fecha.set(Calendar.MONTH, mes-1);
        fecha.set(Calendar.DAY_OF_MONTH, dia);
        fecha.set(Calendar.HOUR_OF_DAY, hora);
        fecha.set(Calendar.MINUTE, min);
        fecha.set(Calendar.SECOND, 0);
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.sala = sala;
        butacasDisponibles = this.sala.calcularButacas();
        this.butacas = new ArrayList<Butaca>();
        for ( int i = 0; i < this.sala.getNumButacasFila() ; ++i ) {
            for (int j = 0; j < this.sala.getNumButacasColumna() ; ++j){
                this.butacas.add(new Butaca(i, j));
            }
        }
    }
    /**
     * Método para intentar cambiar el estado de una Butaca tras comprobar que hay alguna libre
     * @return Booleano que representa si la operación ha ido con éxito o no
     */
    public boolean actualizarButacasVendidas () {
        int fila = 0, columna = 0;
        if (butacasDisponibles <= 0) {
            return false;
        }

        for (int i = 0; i < this.butacas.size(); i++){
            if (this.butacas.get(i).isFree()){
                fila = i%this.sala.getNumButacasFila();
                columna = (int) Math.floor(i/this.sala.getNumButacasFila());
                break;
            }
        }
        return actualizarButacasVendidas(fila, columna);
    }
    /**
     * Método auxiliar para actualizarButacasVendidas en el que le pasamos la fila y la columna de la Butaca que queremos
     * @param fila Fila de la Butaca que queremos
     * @param columna Columna de la Butaca que queremos
     * @return Booleano que representa si la operación ha ido con éxito o no
     */
    public boolean actualizarButacasVendidas(int fila, int columna){
        if(fila > this.sala.getNumButacasFila() || columna > this.sala.getNumButacasColumna()){
            return false;
        }
        int index = columna*this.sala.getNumButacasFila() + fila;
        if (!this.butacas.get(index).isFree()){
            return false;
        }
        this.butacas.get(index).setFree(false);
        butacasDisponibles--;
        return true;
    }
    /**
     * Getter de la Fecha de la Sesión
     * @return Fecha de la Sesión
     */
    public Calendar getFecha() {
        return fecha;
    }
    /**
     * Getter de la Película de la Sesión
     * @return Película de la Sesión
     */
    public Pelicula getPelicula() {
        return pelicula;
    }
    /**
     * Getter de la lista de Butacas de la Sesión
     * @return Lista de Butacas de la Sesión
     */
    public ArrayList<Butaca> getButacas() {
        return butacas;
    }
    /**
     * Getter del número de Butacas disponibles de la Sesión
     * @return Número de Butacas disponibles
     */
    public int getButacasDisponibles() {
        return butacasDisponibles;
    }
    /**
     * Getter de la Sala de la Sesión
     * @return Sala de la Sesión
     */
    public Sala getSala() {
        return sala;
    }
    /**
     * Método para retirar una Sesión del Cine
     * @return Booleano representando el éxito o fallo de la operación
     */
    public boolean remove(){
        this.pelicula.removeSesion(this);
        this.sala.removeSesion(this);
        return true;
    }
    /**
     * Sustitución del toString estándar para la clase Sesión
     * @return String con la información de la Sesión
     */
    @Override
    public String toString() {
        return this.pelicula.toString() + this.sala.toString() + " - Butacas disponibles: " + this.butacasDisponibles + "\nFecha: " + fecha.getTime().toString();
    }
    /**
     * Sustitución del equals estándar para la clase Sesión
     * @param object Sesión con la que comparar
     * @return Booleano representando si son iguales o no
     */
    @Override
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Sesion s = (Sesion) object;
            if (this.fecha.equals(s.fecha) && this.pelicula.equals(s.pelicula) && this.sala.equals(s.sala)) {
                result = true;
            }
        }
        return result;
    }
}
