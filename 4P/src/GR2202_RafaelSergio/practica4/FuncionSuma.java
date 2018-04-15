package GR2202_RafaelSergio.practica4;

/**
 * Función Suma para un dominio aritmético.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public class FuncionSuma extends Funcion {

	/**
	 * Constructor de la clase FuncionSuma
	 * @param simbolo Símbolo de la Función
	 * @param maxDesc Máximo número de descendientes
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
