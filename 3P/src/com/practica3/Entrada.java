package com.practica3;

public class Entrada {
    private static double precioGlobal = 7.5;
    private double precio;

    public Entrada() {
        this.precio = precioGlobal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
