package GR2202_RafaelSergio.practica4;

public class TerminalAritmetico extends Terminal {
    private static double valor;

    public TerminalAritmetico(String simbolo){
        super(simbolo);
    }

    public void setValor(double valor){
        this.valor = valor;
    }
    @Override
    public double calcular() {
        return valor;
    }
}
