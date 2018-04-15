package GR2202_RafaelSergio.practica4;

/**
 * Funci�n Suma para un dominio aritm�tico.
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public class FuncionSuma extends Funcion {

	/**
	 * Constructor de la clase FuncionSuma
	 * @param simbolo S�mbolo de la Funci�n
	 * @param maxDesc M�ximo n�mero de descendientes
	 */
    public FuncionSuma(String simbolo, int maxDesc) {
        super(simbolo, maxDesc);
    }

    @Override
    public double calcular() {
        double total = 0;
        for (INodo n : this.getDescendientes()){
            total += n.calcular();
        }
        return total;
    }

    @Override
    public FuncionSuma clone() throws  CloneNotSupportedException{
        FuncionSuma func = new FuncionSuma(this.getRaiz(), this.getMaxDesc());
        if(this.getDescendientes().size()==0){
            return func;
        }
        for (INodo n: this.getDescendientes()) {
            func.incluirDescendiente(n.copy());
        }
        return func;
    }
}
