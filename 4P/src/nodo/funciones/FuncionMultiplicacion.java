package nodo.funciones;


import nodo.INodo;

/**
 * Función Multiplicar para un dominio aritmético.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public class FuncionMultiplicacion extends Funcion {
	/**
	 * Constructor de la clase FuncionMultiplicación
	 * @param simbolo Símbolo de la Función
	 * @param maxDesc Máximo número de descendientes
	 */
	public FuncionMultiplicacion(String simbolo, int maxDesc) {
        super(simbolo, maxDesc);
    }
	
	@Override
	public double calcular() {
		double total = 1;
        for (INodo n : this.getDescendientes()){
            total *= n.calcular();
        }
        return total;
	}

	@Override
    public FuncionMultiplicacion clone() throws  CloneNotSupportedException{
        FuncionMultiplicacion func = new FuncionMultiplicacion(this.getRaiz(), this.getMaxDesc());
        if(this.getDescendientes().size()==0){
            return func;
        }
        for (INodo n: this.getDescendientes()) {
            func.incluirDescendiente(n.copy());
        }
        return func;
    }

}
