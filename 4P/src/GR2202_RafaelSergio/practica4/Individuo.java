package GR2202_RafaelSergio.practica4;

import java.util.List;

public class Individuo implements IIndividuo{
	private INodo expresion;
	private double fitness;
	
	public Individuo() {
	}
	
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
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		// TODO Auto-generated method stub
		
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
		System.out.println("Expresión: " + this.getExpresion());
		
	}
	@Override
	public void etiquetaNodos() {
		this.getExpresion().etiquetaNodo(1);
	}
	@Override
	public INodo getNodo(int indice) {
		return this.getExpresion().getNodo(indice);
	}
	
}
