package GR2202_RafaelSergio.practica4;

/**
 * Clase que nos permite trabajar con valores num�ricos en nuestro algoritmo gen�tico.
 * @author Rafael S�nchez y Sergio Gal�n G2202
 *
 */
public class TerminalAritmetico extends Terminal {
    private static double valor;
    
    /**
     * Constructor de la clase TerminalAritmetico
     * @param simbolo S�mbolo del Terminal
     */
    public TerminalAritmetico(String simbolo){
        super(simbolo);
    }
    
    /**
     * Setter del valor de todos los Terminales
     * @param v Valor
     */
    public static void setValor(double v){
        valor = v;
    }
    
    @Override
    public double calcular() {
        return valor;
    }

    @Override
    public TerminalAritmetico clone() throws  CloneNotSupportedException{
        TerminalAritmetico termArim = new TerminalAritmetico(this.getRaiz());
        if(this.getDescendientes().size()==0){
            return termArim;
        }
        for (INodo n: this.getDescendientes()) {
            termArim.incluirDescendiente(n.copy());
        }
        return termArim;
    }
}
