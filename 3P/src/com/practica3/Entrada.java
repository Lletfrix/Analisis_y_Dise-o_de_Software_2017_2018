package com.practica3;
/**
 * Clase Entrada implementada para cumplir la funcionalidad especificada en la
 * Práctica 3 de ADSOF
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Entrada {
    private static double precioGlobal = 7.5;
    private double precio;
    /**
     * Constructor de la clase Entrada
     */
    public Entrada() {
        this.precio = precioGlobal;
    }
    /**
     * Getter del precio de la Entrada
     * @return Precio de la Entrada (double)
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Setter del precio de la Entrada
     * @param precio Nuevo precio de la Entrada
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
