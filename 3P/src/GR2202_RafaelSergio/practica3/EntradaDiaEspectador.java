package GR2202_RafaelSergio.practica3;
/**
 * Clase EntradaDiaEspectador implementada para cumplir la funcionalidad especificada en la
 * Practica 3 de ADSOF
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class EntradaDiaEspectador extends Entrada{
    private static double descuentoGlobal = 0.9;
    private double descuento;
    /**
     * Constructor de la clase EntradaDiaEspectador
     */
    public EntradaDiaEspectador() {
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
