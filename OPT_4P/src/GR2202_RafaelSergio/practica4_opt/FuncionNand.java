package GR2202_RafaelSergio.practica4_opt;

public class FuncionNand extends Funcion{

    public FuncionNand(String simbolo, int maxDesc) {
        super(simbolo, maxDesc);
    }
    @Override
    public boolean calcular() {
        boolean total = this.getDescendientes().get(0).calcular();
        for (INodo n : this.getDescendientes().subList(1, this.getDescendientes().size())) {
            total = !(total && n.calcular());
        }
        return total;
    }

    @Override
    public FuncionNand clone() throws  CloneNotSupportedException{
        FuncionNand func = new FuncionNand(this.getRaiz(), this.getMaxDesc());
        if(this.getDescendientes().size()==0){
            return func;
        }
        for (INodo n: this.getDescendientes()) {
            func.incluirDescendiente(n.copy());
        }
        return func;
    }
}


