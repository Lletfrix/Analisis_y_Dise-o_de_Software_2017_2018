package com.practica3;

import java.util.ArrayList;
import java.util.List;

public class Sala{
    private final int id;
    private int butacasFila;
    private int butacasColumna;
    private List<Sesion> sesiones;

    public Sala(int id, int butacasFila, int butacasColumna){
        this.id = id;
        this.butacasFila = butacasFila;
        this.butacasColumna = butacasColumna;
        this.sesiones = new ArrayList<Sesion>();
    }

    public int getId() {
        return id;
    }

    public int getButacasFila() {
        return butacasFila;
    }

    public int getButacasColumna() {
        return butacasColumna;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setButacasFila(int butacasFila) {
        this.butacasFila = butacasFila;
    }

    public void setButacasColumna(int butacasColumna) {
        this.butacasColumna = butacasColumna;
    }

    public Boolean addSesion(Sesion sesion){
        int i;
        for(i = 0; i < sesiones.size(); i++){
            if (sesiones.get(i).getFecha() == sesion.getFecha()){
                return false;
            }
        }
        sesiones.add(sesion);
        return true;
    }

    public int calcularButacas(){
        return (this.butacasFila*this.butacasColumna);
    }
}
