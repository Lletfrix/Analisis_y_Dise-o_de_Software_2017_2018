package com.practica3;

public class Entrada {
    float precio;
    Pelicula pelicula;

    public Entrada(float precio, Pelicula pelicula) {
        this.precio = precio;
        this.pelicula = pelicula;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
