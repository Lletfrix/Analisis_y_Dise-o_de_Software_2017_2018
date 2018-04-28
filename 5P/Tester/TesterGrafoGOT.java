import java.io.FileNotFoundException;
import java.io.IOException;

public class TesterGrafoGOT {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		GrafoGOT got = new GrafoGOT("Files/got-s01-vertices.csv", "Files/got-s01-arcos.csv");
		//System.out.println(got);
		System.out.println(got.getVertice("Doreah"));
		System.out.println(got.casas());
		System.out.println(got.miembrosCasa("Targaryen"));
	}
}
