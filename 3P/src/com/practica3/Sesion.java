package com.practica3;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase Sesion que incluye la información sobre las Sesiones en las
 * que se proyectan las Peliculas.
 */
public class Sesion {
    private Calendar fecha;
    private Pelicula pelicula;
    private ArrayList<Butaca> butacas;
    private int butacasDisponibles;
    private Sala sala;

    public Sesion (Calendar fecha, Pelicula pelicula, Sala sala) {
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.sala = sala;
        butacasDisponibles = this.sala.calcularButacas();
        this.butacas = new ArrayList<Butaca>();
        for ( int i = 0; i < this.sala.getNumButacasFila() ; ++i ) {
            for (int j = 0; i < this.sala.getNumButacasColumna() ; ++j){
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
                columna = i - fila;
                break;
            }
        }
        actualizarButacasVendidas(fila, columna);
        return true;
    }

    public boolean actualizarButacasVendidas(int fila, int columna){
        int index = fila*this.sala.getNumButacasColumna() + columna;
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
        return this.pelicula.toString() + this.sala.toString() + fecha + butacasDisponibles;
    }
}
