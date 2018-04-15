package GR2202_RafaelSergio.practica4_opt;

public class FuncionNot extends Funcion{

    public FuncionNot(String simbolo) {
        super(simbolo, 1);
    }
    @Override
    public boolean calcular() {
        return !this.getDescendientes().get(0).calcular();
    }

    @Override
    public FuncionNot clone() throws  CloneNotSupportedException{
        FuncionNot func = new FuncionNot(this.getRaiz());
        if(this.getDescendientes().size()==0){
            return func;
        }
        for (INodo n: this.getDescendientes()) {
            func.incluirDescendiente(n.copy());
        }
        return func;
    }
}


