package GR2202_RafaelSergio.practica4;

public class FuncionMultiplicacion extends Funcion {
	
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
