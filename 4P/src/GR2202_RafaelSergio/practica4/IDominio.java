package GR2202_RafaelSergio.practica4;

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
	 * @throws ArgsDistintosFuncionesException
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException;
	/**
	 * Define los valores de prueba del Dominio
	 * @param ficheroDatos Fichero que contiene los valores de prueba
	 * @throws FileNotFoundException
	 * @throws IOException
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
	 * @return Mapa con los valores y resultados esperados
	 */
	public <A, B> Map<A, B> getVp();
} 