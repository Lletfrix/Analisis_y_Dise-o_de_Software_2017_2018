
public class Vertice<T> {
	private final int id; // identificador del vertice dentro del grafo
	private T datos; // datos almacenados en el vertice
	
	public Vertice(int id, T datos) {
		this.id = id;
		this.datos = datos;
	}
	
	public T getDatos() {
		return this.datos;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return "[" + this.id + " " + this.datos + "]";
	}
	
}
