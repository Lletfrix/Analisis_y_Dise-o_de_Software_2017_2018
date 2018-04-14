package GR2202_RafaelSergio.practica4;

import java.util.List;

public interface IIndividuo extends Comparable<IIndividuo>{
    public INodo getExpresion();
    public void setExpresion(INodo expresion);
    public double getFitness();
    public void setFitness(double fitness);
    public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
    public double calcularExpresion();
    public int getNumeroNodos();
    public void writeIndividuo();
    public void etiquetaNodos();
    public INodo getNodo(int indice);
}
