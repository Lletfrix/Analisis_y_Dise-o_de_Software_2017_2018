package GR2202_RafaelSergio.practica4;

public class TesterEtiqueta {
	public static void main(String[] args) throws IllegalArgumentException, CloneNotSupportedException {
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
		System.out.println("Funci�n multiplicaci�n: " + multi);
		System.out.println();
		System.out.println("Funci�n suma: " + suma);
		System.out.println();
		System.out.println("Funci�n resta: " + resta);
		IIndividuo indiv = new Individuo();
		indiv.setExpresion(resta);
		System.out.println();
		System.out.println("INDIVIDUO");
		indiv.writeIndividuo();
		indiv.etiquetaNodos();
		System.out.println(indiv.getExpresion().getDescendientes().get(1).getDescendientes().get(0).getEtiqueta());
		System.out.println(indiv.getExpresion().getDescendientes().get(1).getDescendientes().get(1).getEtiqueta());
		System.out.println(indiv.getExpresion().getDescendientes().get(0).getDescendientes().get(0).getDescendientes().get(0).getEtiqueta());
	}
}
