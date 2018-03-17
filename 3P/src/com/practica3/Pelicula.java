package com.practica3;

public class Pelicula{
    private String titulo;
    private String director;
    private int anno;
    private String sinopsis;
    private Genero genero;

    public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
        this.titulo = titulo;
        this.director = director;
        this.anno = anno;
        this.sinopsis = sinopsis;
        this.genero = genero;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getDirector(){
        return this.director;
    }

    public int getAnno(){
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

    public void setAnno(int anno){
        this.anno = anno;
    }

    public void setSinopsis(String sinopsis){
        this.sinopsis = sinopsis;
    }

    public void setGenero(Genero genero){
        this.genero = genero;
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
