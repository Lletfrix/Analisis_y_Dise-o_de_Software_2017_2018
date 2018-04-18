package nodo.terminales;

import nodo.Nodo;

/**
 * Clase abstracta que implementa métodos generales de un Terminal cualquiera
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public abstract class Terminal extends Nodo {
	
	/**
	 * Constructor auxiliar de los Terminales
	 * @param simbolo Símbolo del Terminal
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
