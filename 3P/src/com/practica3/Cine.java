package com.practica3;

import java.util.ArrayList;
import java.util.Calendar;

public class Cine {
    private String nombre;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Entrada> listaEntradas;

    public void addPelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        Pelicula p = new Pelicula(titulo, director, anno, sinopsis, genero);
        this.listaPeliculas.add(p);
    }
    public void addSala(int numButacasFila, int numButacasColumna){
        Sala s = new Sala(numButacasFila, numButacasColumna);
        this.listaSalas.add(s);
    }
    public void addSesion(Pelicula pelicula, Sala sala, Calendar fecha){
        Sesion sesion = new Sesion(fecha, pelicula, sala);
        if (!sala.addSesion(sesion)){
            return;
        }
        pelicula.addSesion(sesion);
    }
    public boolean venderEntradas(Sesion sesion, int numEntradas){
        int i;
        if(sesion.getButacasDisponibles() < numEntradas){
            return false;
        }
        if(sesion.getFecha().get(Calendar.DAY_OF_WEEK) == 4){
            for (i = 0; i < numEntradas; ++i) {
                listaEntradas.add(new EntradaDiaEspectador());
            }
        }else{
            for (i = 0; i < numEntradas; ++i) {
                listaEntradas.add(new Entrada());
            }
        }
        for(i = 0; i < numEntradas; ++i){
            sesion.actualizarButacasVendidas();
        }
        return true;
    }
    public void showPeliculas(){
        for (Pelicula pelicula : this.listaPeliculas) {
            System.out.println(pelicula);
        }
    }
    public void showRecaudacion(){
        float total = 0;
        for (Entrada entrada : listaEntradas){
            total += entrada.getPrecio();
        }
        System.out.println("Recaudacion: $" + total);
    }
    public void showSesiones(){
        for (Pelicula pelicula : this.listaPeliculas){
            pelicula.showSesiones();
        }
    }
}
