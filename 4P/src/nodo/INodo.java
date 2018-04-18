package nodo;

import java.util.List;

/**
 * Interfaz que establece las funciones que tiene que implementar un Nodo cualquiera.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public interface INodo {
	/**
	 * Getter de la raíz del Nodo
	 * @return Raíz del Nodo
	 */
    public String getRaiz();
    /**
     * Getter de los descendientes del Nodo
     * @return Lista de descendientes
     */
    public List<INodo> getDescendientes();
    /**
     * Getter del máximo número de descendientes del Nodo
     * @return Máximo número de descendientes
     */
    public int getMaxDesc();
    /**
     * Getter de la etiqueta del Nodo
     * @return Etiqueta del Nodo
     */
    public int getEtiqueta();
    /**
     * Getter del Nodo padre del Nodo dado
     * @return Nodo padre
     */
    public INodo getPadre();
    /**
     * Getter del Nodo indicado por la etiqueta indice
     * @param indice Obtiene el nodo de la etiqueta indice del arbol
     * @return Nodo indicado
     */
    public INodo getNodo(int indice);
    /**
     * Getter del número de Nodos contando a este y a todos sus descendientes directos o indirectos
     * @return Número de Nodos
     */
    public int getNumeroNodos();
    /**
     * Getter del índice del Nodo indicado por la etiqueta etiqueta. Dicho Nodo tiene que ser
     * descendiente directo del Nodo sobre el que ejecutamos el método.
     * @param etiqueta Etiqueta del Nodo que buscamos
     * @return Índice del Nodo con la etiqueta etiqueta
     */
	public int getIndex(int etiqueta);
    /**
     * Setter de la etiqueta del Nodo
     * @param etiqueta Etiqueta del Nodo
     */
    public void setEtiqueta(int etiqueta);
    /**
     * Setter del padre del Nodo
     * @param padre Nodo padre
     */
    public void setPadre(INodo padre);
    /**
     * Incluye el Nodo nodo a los descendientes del Nodo sobre el que llamamos al método
     * @param nodo Nodo a incluir a los descendientes
     * @throws IllegalArgumentException Lista de hijos llena
     * @throws CloneNotSupportedException El objeto no es clonable
     */
    public void incluirDescendiente(INodo nodo) throws IllegalArgumentException, CloneNotSupportedException;
    /**
     * Calcula el valor de un Nodo
     * @return Valor calculado
     */
    public double calcular();
    /**
     * Crea una copia del Nodo
     * @return Copia del Nodo
     * @throws CloneNotSupportedException El objeto no es clonable
     */
    public INodo copy() throws CloneNotSupportedException;
    /**
     * Etiqueta un Nodo y sus descendientes partiendo de inicio
     * @param inicio Número inicial para etiquetar
     * @return Siguiente etiqueta tras terminar de etiquetar el Nodo y sus descendientes
     */
    public int etiquetaNodo(int inicio);
    /**
     * Setter auxiliar del padre en el que indicamos el índice donde insertaremos el Nodo en la
     * lista de descendientes del padre
     * @param padre Nodo padre
     * @param ind Índice donde insertar el Nodo hijo
     */
	public void setPadre(INodo padre, int ind);

    /**
     * El hijo deja de estar asociado al padre en ambos sentidos. Eliminamos el nodo de la lista de descendientes del padre,
     * y seteamos el padre del nodo a null.
     */
	public void detachPadre();
}
