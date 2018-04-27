import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class Grafo<T> {
	private static int serial = -1;
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer, Map<Integer, Double>> arcos;

	public Grafo(){
	    this.vertices=new TreeMap<>();
	    this.arcos = new TreeMap<>();
    }
		
	public Vertice<T> addVertice(T datos){
		Grafo.serial++;
		return this.addVertice(Grafo.serial, datos);
	}
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> vaux = new Vertice<T>(id, datos);
		this.vertices.put(id, vaux);
		return vaux;
	}
	public List<Vertice<T>> getVertices(){
		return this.getVertices();
	}
	public int getNumVertices() {
		return this.vertices.size();
	}
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Integer ind1 = v1.getId();
		Integer ind2 = v2.getId();
		if(!this.arcos.containsKey(ind1)) {
			return false;
		}
		return this.arcos.get(ind1).containsKey(ind2);
	}
	public int getNumArcos() {
		return this.arcos.size();
	}
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2) throws ArcoNoExistenteException;
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los v?rtices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	public String toString() {
		String aux = "";
		aux += "Vertices: " + "\n";
		for(Entry<Integer, Vertice<T>> e: this.vertices.entrySet()) {
			aux += e.getValue().toString();
		}
		aux += "\nAristas: " + "\n";
		for(Entry e: this.arcos.entrySet()) {
			aux += e.getKey() + ": ";
			for(Map.Entry eaux: ((Map<Integer, Double>) e.getValue()).entrySet()) {
				aux += "{" + eaux.getKey() + ", "+ eaux.getValue()+"} ";
			}
			aux += "\n";
		}
		return aux;
	}
	// los vertices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
}
