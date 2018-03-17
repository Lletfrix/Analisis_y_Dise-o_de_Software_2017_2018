package com.practica3;

public class EntradaDiaEspectador extends Entrada{
    private static double descuentoGlobal = 0.9;
    private double descuento;

    public EntradaDiaEspectador() {
        super();
        this.descuento = descuentoGlobal;
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * descuento;
    }
}
