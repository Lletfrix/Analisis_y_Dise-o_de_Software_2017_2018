package GR2202_RafaelSergio.practica4;

import java.io.IOException;

public class TesterLecturaYFitness {

	public static void main(String[] args) throws IOException, IllegalArgumentException, CloneNotSupportedException {
		IDominio domAritm;
		double fitness;

		domAritm = new DominioAritmetico(1.0);
		domAritm.definirValoresPrueba("files/valoresReducido.txt");
		Terminal x = new TerminalAritmetico("x");
		Funcion suma = new FuncionSuma("+", 2);
		Funcion resta = new FuncionResta("-", 2);
		Funcion multi = new FuncionMultiplicacion("*", 2);
		multi.incluirDescendiente(x);
		multi.incluirDescendiente(x);
		suma.incluirDescendiente(multi);
		suma.incluirDescendiente(x);
		resta.incluirDescendiente(suma);
		resta.incluirDescendiente(multi);

		IIndividuo indiv = new Individuo();
		indiv.setExpresion(resta);
		System.out.println();
		System.out.println("INDIVIDUO");
		indiv.writeIndividuo();
		System.out.println();
		fitness = domAritm.calcularFitness(indiv);
		System.out.println("\nFITNESS= " + fitness);
	}
}
