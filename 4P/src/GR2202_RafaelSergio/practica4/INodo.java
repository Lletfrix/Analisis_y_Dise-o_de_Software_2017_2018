package GR2202_RafaelSergio.practica4;

import java.util.List;

public interface INodo {
    public String getRaiz();
    public List<INodo> getDescendientes();
    public int getMaxDesc();
    public int getEtiqueta();
    public void setEtiqueta(int etiqueta);
    public INodo getPadre();
    public void setPadre(INodo padre);
    public void incluirDescendiente(INodo nodo) throws IllegalArgumentException, CloneNotSupportedException;
    public double calcular();
    public INodo copy() throws CloneNotSupportedException;
    public int getNumeroNodos();
    public int etiquetaNodo(int inicio);
    public INodo getNodo(int indice);
	public int getIndex(int etiqueta);
	public void setPadre(INodo padre, int ind);
	public void detachPadre();
}
