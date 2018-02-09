/**
 *
 * @author Estudiante EPS estudiante.eps@uam.es
 *
 */
public class Tartaglia {
	  private Combinatoria c;
    private int n;
  public Tartaglia(Combinatoria c, int n) {
    this.c = c;
    this.n = n;
  }
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
   * Punto de entrada a la aplicación.
   *
   * <p>Este método imprime el valor del coeficiente binomial de los 2 parámetros de entrada</p>
   *
   * @param args Los argumentos de la línea de comando. Se esperan dos números enteros, como cadenas
   */
   public static void main(String[] args) {
      if (args.length!=1) {
        System.out.println("Se espera un número como parámetro:");
        System.out.println("  n = Número de filas deseadas ");
        System.out.println("Devuelve las n primeras filas del triángulo de Tartaglia");
      }
      else {
        int n  = Integer.parseInt(args[0]);   // convertimos String a int
        Combinatoria c = new Combinatoria();  // Creamos un objeto c de tipo Combinatoria
        System.out.println(new Tartaglia(c, n)); // Imprimimos una línea por salida estándar
        // En java la destrucción de objetos es automática
      }
}

}
