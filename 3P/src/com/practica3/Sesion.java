package com.practica3;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase SesionTest que incluye la información sobre las Sesiones en las
 * que se proyectan las Peliculas.
 */
public class Sesion {
    private Calendar fecha;
    private Pelicula pelicula;
    private ArrayList<Butaca> butacas;
    private int butacasDisponibles;
    private Sala sala;

    public Sesion (int anno, int mes, int dia, int hora, int min, Pelicula pelicula, Sala sala) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, anno);
        fecha.set(Calendar.MONTH, mes+1);
        fecha.set(Calendar.DAY_OF_MONTH, dia);
        fecha.set(Calendar.HOUR_OF_DAY, hora);
        fecha.set(Calendar.MINUTE, min);
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

    public boolean actualizarButacasVendidas () {
        int fila = 0, columna = 0;
        if (butacasDisponibles <= 0) {
            return false;
        }

        for (int i = 0; i < this.butacas.size(); i++){
            if (this.butacas.get(i).isFree()){
                fila = i%this.sala.getNumButacasFila();
                columna = (int) Math.floor(i/this.sala.getNumButacasColumna());
                break;
            }
        }
        return actualizarButacasVendidas(fila, columna);
    }

    public boolean actualizarButacasVendidas(int fila, int columna){
        if(fila > this.sala.getNumButacasFila() || columna > this.sala.getNumButacasColumna()){
            return false;
        }
        int index = columna*this.sala.getNumButacasColumna() + fila;
        if (!this.butacas.get(index).isFree()){
            return false;
        }
        this.butacas.get(index).setFree(false);
        butacasDisponibles--;
        return true;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public ArrayList<Butaca> getButacas() {
        return butacas;
    }

    public int getButacasDisponibles() {
        return butacasDisponibles;
    }

    public Sala getSala() {
        return sala;
    }

    public String toString() {
        return this.pelicula.toString() + this.sala.toString() + " - Butacas disponibles: " + this.butacasDisponibles + "\nFecha: " + fecha.getTime().toString() + butacasDisponibles;
    }
}
