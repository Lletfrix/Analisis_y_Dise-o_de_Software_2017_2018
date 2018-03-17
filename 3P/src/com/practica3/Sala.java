package com.practica3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Sala{
    private static int idSerial = 1;
    private final int id;
    private int numButacasFila;
    private int numButacasColumna;
    private ArrayList<Sesion> sesiones;

    public Sala(int numButacasFila, int numButacasColumna){
        this.id = this.idSerial;
        this.numButacasFila = numButacasFila;
        this.numButacasColumna = numButacasColumna;
        this.sesiones = new ArrayList<Sesion>();
        this.idSerial++;
    }

    public int getId() {
        return id;
    }

    public int getNumButacasFila() {
        return numButacasFila;
    }

    public int getNumButacasColumna() {
        return numButacasColumna;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void setNumButacasFila(int numButacasFila) {
        this.numButacasFila = numButacasFila;
    }

    public void setNumButacasColumna(int numButacasColumna) {
        this.numButacasColumna = numButacasColumna;
    }

    private boolean isSalaDisponible(Calendar fecha){
        int i;
        for(i = 0; i < sesiones.size(); i++){
            if (sesiones.get(i).getFecha() == fecha){
                return false;
            }
        }
        return true;
    }

    public Boolean addSesion(Sesion sesion){
        if(isSalaDisponible(sesion.getFecha())){
            sesiones.add(sesion);
            return true;
        }
        return false;
    }

    public int calcularButacas(){
        return (this.numButacasFila*this.numButacasColumna);
    }

    public String toString(){
        return "Sala: " + id;
    }
}
