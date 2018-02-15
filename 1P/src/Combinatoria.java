import java.util.*;
/**
 * Esta aplicación calcula el número de combinaciones sin repetición de n elementos
 * tomados de k en k.
 * <p>La implementación es recursiva, basada en c(n, k) = c(n-1, k-1) + c(n-1, k)
 * Los casos base son c(n, 0) = 1 = c(n, n)  y c(n, k) = 0 para todo k mayor que n</p>
 * <p><b>Nota</b>: Esta implementación no es muy eficiente, al hacer muchos cálculos redundantes.
 * Se aconseja usar valores pequeños de n y k, entre 0 y 30</p>
 *
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Combinatoria {

  private Map<Integer, Long> cache = new HashMap<>();

  /**
   * Ejemplo de constructor, en esta clase seria innecesario, ya que no tiene argumentos
   * ni inicializa atributos. El compilador crea uno igual si no existe.
   * Es importante que no devuelva nada (tampoco void), y que se llame como la clase.
   * Si fuese privado impediria crear objetos de este tipo desde otras clases.
   */
  public Combinatoria(/* Argumentos para construir el objeto, si los hubiera */) {
	  /* Esta clase no tiene atributos, por lo que este constructor vacio lo crearía
	   * automáticamente el compilado, y no es necesario
	   * Si tenemos un atributo (atributo1) con el mismo nombre que un argumento, podemos usar
	   * "this.atributo1" para referirnos al atributo, y "atributo1" para el argumento
	   * Por ejemplo podemos asignar el valor inicial con:
	   * this.atributo1 = atributo1;
	   */
  }

  /**
   * <p>Devuelve el numero de combinaciones posibles de n elementos tomados de k en k</p>
   * @param n Numero de elementos totales
   * @param k Numero de elementos, sin repetición, en cada combinación
   * @return valor del coeficiente binomial (n, k)
   */
  public long combinaciones(int n, int k){
    //Primero comprobamos si los argumentos son válidos
    if (n<0 || k <0) throw new IllegalArgumentException("n y k han de ser positivos");

    if (cache.containsKey(posicion(n, k))){
      return cache.get(posicion(n, k));
    }
    //Casos base
    if (k == 0 || n==k ){
      cache.put(posicion(n, k), (long) 1);
      return 1;
    } //caso base para 1
    if (k > n){
      cache.put(posicion(n, k), (long) 0);
      return 0;
    }
    //caso general
    long comb = combinaciones(n-1, k-1)+ combinaciones (n-1, k);
    cache.put(posicion(n, k), comb);
    return comb;
  }

  /**
   * <p>Calcula la posición del combinatorio (n, k) en el triangulo de Tartaglia comenzando en 0</p>
   * @param n Número de elementos totales
   * @param k Número de elementos, sin repetición, en cada combinación
   * @return Posicion en el triangulo de Tartaglia de C(n, k)
   */
  private int posicion(int n, int k){
    return n*(n+1)/2 + k;
  }


  /**
   * Punto de entrada a la aplicación.
   *
   * <p>Este método imprime el valor del coeficiente binomial de los 2 parámetros de entrada</p>
   *
   * @param args Los argumentos de la línea de comando. Se esperan dos números enteros, como cadenas
   */
   public static void main(String[] args) {
      if (args.length!=2) {
    	  System.out.println("Se esperan dos número como parámetro, n y k.");
    	  System.out.println("  n = Número total de elementos ");
    	  System.out.println("  k = Elementos en cada combinación");
    	  System.out.println("Devuelve el coeficiente binomial(n, k)");
      }
      else {
    	  int n  = Integer.parseInt(args[0]);   // convertimos String a int
    	  int k  = Integer.parseInt(args[1]);   // convertimos String a int
    	  Combinatoria c = new Combinatoria();  // Creamos un objeto c de tipo Combinatoria
    	  System.out.println(c.combinaciones(n, k)); // Imprimimos una línea por salida estándar
    	  // En java la destrucción de objetos es automática
      }
   }
}
