package testers;

import individuo.IIndividuo;
import individuo.Individuo;
import nodo.funciones.Funcion;
import nodo.funciones.FuncionMultiplicacion;
import nodo.funciones.FuncionResta;
import nodo.funciones.FuncionSuma;
import nodo.terminales.Terminal;
import nodo.terminales.TerminalAritmetico;

/**
 * Tester del funcionamiento de los Individuos.
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public class TesterIndividuos {
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
	}
}
