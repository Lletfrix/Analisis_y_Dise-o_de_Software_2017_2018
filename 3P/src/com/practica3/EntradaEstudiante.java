package com.practica3;
/**
 * Clase EntradaEstudiante implementada para cumplir la funcionalidad especificada en la
 * Práctica 3 de ADSOF
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class EntradaEstudiante extends Entrada{
    private static double descuentoGlobal = 0.8;
    private double descuento;
    /**
     * Constructor de la clase EntradaEstudiante
     */
    public EntradaEstudiante() {
        super();
        this.descuento = descuentoGlobal;
    }
    /**
     * Getter del precio de la Entrada
     * @return Precio de la Entrada (double)
     */
    @Override
    public double getPrecio() {
        return super.getPrecio() * descuento;
    }
}
