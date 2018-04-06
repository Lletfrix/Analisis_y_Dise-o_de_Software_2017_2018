package GR2202_RafaelSergio.practica4;

import java.util.List;

public interface INodo {
    public String getRaiz();
    public List<INodo> getDescendientes();
    public void incluirDescendiente(INodo nodo);
    public double calcular();
    public INodo copy();
}
