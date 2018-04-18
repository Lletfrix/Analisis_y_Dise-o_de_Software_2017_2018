package nodo.funciones;


import nodo.INodo;

/**
 * Funci�n Multiplicar para un dominio aritm�tico.
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public class FuncionMultiplicacion extends Funcion {
	/**
	 * Constructor de la clase FuncionMultiplicaci�n
	 * @param simbolo S�mbolo de la Funci�n
	 * @param maxDesc M�ximo n�mero de descendientes
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
