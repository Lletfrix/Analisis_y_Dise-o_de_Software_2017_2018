package GR2202_RafaelSergio.practica4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DominioAritmetico implements IDominio{
	private Map<Double, Double> vp;
	private double tol;
	
	public DominioAritmetico(double tol) {
		this.tol = tol;
	}
	
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		// TODO Auto-generated method stub
		return null;
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
	public double calcularFitness(IIndividuo individuo) {
		double aux;
		double tot = 0;
		for (Map.Entry<Double, Double> e : vp.entrySet()) {
			TerminalAritmetico.setValor(e.getKey());
			aux = individuo.calcularExpresion();
			System.out.println("Valor " + e.getKey() + " <-> Rdo estimado: " + aux + " <-> Rdo real: " + e.getValue());
			if(Math.abs(aux - e.getValue()) <= this.tol) {
				tot = tot + 1;
			}
		}
		return tot;
	}
	
	
}
