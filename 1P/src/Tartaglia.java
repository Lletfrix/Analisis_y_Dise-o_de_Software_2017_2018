/**
 * Aplicacion que, usando la clase Combinatoria suministrada, genera el triangulo de Tartaglia
 * de n filas, siendo n un parametro de entrada dado por el usuario.
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Tartaglia {
	private Combinatoria c;
	private int n;
	/**
	 * Constructor de la clase Tartaglia
	 *
	 * <p>Construye un objeto de la clase Tartaglia.</p>
	 *
	 * @param c Objeto de la clase Combinatoria que se usara para generar el triangulo de Tartaglia
	 * @param n Numero de filas del triangulo
	 */
  public Tartaglia(Combinatoria c, int n) {
    this.c = c;
    this.n = n;
  }
	/**
   * Sustitucion del toString estandar en la clase Tartaglia
   *
   * <p>Genera el triangulo de Tartaglia del objeto en base a sus atributos como una unica string.</p>
   *
   * @return String que representa el triangulo de Tartaglia de tantas filas como indique su atributo n.
   */
  public String toString(){
    String s = "";
    int i, j;
    for (i = 0; i < n ; i++) {
      for (j = 0; j <= i; j++) {
        s = s + c.combinaciones(i, j) + " ";
      }
      s = s + "\n";
    }
    return s;
  }
  /**
   * Punto de entrada a la aplicacion.
   *
   * <p>Este metodo imprime el triangulo de Tartaglia de tantas filas como el argumento de entrada.</p>
   *
   * @param args Los argumentos de la linea de comando. Se espera un unico entero, el numero de filas del triangulo deseadas.
   */
  public static void main(String[] args) {
    if (args.length!=1) {
      System.out.println("Se espera un numero como parametro:");
      System.out.println("  n = Numero de filas deseadas ");
      System.out.println("Devuelve las n primeras filas del triangulo de Tartaglia");
    }
    else {
      int n  = Integer.parseInt(args[0]);   // convertimos String a int
      Combinatoria c = new Combinatoria();  // Creamos un objeto c de tipo Combinatoria
      System.out.println(new Tartaglia(c, n)); // Imprimimos el triangulo por salida estandar
    }
	}
}
