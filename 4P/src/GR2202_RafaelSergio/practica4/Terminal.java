package GR2202_RafaelSergio.practica4;

/**
 * Clase abstracta que implementa m�todos generales de un Terminal cualquiera
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public abstract class Terminal extends Nodo{
	
	/**
	 * Constructor auxiliar de los Terminales
	 * @param simbolo S�mbolo del Terminal
	 */
    public Terminal(String simbolo){
        super(simbolo, 0);
    }
    
    @Override
    public String toString() {
    	return this.getRaiz();
    }
    
    @Override
    public int getNumeroNodos() {
    	return 1;
    }
}
