package GR2202_RafaelSergio.practica4;

import java.util.List;

public abstract class Nodo {
    private String simbolo;
    private List<INodo> descendientes;
    private int maxDesc;    

    public Nodo(String simbolo, int maxDesc){
        this.simbolo = simbolo;
        this.maxDesc = maxDesc;
    }
    public String getRaiz() {
        return simbolo;
    }
    public List<INodo> getDescendientes() {
        return descendientes;
    }
    public void incluirDescendiente(INodo nodo) throws IllegalArgumentException{
        if (this.descendientes.size() >= this.maxDesc) {
            throw new IllegalArgumentException();
        }
        this.descendientes.add(nodo);
        return;
    }
    public abstract double calcular();
    public INodo copy() throws CloneNotSupportedException {
        INodo n;
        n = (INodo) this.clone();
        return n;
    }
}
