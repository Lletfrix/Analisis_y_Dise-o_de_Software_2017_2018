package GR2202_RafaelSergio.practica4;

public  abstract  class Terminal extends Nodo{

    public Terminal(String simbolo){
        super(simbolo, 1);
    }
    public abstract double calcular();
    
    @Override
    public String toString() {
    	return this.getRaiz();
    }
    
    @Override
    public int getNumeroNodos() {
    	return 1;
    }
}
