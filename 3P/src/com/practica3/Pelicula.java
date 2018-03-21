package com.practica3;
/**
 * Clase Pelicula implementada para cumplir la funcionalidad especificada en la
 * Práctica 3 de ADSOF
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
import java.util.ArrayList;
import java.util.Calendar;

public class Pelicula{
    private String titulo;
    private String director;
    private String anno;
    private String sinopsis;
    private Genero genero;
    private ArrayList<Sesion> sesiones;
    /**
     * Constructor de la clase Pelicula
     * @param titulo Título de la Pelicula
     * @param director Director de la Pelicula
     * @param anno Año de la Pelicula
     * @param sinopsis Sinopsis de la Pelicula
     * @param genero Genero de la Pelicula
     */
    public Pelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        this.titulo = titulo;
        this.director = director;
        this.anno = anno;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.sesiones = new ArrayList<Sesion>();
    }
    /**
     * Getter del título de la Pelicula
     * @return Titulo de la Pelicula
     */
    public String getTitulo(){
        return this.titulo;
    }
    /**
     * Getter del director de la Pelicula
     * @return Director de la Pelicula
     */
    public String getDirector(){
        return this.director;
    }
    /**
     * Getter del año de la Pelicula
     * @return Año de la Pelicula
     */
    public String getAnno(){
        return this.anno;
    }
    /**
     * Getter de la sinopsis de la Pelicula
     * @return Sinopsis de la Pelicula
     */
    public String getSinopsis(){
        return this.sinopsis;
    }
    /**
     * Getter del género de la Pelicula
     * @return Género de la Pelicula
     */
    public Genero getGenero(){
        return this.genero;
    }
    /**
     * Setter del título de la Pelicula
     * @param titulo Nuevo título de la Pelicula
     */
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    /**
     * Setter del director de la Pelicula
     * @param director Nuevo director de la Pelicula
     */
    public void setDirector(String director){
        this.director = director;
    }
    /**
     * Setter del año de la Pelicula
     * @param anno Nuevo año de la Pelicula
     */
    public void setAnno(String anno){
        this.anno = anno;
    }
    /**
     * Setter de la sinopsis de la Pelicula
     * @param sinopsis Nueva sinopsis de la Pelicula
     */
    public void setSinopsis(String sinopsis){
        this.sinopsis = sinopsis;
    }
    /**
     * Setter del género de la Pelicula
     * @param genero Nuevo género de la Pelicula
     */
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    /**
     * Método para mostrar la información de todas las Sesiones de la Película
     */
    public void showSesiones(){
        for (Sesion sesion : this.sesiones) {
            System.out.println(sesion);
        }
    }
    /**
     * Método para añadir una Sesión a la lista de Sesiones de una Película
     * @param sesion Nueva Sesión de la Película
     */
    public void addSesion(Sesion sesion){
        this.sesiones.add(sesion);
    }
    /**
     * Método para buscar una Sesión en la lista de Sesiones de la Película dados sus atributos
     * @param anno Año de la Fecha de la Sesión
     * @param mes Mes de la Fecha de la Sesión
     * @param dia Día de la Fecha de la Sesión
     * @param hora Hora de la Sesión
     * @param minutos Minutos de la hora de la Sesión
     * @return Sesión si se encuentra, null en caso contrario
     */
    public Sesion getSesion(int anno, int mes, int dia, int hora, int minutos){
        int i = 0;
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, anno);
        fecha.set(Calendar.MONTH, mes-1);
        fecha.set(Calendar.DAY_OF_MONTH, dia);
        fecha.set(Calendar.HOUR_OF_DAY, hora);
        fecha.set(Calendar.MINUTE, minutos);
        fecha.set(Calendar.SECOND, 0);
        for (Sesion s : this.sesiones){
            Calendar fechaOriginal = s.getFecha();
            if (fechaOriginal.get(Calendar.YEAR) == fecha.get(Calendar.YEAR) &&
                    fechaOriginal.get(Calendar.MONTH) == fecha.get(Calendar.MONTH) &&
                    fechaOriginal.get(Calendar.DATE) == fecha.get(Calendar.DATE) &&
                    fechaOriginal.get(Calendar.HOUR) == fecha.get(Calendar.HOUR) &&
                    fechaOriginal.get(Calendar.MINUTE) == fecha.get(Calendar.MINUTE)){
                return this.sesiones.get(i);
            }
            ++i;
        }
        return null;
    }
    /**
     * Sustitución del toString estándar para la clase Película
     * @return String con la información de la película
     */
    @Override
    public String toString(){
        return "Título: " + titulo + "\n\t" +
        "Director: " + director + "\n\t" +
        "Año: " + anno + "\n\t" +
        "Sinopsis: " + sinopsis + "\n\t" +
        "Genero: " + genero + "\n\t";
    }
    /**
     * Sustitución del equals estándar para la clase Película
     * @param object Película a comparar
     * @return Booleano representando si son iguales o no
     */
    @Override
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Pelicula pelicula = (Pelicula) object;
            if (this.titulo.equals(pelicula.titulo) && this.anno.equals(pelicula.anno) &&
                    this.director.equals(pelicula.director)) {
                result = true;
            }
        }
        return result;
    }

}
