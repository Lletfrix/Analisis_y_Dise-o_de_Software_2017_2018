package GR2202_RafaelSergio.practica4_opt;

public  abstract  class Terminal extends Nodo{

    public Terminal(String simbolo){
        super(simbolo, 0);
    }
    public abstract boolean calcular();
    
    @Override
    public String toString() {
    	return this.getRaiz();
    }
    
    @Override
    public int getNumeroNodos() {
    	return 1;
    }
}
