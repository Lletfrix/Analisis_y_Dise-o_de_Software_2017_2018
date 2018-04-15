package GR2202_RafaelSergio.practica4_opt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IDominio {
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException;
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
	public double calcularFitness(IIndividuo individuo);
	public List<Funcion> getFunciones();
	public List<Terminal> getTerminales();
	public Map<List<Boolean>, Boolean> getVp();
} 