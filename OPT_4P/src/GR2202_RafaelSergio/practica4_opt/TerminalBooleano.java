package GR2202_RafaelSergio.practica4_opt;

public class TerminalBooleano extends Terminal {
    private static boolean valor;

    public TerminalBooleano (String simbolo){
        super(simbolo);
    }

    public static void setValor(boolean v){
        valor = v;
    }
    @Override
    public boolean calcular() {
        return valor;
    }

    @Override
    public TerminalBooleano clone() throws  CloneNotSupportedException{
        TerminalBooleano termBool = new TerminalBooleano(this.getRaiz());
        if(this.getDescendientes().size()==0){
            return termBool;
        }
        for (INodo n: this.getDescendientes()) {
            termBool.incluirDescendiente(n.copy());
        }
        return termBool;
    }
}
