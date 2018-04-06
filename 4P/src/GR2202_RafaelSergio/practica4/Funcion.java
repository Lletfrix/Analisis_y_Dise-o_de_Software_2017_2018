package GR2202_RafaelSergio.practica4;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcion extends Nodo{

    public Funcion(String simbolo, int maxDesc){
        super(simbolo, maxDesc);
    }
    public abstract double calcular();
}
