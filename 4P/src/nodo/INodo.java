package nodo;

import java.util.List;

/**
 * Interfaz que establece las funciones que tiene que implementar un Nodo cualquiera.
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public interface INodo {
	/**
	 * Getter de la ra�z del Nodo
	 * @return Ra�z del Nodo
	 */
    public String getRaiz();
    /**
     * Getter de los descendientes del Nodo
     * @return Lista de descendientes
     */
    public List<INodo> getDescendientes();
    /**
     * Getter del m�ximo n�mero de descendientes del Nodo
     * @return M�ximo n�mero de descendientes
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
     * Getter del n�mero de Nodos contando a este y a todos sus descendientes directos o indirectos
     * @return N�mero de Nodos
     */
    public int getNumeroNodos();
    /**
     * Getter del �ndice del Nodo indicado por la etiqueta etiqueta. Dicho Nodo tiene que ser
     * descendiente directo del Nodo sobre el que ejecutamos el m�todo.
     * @param etiqueta Etiqueta del Nodo que buscamos
     * @return �ndice del Nodo con la etiqueta etiqueta
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
     * Incluye el Nodo nodo a los descendientes del Nodo sobre el que llamamos al m�todo
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
     * @param inicio N�mero inicial para etiquetar
     * @return Siguiente etiqueta tras terminar de etiquetar el Nodo y sus descendientes
     */
    public int etiquetaNodo(int inicio);
    /**
     * Setter auxiliar del padre en el que indicamos el �ndice donde insertaremos el Nodo en la
     * lista de descendientes del padre
     * @param padre Nodo padre
     * @param ind �ndice donde insertar el Nodo hijo
     */
	public void setPadre(INodo padre, int ind);

    /**
     * El hijo deja de estar asociado al padre en ambos sentidos. Eliminamos el nodo de la lista de descendientes del padre,
     * y seteamos el padre del nodo a null.
     */
	public void detachPadre();
}
