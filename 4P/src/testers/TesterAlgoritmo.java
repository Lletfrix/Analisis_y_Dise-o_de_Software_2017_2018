package testers;

import algoritmo.Algoritmo;
import dominio.DominioAritmetico;
import excepciones.ArgsDistintosFuncionesException;

import java.io.IOException;

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
        Algoritmo algoritmo = new Algoritmo(3, 6, 100, 1, 7000);
        algoritmo.defineConjuntoTerminales(dom.getTerminales());
        algoritmo.defineConjuntoFunciones(dom.getFunciones());
        dom.definirValoresPrueba("files/datos.txt");
        algoritmo.ejecutar(dom);
	}
}
