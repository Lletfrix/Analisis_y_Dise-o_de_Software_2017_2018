package com.practica3;
/**
 * Clase Butaca implementada para dotar de algo más de realismo a las butacas de
 * la sala, dándoles una fila y una columna concretas.
 *
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Butaca {
    private int fila;
    private int columna;
    private boolean free;
    /**
    * Constructor de la clase Butaca
    * @param fila Fila de la butaca
    * @param columna Columna de la butaca
    */
    public Butaca(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.free = true;
    }
    /**
    * Getter de la fila de la butaca
    * @return Entero que representa la fila de la butaca
    *
    */
    public int getFila() {
        return fila;
    }
    /**
    * Getter de la columna de la butaca
    * @return Entero que representa la columna de la butaca
    *
    */
    public int getColumna() {
        return columna;
    }
    /**
    * Getter del estado de la butaca (libre/ocupado)
    * @return Booleano que representa el estado de la butaca(V-Libre/F-Ocupado)
    *
    */
    public boolean isFree() {
        return free;
    }
    /**
     * Setter del estado de la butaca
     * @param free Booleano 
     *
     */
    public void setFree(boolean free) {
        this.free = free;
    }
}
