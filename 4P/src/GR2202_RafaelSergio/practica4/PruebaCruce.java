package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.List;

public class PruebaCruce {
	public List<IIndividuo> cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException{
		int aleat1 = (int) (Math.random() * i1.getNumeroNodos());
		int aleat2 = (int) (Math.random() * i2.getNumeroNodos());
		INodo aux1, aux2, paux1, paux2;
		int ind1, ind2;
		List<IIndividuo> lista = new ArrayList<>();
		if(aleat1 == 0 && aleat2 == 0) {
			throw new CruceNuloException();
		}
		System.out.println("Punto de cruce del progenitor 1: " + aleat1);
		System.out.println("Punto de cruce del progenitor 2: " + aleat2);
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
		lista.add(i1);
		lista.add(i2);
		return lista;
	}
}
