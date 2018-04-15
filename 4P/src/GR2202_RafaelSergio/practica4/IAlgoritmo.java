package GR2202_RafaelSergio.practica4;

import java.util.List;

/**
 * Interfaz que establece las funciones que necesitará un algoritmo genético cualquiera.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public interface IAlgoritmo {
	/**
	 * Establece el conjunto de Terminales del Algoritmo
	 * @param terminales Lista de Terminales
	 */
    public void defineConjuntoTerminales(List<Terminal> terminales);
    /**
     * Establece el conjunto de Funciones del Algoritmo
     * @param funciones Lista de Funciones
     * @throws ArgsDistintosFuncionesException
     */
    public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
    /**
     * Crea la población inicial
     * @throws CloneNotSupportedException
     */
    public void crearPoblacion() throws CloneNotSupportedException;
    /**
     * Implementa el cruce entre dos Individuos
     * @param i1 Primer individuo a cruzar
     * @param i2 Segundo individuo a cruzar
     * @return Lista con los dos Individuos hijos
     * @throws CruceNuloException
     */
    public List<IIndividuo> cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException;
    /**
     * Crea una generación nueva en base a la población anterior
     */
    public void crearNuevaPoblacion();
    /**
     * Ejecuta el Algoritmo Genético
     * @param dominio Dominio en el que trabajará el Algoritmo Genético
     * @throws CloneNotSupportedException
     */
    public void ejecutar(IDominio dominio) throws CloneNotSupportedException;
}
