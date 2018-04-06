package GR2202_RafaelSergio.practica4;

import java.util.List;

public abstract class Nodo {
    private String simbolo;
    private List<INodo> descendientes;
    private int maxDesc;

    public String getRaiz() {
        return simbolo;
    }
    public List<INodo> getDescendientes() {
        return descendientes;
    }
    public void incluirDescendiente(INodo nodo) {
        if (this.descendientes.size() >= this.maxDesc) {
            //Exception
            return;
        }
        this.descendientes.add(nodo);
        this.maxDesc = this.maxDesc + 1;
        return;
    }
    public abstract double calcular();
    public INodo copy() throws CloneNotSupportedException {
        INodo n;
        n = (INodo) this.clone();
        return n;
    }

}
