package GR2202_RafaelSergio.practica4_opt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DominioBooleano implements IDominio{
	private Map<List<Boolean>, Boolean> vp;
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	
	public DominioBooleano() {
		this.terminales = new ArrayList<Terminal>();
		this.funciones = new ArrayList<Funcion>();
	}
	
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
        this.terminales.add(new Terminal0(terminales[0]));
        this.terminales.add(new Terminal1(terminales[1]));
        this.terminales.add(new Terminal2(terminales[2]));
        return this.terminales;
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		int cont = 0;
		for(String s: funciones) {
			if(s.equals("∧")) {
				if(argumentos[cont] != 2) {
					throw new ArgsDistintosFuncionesException();
				}
				this.funciones.add(new FuncionAnd(s, argumentos[cont]));
			}
			if(s.equals("v")) {
				if(argumentos[cont] != 2) {
					throw new ArgsDistintosFuncionesException();
				}
				this.funciones.add(new FuncionOr(s, argumentos[cont]));
			}
			if(s.equals("¬")) {
				if(argumentos[cont] != 1) {
					throw new ArgsDistintosFuncionesException();
				}
				this.funciones.add(new FuncionNot(s));
			}
			cont++;
		}
		return this.funciones;
	}

	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		String cadena;
		String tokens[];
		String tokensAux[];
		List<Boolean> lista;
		this.vp = new HashMap<List<Boolean>, Boolean>();
		FileReader f = new FileReader(ficheroDatos);
		@SuppressWarnings("resource")
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
		    lista = new ArrayList<Boolean>();
			tokens = cadena.split(";");
            tokensAux = tokens[0].split(",");
            for (String s : tokensAux){
                lista.add(Boolean.parseBoolean(s));
            }
            vp.put(lista, Boolean.parseBoolean(tokens[1]));
		}
	}

	public List<Terminal> getTerminales(){
		return this.terminales;
	}
	
	public List<Funcion> getFunciones(){
		return this.funciones;
	}
	
	@Override
	public double calcularFitness(IIndividuo individuo) {
		Boolean aux;
		double tot = 0.0;
		for (Map.Entry<List<Boolean>, Boolean> e : vp.entrySet()) {
            Terminal0.setValor(e.getKey().get(0));
            Terminal1.setValor(e.getKey().get(1));
            Terminal2.setValor(e.getKey().get(2));
			aux = individuo.calcularExpresion();
			//System.out.println("Valor " + e.getKey() + " <-> Rdo estimado: " + aux + " <-> Rdo real: " + e.getValue());
			if(aux.equals(e.getValue())) {
				tot = tot + 1;
			}
		}
		individuo.setFitness(tot);
		return tot;
	}


	public Map<List<Boolean>, Boolean> getVp() {
		return vp;
	}
}
