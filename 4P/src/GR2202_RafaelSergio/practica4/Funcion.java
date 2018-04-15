package GR2202_RafaelSergio.practica4;

/**
 * Clase abstracta que implementa algunas funciones generales de las Funciones
 * de un algoritmo genético.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public abstract class Funcion extends Nodo{
	/**
	 * Constructor auxiliar de la clase Funcion
	 * @param simbolo Símbolo de la Función
	 * @param maxDesc Máximo número de descendientes
	 */
    public Funcion(String simbolo, int maxDesc){
        super(simbolo, maxDesc);
    }
    
    @Override
    public String toString() {
    	String s;
    	s = "( " + this.getRaiz();
    	for (INodo n: this.getDescendientes()){
    		s = s + " " +n;
    	}
    	s += " )";
    	return s;
    }
    @Override
    public int getNumeroNodos() {
    	int total = 0;
    	for(INodo n: this.getDescendientes()) {
    		total += n.getNumeroNodos();
    	}
    	total += 1;
    	return total;
    }
}
