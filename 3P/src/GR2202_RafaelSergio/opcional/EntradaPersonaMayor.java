package GR2202_RafaelSergio.opcional;
import GR2202_RafaelSergio.practica3.Entrada;

/**
 * Clase EntradaPersonaMayor implementada para cumplir la funcionalidad especificada en la
 * Practica 3 de ADSOF
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class EntradaPersonaMayor extends Entrada {
    private static double descuentoGlobal = 0.7;
    private double descuento;
    /**
     * Constructor de la clase EntradaPersonaMayor
     */
    public EntradaPersonaMayor() {
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
