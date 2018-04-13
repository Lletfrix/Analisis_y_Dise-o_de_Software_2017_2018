package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.List;

public abstract class Nodo implements INodo, Cloneable {
    private String simbolo;
    private INodo padre;
    private List<INodo> descendientes;

    private int maxDesc;
    private int etiqueta;

    public Nodo(String simbolo, int maxDesc) {
        this.padre = null;
        this.simbolo = simbolo;
        this.maxDesc = maxDesc;
        this.descendientes = new ArrayList<>();
    }

    public String getRaiz() {
        return simbolo;
    }

    public List<INodo> getDescendientes() {
        return descendientes;
    }

    public int getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

    public INodo getPadre() {
        return this.padre;
    }

    public void setPadre(INodo padre) {
        if (this.padre != null) {
            List<INodo> l = this.padre.getDescendientes();
            for (INodo n : l) {
                if (n == this) { //TODO: CHECK IF THIS WORKS
                    l.remove(n);
                    break;
                }
            }
        }
        this.padre = padre;
        if (padre != null) {
            padre.getDescendientes().add(this);
        }
    }

    public void incluirDescendiente(INodo nodo) throws IllegalArgumentException, CloneNotSupportedException {
        if (this.descendientes.size() >= this.maxDesc) {
            throw new IllegalArgumentException();
        }
        INodo n = nodo.copy();
        n.setPadre(this);
        return;
    }

    public abstract double calcular();

    public INodo copy() throws CloneNotSupportedException {
        INodo n;
        n = (INodo) this.clone();
        return n;
    }

    public int etiquetaNodo(int inicio) {
        this.etiqueta = inicio;
        int aux = inicio;
        if (this.getDescendientes().size() == 0) {
            return aux + 1;
        }
        aux = inicio + 1;
        for (INodo n : this.getDescendientes()) {
            aux = n.etiquetaNodo(aux);
        }
        return aux;
    }

    public INodo getNodo(int indice) {
        if (this.getEtiqueta() == indice) {
            return this;
        }
        if (this.getDescendientes().size() == 0) {
            return null;
        }
        INodo aux = null;
        for (INodo n : this.getDescendientes()) {
            aux = n.getNodo(indice);
            if (aux != null) {
                break;
            }
        }
        return aux;

    }


    public int getMaxDesc() {
        return maxDesc;
    }

}
