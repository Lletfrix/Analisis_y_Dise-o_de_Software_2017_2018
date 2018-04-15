package GR2202_RafaelSergio.practica4;

import java.util.List;

/**
 * Interfaz que establece las funciones que necesitará un Individuo para el algoritmo genético.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public interface IIndividuo extends Comparable<IIndividuo>{
	/**
	 * Getter de la expresión del Individuo
	 * @return Expresión del Individuo
	 */
    public INodo getExpresion();
    /**
     * Setter de la expresión del Individuo
     * @param expresion Expresión que queremos insertar al Individuo
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
     * Función para calcular el valor de la expresión del Individuo
     * @return Valor calculado
     */
    public double calcularExpresion();
    /**
     * Getter del número de nodos del Individuo
     * @return Número de nodos del Individuo
     */
    public int getNumeroNodos();
    /**
     * Función que imprime el Individuo con un formato legible
     */
    public void writeIndividuo();
    /**
     * Función que etiqueta los nodos del individuo empezando en 0
     */
    public void etiquetaNodos();
    /**
     * Función que devuelve el nodo marcado con la etiqueta data
     * @param indice Etiqueta buscada
     * @return Nodo con la etiqueta, null en caso de que no lo encuentre
     */
    public INodo getNodo(int indice);
}
