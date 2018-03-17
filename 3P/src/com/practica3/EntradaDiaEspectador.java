package com.practica3;

public class EntradaDiaEspectador extends Entrada{
    private float descuento;

    public EntradaDiaEspectador(float precio, Pelicula pelicula, float descuento) {
        super(precio, pelicula);
        this.descuento = descuento;
    }

    @Override
    public float getPrecio() {
        return super.getPrecio() * descuento;
    }
}
