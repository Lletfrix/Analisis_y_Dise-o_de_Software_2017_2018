package com.practica3;

import java.util.ArrayList;

public class Pelicula{
    private String titulo;
    private String director;
    private String anno;
    private String sinopsis;
    private Genero genero;
    private ArrayList<Sesion> sesiones;

    public Pelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        this.titulo = titulo;
        this.director = director;
        this.anno = anno;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.sesiones = new ArrayList<Sesion>();
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getDirector(){
        return this.director;
    }

    public String getAnno(){
        return this.anno;
    }

    public String getSinopsis(){
        return this.sinopsis;
    }

    public Genero getGenero(){
        return this.genero;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setAnno(String anno){
        this.anno = anno;
    }

    public void setSinopsis(String sinopsis){
        this.sinopsis = sinopsis;
    }

    public void setGenero(Genero genero){
        this.genero = genero;
    }

    public void showSesiones(){
        for (Sesion sesion : this.sesiones) {
            System.out.println(sesion);
        }
    }

    public void addSesion(Sesion sesion){
        this.sesiones.add(sesion);
    }
    @Override
    public String toString(){
        return "Título: " + titulo + "\n" +
        "Director: " + director + "\n" +
        "Año: " + anno + "\n" +
        "Sinopsis: " + sinopsis + "\n" +
        "Genero: " + genero + "\n";
    }

}
