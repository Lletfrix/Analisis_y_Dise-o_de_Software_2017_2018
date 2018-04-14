package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {
    private List<Funcion> funciones;
    private List<Terminal> terminales;
    private List<IIndividuo> poblacion;
    int profundidad;
    int profundidadMaxima;
    int individuosTorneo;
    int numIndividuos;

    public Algoritmo(int profundidadMaxima, int individuosTorneo, int numIndividuos){
        funciones = new ArrayList<>();
        terminales = new ArrayList<>();
        poblacion = new ArrayList<>();
        this.profundidadMaxima = profundidadMaxima;
        this.individuosTorneo = individuosTorneo;
        this.numIndividuos = numIndividuos;
        profundidad = 0;

    }

    public void crearPoblacion() throws CloneNotSupportedException {
        for(int i = 0; i < numIndividuos; ++i) {
            Individuo individuo = new Individuo();
            individuo.setExpresion(recursionPoblacion());
            poblacion.add(individuo);
        }
    }

    private INodo recursionPoblacion() throws CloneNotSupportedException {
        INodo ncopia = null;
        if(profundidadMaxima == profundidad){
        	int aleat = (int)(Math.random() * terminales.size());
        	ncopia = terminales.get(aleat).copy();
        }else{
            int aleat = (int) (Math.random() * funciones.size());
            ncopia = funciones.get(aleat).copy();
            for (int i = 0; i < ncopia.getMaxDesc(); ++i){
                ncopia.incluirDescendiente(recursionPoblacion());
            }
            ++profundidad;
        }
        return ncopia;
    }
}
