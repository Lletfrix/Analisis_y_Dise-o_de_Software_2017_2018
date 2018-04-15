package GR2202_RafaelSergio.practica4;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Tester para probar nuestro algoritmo genético con terminales y funciones aritméticas.
 * @author Rafael Sánchez y Sergio Galán G2202
 *
 */
public class TesterAlgoritmo {
	public static void main(String[] args) throws IllegalArgumentException, CloneNotSupportedException, ArgsDistintosFuncionesException, IOException {
		DominioAritmetico dom = new DominioAritmetico(0.01);
		int nArio[] = {2, 2, 2};
		dom.definirConjuntoTerminales("x");
		dom.definirConjuntoFunciones(nArio, "+", "-", "*");
        Algoritmo algoritmo = new Algoritmo(5, 32, 100, 1, 100000);
        algoritmo.defineConjuntoTerminales(dom.getTerminales());
        algoritmo.defineConjuntoFunciones(dom.getFunciones());
        dom.definirValoresPrueba("files/datos.txt");
        algoritmo.ejecutar(dom);
	}
}
