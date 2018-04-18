package algoritmo;

import dominio.IDominio;
import excepciones.ArgsDistintosFuncionesException;
import excepciones.CruceNuloException;
import individuo.IIndividuo;
import nodo.funciones.Funcion;
import nodo.terminales.Terminal;

import java.util.List;

/**
 * Interfaz que establece las funciones que necesitar� un algoritmo gen�tico cualquiera.
 * @author Rafael S�nchez y Sergio Gal�n G2202
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
     * @throws ArgsDistintosFuncionesException Se lanza cuando algun parametro no es compatible con la funcion correspondiente.
     */
    public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
    /**
     * Crea la poblaci�n inicial
     * @throws CloneNotSupportedException El objeto no es clonable
     */
    public void crearPoblacion() throws CloneNotSupportedException;
    /**
     * Implementa el cruce entre dos Individuos
     * @param i1 Primer individuo a cruzar
     * @param i2 Segundo individuo a cruzar
     * @return Lista con los dos Individuos hijos
     * @throws CruceNuloException Se eligen los dos nodos raiz como punto de cruce
     */
    public List<IIndividuo> cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException;
    /**
     * Crea una generaci�n nueva en base a la poblaci�n anterior
     */
    public void crearNuevaPoblacion();
    /**
     * Ejecuta el Algoritmo Gen�tico
     * @param dominio Dominio en el que trabajar� el Algoritmo Gen�tico
     * @throws CloneNotSupportedException El objeto no es clonable
     */
    public void ejecutar(IDominio dominio) throws CloneNotSupportedException;
}
