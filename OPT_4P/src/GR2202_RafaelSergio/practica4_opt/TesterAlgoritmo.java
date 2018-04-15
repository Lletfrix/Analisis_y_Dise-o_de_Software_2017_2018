package GR2202_RafaelSergio.practica4_opt;

import java.io.IOException;

public class TesterAlgoritmo {
	public static void main(String[] args) throws IllegalArgumentException, CloneNotSupportedException, ArgsDistintosFuncionesException, IOException {
		DominioBooleano dom = new DominioBooleano();
		int nArio[] = {2, 2, 1};
		dom.definirConjuntoTerminales("X", "Y", "Z");
		dom.definirConjuntoFunciones(nArio, "∧", "v", "¬");
        Algoritmo algoritmo = new Algoritmo(4, 8, 100, 1, 10000);
        algoritmo.defineConjuntoTerminales(dom.getTerminales());
        algoritmo.defineConjuntoFunciones(dom.getFunciones());
        dom.definirValoresPrueba("files/datos.txt");
        algoritmo.ejecutar(dom);
	}
}
