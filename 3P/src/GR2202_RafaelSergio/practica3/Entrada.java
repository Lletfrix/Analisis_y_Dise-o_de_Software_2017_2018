package GR2202_RafaelSergio.practica3;
/**
 * Clase Entrada implementada para cumplir la funcionalidad especificada en la
 * Practica 3 de ADSOF
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
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
