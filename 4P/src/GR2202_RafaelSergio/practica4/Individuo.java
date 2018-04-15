package GR2202_RafaelSergio.practica4;

import java.util.List;

/**
 * Clase abstracta que implementa algunas de las funciones generales de un Individuo cualquiera
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public class Individuo implements IIndividuo{
	private INodo expresion;
	private double fitness;
	
	@Override
	public INodo getExpresion() {
		return expresion;
	}
	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
	}
	@Override
	public double getFitness() {
		return fitness;
	}
	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	@Override
	public double calcularExpresion() {
		return this.getExpresion().calcular();
	}
	@Override
	public int getNumeroNodos() {
		return this.getExpresion().getNumeroNodos();
	}
	@Override
	public void writeIndividuo() {
		System.out.println("Expresion: " + this.getExpresion());
		
	}
	@Override
	public void etiquetaNodos() {
		this.getExpresion().etiquetaNodo(0);
	}
	@Override
	public INodo getNodo(int indice) {
		return this.getExpresion().getNodo(indice);
	}
	@Override
	public int compareTo(IIndividuo indiv) {
		if(this.getFitness() > indiv.getFitness()) {
			return -1;
		}
		else if(this.getFitness() < indiv.getFitness()) {
			return 1;
		}
		return 0;
	}
	
}
