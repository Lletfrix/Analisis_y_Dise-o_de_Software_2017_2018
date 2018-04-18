package dominio;

import excepciones.ArgsDistintosFuncionesException;
import individuo.IIndividuo;
import nodo.funciones.Funcion;
import nodo.terminales.Terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Interfaz que establece las funciones que necesitará un dominio cualquiera.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public interface IDominio {
	/**
	 * Crea un conjunto conjunto de Terminales para el Dominio
	 * @param terminales Símbolos de los Terminales
	 * @return Lista de Terminales
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	/**
	 * Crea un conjunto de Funciones para el Dominio
	 * @param argumentos Máximo número de argumentos de cada Función
	 * @param funciones Símbolos de las Funciones
	 * @return Lista de Funciones
	 * @throws ArgsDistintosFuncionesException  Se lanza cuando algun parametro no es compatible con la funcion correspondiente.
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException;
	/**
	 * Define los valores de prueba del Dominio
	 * @param ficheroDatos Fichero que contiene los valores de prueba
	 * @throws FileNotFoundException Archivo no encontrado
	 * @throws IOException Error al leer del archivo
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
	/**
	 * Calcula el fitness de un Individuo
	 * @param individuo Individuo al que hay que calcular y setear el fitness
	 * @return Fitness del Individuo
	 */
	public double calcularFitness(IIndividuo individuo);
	/**
	 * Getter del conjunto de Funciones del Dominio
	 * @return Lista de Funciones
	 */
	public List<Funcion> getFunciones();
	/**
	 * Getter del conjunto de Terminales del Dominio
	 * @return Lista de Terminales
	 */
	public List<Terminal> getTerminales();
	/**
	 * Getter de los valores de prueba del Dominio
	 * @param <A>Tipo de la clave del Mapa
     * @param <B> Tipo del valor del mapa
	 * @return Mapa con los valores y resultados esperados
	 */
	public <A, B> Map<A, B> getVp();
} 