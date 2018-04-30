import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws IOException, FileNotFoundException {
		super();
		
		BufferedReader vertices = new BufferedReader(new FileReader(new File(ficheroVertices)));
		BufferedReader arcos = new BufferedReader(new FileReader(new File(ficheroArcos)));
		
		for(String x = vertices.readLine(); x != null; x = vertices.readLine()) {
			StringTokenizer str = new StringTokenizer(x, ",");
			//String[] info = new String[str.countTokens()];
			String aux = null;
			this.addVertice(Integer.parseInt(str.nextToken()), new PersonajeGOT(str.nextToken(), str.nextToken()));
		}
		
		for(String x = arcos.readLine(); x != null; x = arcos.readLine()) {
			StringTokenizer str = new StringTokenizer(x, ",");
			String[] info = new String[str.countTokens()];
			this.addArco(this.vertices.get(Integer.parseInt(str.nextToken())), this.vertices.get(Integer.parseInt(str.nextToken())), Double.parseDouble(str.nextToken()));
		}
	}
	
	public Vertice<PersonajeGOT> getVertice(String nombre){
		return this.vertices.entrySet().stream().filter(entry -> entry.getValue().getDatos().getNombre().equals(nombre)).map(entry -> entry.getValue()).findAny().orElse(null);
	}
	
	public List<String> casas(){
		List<String> aux = new ArrayList<>();
		aux.addAll(this.vertices.entrySet().stream().map(entry -> entry.getValue().getDatos().getCasa()).filter(s -> !s.equals("null")).sorted((c1, c2) -> c1.compareTo(c2)).collect(Collectors.toCollection(TreeSet::new)));
		
		return aux;
	}
	
	public List<String> miembrosCasa(String casa) {
		Predicate<Entry<Integer, Vertice<PersonajeGOT>>> miembroEnCasa = new Predicate<Entry<Integer, Vertice<PersonajeGOT>>>() {
			@Override
			public boolean test(Entry<Integer, Vertice<PersonajeGOT>> t) {
				String aux = t.getValue().getDatos().getCasa();
				if(aux == null) {
					return false;
				}
				return aux.equals(casa);
			}
		};
		return this.vertices.entrySet().stream().filter(miembroEnCasa).map(e -> e.getValue().getDatos().getNombre()).collect(Collectors.toList());
	}
	
	public Map<Object, Long> gradoPersonajes() {
		return this.arcos.entrySet().stream().collect(Collectors.groupingBy(Entry::getKey, Collectors.counting())); //TODO Que salga por Nombre, no por Índice
	}
	
	public Map<Object, Long> gradoPonderadoPersonajes() {
		return this.arcos.entrySet().stream().collect(Collectors.groupingBy(Entry::getKey, Collectors.counting() /*,Collectors.summingDouble(e -> )*/)); //TODO
	}

	public Map<String, Double> personajesRelevantes() {
		return null; //TODO
		
	}
	
}
