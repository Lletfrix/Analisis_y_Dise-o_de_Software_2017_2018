package GR2202_RafaelSergio.practica4;

public class FuncionSuma extends Funcion {

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
}
