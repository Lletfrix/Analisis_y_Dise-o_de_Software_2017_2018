package dominio;


import excepciones.ArgsDistintosFuncionesException;
import individuo.IIndividuo;
import nodo.funciones.Funcion;
import nodo.funciones.FuncionMultiplicacion;
import nodo.funciones.FuncionResta;
import nodo.funciones.FuncionSuma;
import nodo.terminales.Terminal;
import nodo.terminales.TerminalAritmetico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Dominio que nos permitirá trabajar con Terminales y Funciones del campo de la
 * aritmética y los números reales.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public class DominioAritmetico implements IDominio {
	private Map<Double, Double> vp;
	private double tol;
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	
	/**
	 * Constructor de DominioAritmetico
	 * @param tol tolerancia del valor obtenido con respecto al valor real
	 */
	public DominioAritmetico(double tol) {
		this.terminales = new ArrayList<Terminal>();
		this.funciones = new ArrayList<Funcion>();
		this.tol = tol;
	}
	
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		this.terminales.add(new TerminalAritmetico(terminales[0]));
		return this.terminales;
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		int cont = 0;
		for(String s: funciones) {
			if(s.equals("+")) {
				if(argumentos[cont] != 2) {
					throw new ArgsDistintosFuncionesException();
				}
				this.funciones.add(new FuncionSuma(s, argumentos[cont]));
			}
			if(s.equals("-")) {
				if(argumentos[cont] != 2) {
					throw new ArgsDistintosFuncionesException();
				}
				this.funciones.add(new FuncionResta(s, argumentos[cont]));
			}
			if(s.equals("*")) {
				if(argumentos[cont] != 2) {
					throw new ArgsDistintosFuncionesException();
				}
				this.funciones.add(new FuncionMultiplicacion(s, argumentos[cont]));
			}
		}
		return this.funciones;
	}

	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		String cadena;
		String tokens[];
		this.vp = new TreeMap<Double, Double>();
		FileReader f = new FileReader(ficheroDatos);
		@SuppressWarnings("resource")
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			tokens = cadena.split(";");
			vp.put(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
		}
	}
	
	@Override
	public List<Terminal> getTerminales(){
		return this.terminales;
	}
	
	@Override
	public List<Funcion> getFunciones(){
		return this.funciones;
	}
	
	@Override
	public double calcularFitness(IIndividuo individuo) {
		double aux;
		double tot = 0;
		for (Map.Entry<Double, Double> e : vp.entrySet()) {
			TerminalAritmetico.setValor(e.getKey());
			aux = individuo.calcularExpresion();
			//System.out.println("Valor " + e.getKey() + " <-> Rdo estimado: " + aux + " <-> Rdo real: " + e.getValue());
			if(Math.abs(aux - e.getValue()) <= this.tol) {
				tot = tot + 1;
			}
		}
		individuo.setFitness(tot);
		return tot;
	}

	@Override
	public Map<Double, Double> getVp() {
		return vp;
	}
}
