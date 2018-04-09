package GR2202_RafaelSergio.practica4;

public abstract class Funcion extends Nodo{

    public Funcion(String simbolo, int maxDesc){
        super(simbolo, maxDesc);
    }
    public abstract double calcular();
    
    @Override
    public String toString() {
    	String s;
    	s = "( " + this.getRaiz();
    	for (INodo n: this.getDescendientes()){
    		s = s + " " +n;
    	}
    	s += " )";
    	return s;
    }
    @Override
    public int getNumeroNodos() {
    	int total = 0;
    	for(INodo n: this.getDescendientes()) {
    		total += n.getNumeroNodos();
    	}
    	total += 1;
    	return total;
    }
}
