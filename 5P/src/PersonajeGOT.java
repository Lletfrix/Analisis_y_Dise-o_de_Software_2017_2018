
public class PersonajeGOT {
	private String nombre;
	private String casa;
	
	public PersonajeGOT(String nombre, String casa) {
		this.nombre = nombre;
		this.casa = casa;
	}
	
	public PersonajeGOT(String nombre) {
		this(nombre, null);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCasa() {
		return this.casa;
	}
	
	@Override
	public String toString() {
		return "[" + this.nombre + ", " + this.casa + "]";
	}
}
