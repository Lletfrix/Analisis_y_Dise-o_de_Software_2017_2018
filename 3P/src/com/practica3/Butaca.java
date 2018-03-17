package com.practica3;

public class Butaca {
    private int fila;
    private int columna;
    private boolean free;

    public Butaca(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.free = true;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
