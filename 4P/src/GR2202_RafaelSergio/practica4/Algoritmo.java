package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algoritmo {
    private List<Funcion> funciones;
    private List<Terminal> terminales;
    private List<IIndividuo> poblacion;
    private int profundidad;
    private int fitness;
    private int profundidadMaxima;
    private int individuosTorneo;
    private int numIndividuos;
    private int maxGen;
    private int gen;
    private double objetivo;

    public Algoritmo(int profundidadMaxima, int individuosTorneo, int numIndividuos, double objetivo, int maxGen){
        poblacion = new ArrayList<>();
        this.profundidadMaxima = profundidadMaxima;
        this.individuosTorneo = individuosTorneo;
        this.numIndividuos = numIndividuos;
        this.objetivo = objetivo;
        this.maxGen = maxGen;
    }
    
    public void defineConjuntoTerminales(List<Terminal> terminales) {
    	this.terminales = terminales;
    }
    
    public void defineConjuntoFunciones(List<Funcion> funciones) {
    	this.funciones = funciones;
    }

    public void crearPoblacion() throws CloneNotSupportedException {
        for(int i = 0; i < numIndividuos; ++i) {
            Individuo individuo = new Individuo();
            this.profundidad = 0;
            individuo.setExpresion(recursionPoblacion());
            individuo.etiquetaNodos();
            poblacion.add(individuo);
        }
    }

    private INodo recursionPoblacion() throws CloneNotSupportedException {
        INodo ncopia = null;
        ++this.profundidad;
        if(profundidadMaxima == profundidad){
        	int aleat = (int)(Math.random() * terminales.size());
        	ncopia = terminales.get(aleat).copy();
        }else if (profundidad < profundidadMaxima){
            int aleat = (int) (Math.random() * funciones.size());
            ncopia = funciones.get(aleat).copy();
            for (int i = 0; i < ncopia.getMaxDesc(); ++i){
                ncopia.incluirDescendiente(recursionPoblacion());
            }

        }
        --this.profundidad;
        return ncopia;
    }
    
    public List<IIndividuo> cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException{
		int aleat1 = (int) (Math.random() * i1.getNumeroNodos());
		int aleat2 = (int) (Math.random() * i2.getNumeroNodos());
		INodo aux1, aux2, paux1, paux2;
		int ind1, ind2;
		List<IIndividuo> lista = new ArrayList<>();
		if(aleat1 == 0 && aleat2 == 0) {
			throw new CruceNuloException();
		}
		//System.out.println("Punto de cruce del progenitor 1: " + aleat1);
		//System.out.println("Punto de cruce del progenitor 2: " + aleat2);
		aux1 = i1.getNodo(aleat1);
		aux2 = i2.getNodo(aleat2);
		if(aleat1 == 0) {
            aux1.setPadre(aux2.getPadre(), aux2.getPadre().getIndex(aleat2));
            aux2.detachPadre();
			i1.setExpresion(aux2);
		}
		else if(aleat2 == 0) {
            aux2.setPadre(aux1.getPadre(), aux1.getPadre().getIndex(aleat1));
            aux1.detachPadre();
			i2.setExpresion(aux1);
		}
		else {
            paux1 = aux1.getPadre();
            paux2 = aux2.getPadre();
            ind1 = paux1.getIndex(aleat1);
            ind2 = paux2.getIndex(aleat2);
			aux1.setPadre(paux2, ind2);
			aux2.setPadre(paux1, ind1);
		}
		i1.etiquetaNodos();
		i2.etiquetaNodos();
		lista.add(i1);
		lista.add(i2);
		return lista;
	}
    
    public void crearNuevaPoblacion() {
    	IIndividuo mejor = null;
    	IIndividuo indiv1, indiv2;
    	List<IIndividuo> torneo = new ArrayList<>();
    	int i;
    	int min = (int)Math.floor ((int)this.poblacion.size()*0.1);
    	int interval = this.poblacion.size() - min;
    	mejor = this.poblacion.remove(0);
    	Collections.shuffle(this.poblacion);
    	this.poblacion.add(0, mejor);
    	for(i = 0; i < this.individuosTorneo; i++) {
    		torneo.add(this.poblacion.remove((int) (Math.random() * interval + min)));
    		--interval;
    	}
    	Collections.sort(torneo);
    	indiv1 = torneo.remove(0);
    	indiv2 = torneo.remove(1);
    	this.poblacion.addAll(torneo);
    	try {
			this.poblacion.addAll(this.cruce(indiv1, indiv2));
		} catch (CruceNuloException e) {
			this.poblacion.add(indiv1);
			this.poblacion.add(indiv2);
			crearNuevaPoblacion();
			return;
		}
    }
    
    public void ejecutar(IDominio dominio) throws CloneNotSupportedException {
    	this.defineConjuntoFunciones(dominio.getFunciones());
    	this.defineConjuntoTerminales(dominio.getTerminales());
    	this.fitness = 0;
    	this.gen = 1;
    	if(this.poblacion.size() == 0) {
    		this.crearPoblacion();
    	}
    	for(IIndividuo indiv: this.poblacion) {
    		dominio.calcularFitness(indiv);
    	}
    	Collections.sort(this.poblacion);
    	while(this.fitness < this.objetivo * dominio.getVp().size() &&  gen < this.maxGen) {
    		this.crearNuevaPoblacion();
            for(IIndividuo indiv: this.poblacion) {
                dominio.calcularFitness(indiv);
            }
    		Collections.sort(this.poblacion);
    		//System.out.print("Generacion: " + this.gen + " Fitness: " + this.poblacion.get(0).getFitness() + " Individuo: ");
    		//poblacion.get(0).writeIndividuo();
    		this.fitness = (int) this.poblacion.get(0).getFitness();
    		++this.gen;
    	}
    	System.out.println("Final del algoritmo genético. Resultado: ");
    	System.out.print("Generacion: " + this.gen + " Fitness: " + this.poblacion.get(0).getFitness() + " Individuo: ");
		poblacion.get(0).writeIndividuo();
    }
}
