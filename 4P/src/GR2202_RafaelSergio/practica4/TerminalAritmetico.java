package GR2202_RafaelSergio.practica4;

public class TerminalAritmetico extends Terminal {
    private static double valor;

    public TerminalAritmetico(String simbolo){
        super(simbolo);
    }

    public static void setValor(double v){
        valor = v;
    }
    @Override
    public double calcular() {
        return valor;
    }

    @Override
    public TerminalAritmetico clone() throws  CloneNotSupportedException{
        TerminalAritmetico termArim = new TerminalAritmetico(this.getRaiz());
        if(this.getDescendientes().size()==0){
            return termArim;
        }
        for (INodo n: this.getDescendientes()) {
            termArim.incluirDescendiente(n.copy());
        }
        return termArim;
    }
}
