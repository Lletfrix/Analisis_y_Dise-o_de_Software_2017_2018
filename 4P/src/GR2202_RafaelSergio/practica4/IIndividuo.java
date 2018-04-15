package GR2202_RafaelSergio.practica4;

import java.util.List;

/**
 * Interfaz que establece las funciones que necesitar� un Individuo para el algoritmo gen�tico.
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public interface IIndividuo extends Comparable<IIndividuo>{
	/**
	 * Getter de la expresi�n del Individuo
	 * @return Expresi�n del Individuo
	 */
    public INodo getExpresion();
    /**
     * Setter de la expresi�n del Individuo
     * @param expresion Expresi�n que queremos insertar al Individuo
     */
    public void setExpresion(INodo expresion);
    /**
     * Getter del fitness del Individuo
     * @return Fitness del Individuo
     */
    public double getFitness();
    /**
     * Setter del fitness del Individuo
     * @param fitness Fitness que queremos insertar al Individuo
     */
    public void setFitness(double fitness);
    /**
     * Funci�n para calcular el valor de la expresi�n del Individuo
     * @return Valor calculado
     */
    public double calcularExpresion();
    /**
     * Getter del n�mero de nodos del Individuo
     * @return N�mero de nodos del Individuo
     */
    public int getNumeroNodos();
    /**
     * Funci�n que imprime el Individuo con un formato legible
     */
    public void writeIndividuo();
    /**
     * Funci�n que etiqueta los nodos del individuo empezando en 0
     */
    public void etiquetaNodos();
    /**
     * Funci�n que devuelve el nodo marcado con la etiqueta data
     * @param indice Etiqueta buscada
     * @return Nodo con la etiqueta, null en caso de que no lo encuentre
     */
    public INodo getNodo(int indice);
}
