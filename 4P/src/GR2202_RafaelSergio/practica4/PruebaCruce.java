package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.List;

public class PruebaCruce {
	public List<IIndividuo> cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException{
		int aleat1 = (int) (Math.random() * i1.getNumeroNodos());
		int aleat2 = (int) (Math.random() * i2.getNumeroNodos());
		INodo aux1, aux2, paux1, paux2;
		List<IIndividuo> lista = new ArrayList<>();
		if(aleat1 == 1 && aleat2 == 1) {
			throw new CruceNuloException();
		}
		System.out.println("Punto de cruce del progenitor 1: " + aleat1);
		System.out.println("Punto de cruce del progenitor 2: " + aleat2);
		aux1 = i1.getNodo(aleat1);
		aux2 = i2.getNodo(aleat2);
		paux1 = aux1.getPadre();
		paux2 = aux2.getPadre();
		if(aleat1 == 1) {
			i1.setExpresion(aux2);
			aux1.setPadre(paux2);
		}
		else if(aleat2 == 1) {
			i2.setExpresion(aux1);
			aux2.setPadre(paux1);
		}
		else {
			aux1.setPadre(paux2);
			aux2.setPadre(paux1);
		}
		lista.add(i1);
		lista.add(i2);
		return lista;
	}
}
