package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que implementa algunas funciones generales de un Nodo cualquiera
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public abstract class Nodo implements INodo, Cloneable {
    private String simbolo;
    private INodo padre;
    private List<INodo> descendientes;

    private int maxDesc;
    private int etiqueta;

    /**
     * Constructor auxiliar de los Nodos
     * @param simbolo Símbolo del Nodo
     * @param maxDesc Máximo número de descendientes
     */
    public Nodo(String simbolo, int maxDesc) {
        this.padre = null;
        this.simbolo = simbolo;
        this.maxDesc = maxDesc;
        this.descendientes = new ArrayList<>();
    }
    
    @Override
    public String getRaiz() {
        return simbolo;
    }
    
    @Override
    public List<INodo> getDescendientes() {
        return descendientes;
    }
    
    @Override
    public int getEtiqueta() {
        return this.etiqueta;
    }
    
    @Override
    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    @Override
    public INodo getPadre() {
        return this.padre;
    }

    @Override
    public void setPadre(INodo padre, int ind) {
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
            padre.getDescendientes().add(ind, this);
        }
    }
    
    @Override
    public void setPadre(INodo padre) {
    	if(padre == null) {
    		this.padre =null;
    		return;
    	}
        setPadre(padre, padre.getDescendientes().size());
    }
    
    @Override
    public int getIndex(int etiqueta) {
    	int ind = -1;
    	for(INodo n: this.getDescendientes()) {
    		ind++;
    		if(n.getEtiqueta() == etiqueta) {
    			return ind; 
    		}
    	}
    	return -1;
    }
    
    @Override
    public void incluirDescendiente(INodo nodo) throws IllegalArgumentException, CloneNotSupportedException {
        if (this.descendientes.size() >= this.maxDesc) {
            throw new IllegalArgumentException();
        }
        INodo n = nodo.copy();
        n.setPadre(this);
        return;
    }
    
    @Override
    public INodo copy() throws CloneNotSupportedException {
        INodo n;
        n = (INodo) this.clone();
        return n;
    }
    
    @Override
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

    @Override
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

    @Override
    public void detachPadre() {
    	this.getPadre().getDescendientes().remove(this);
    	this.setPadre(null);
    }

    @Override
    public int getMaxDesc() {
        return maxDesc;
    }

}
