package GR2202_RafaelSergio.practica3;

import java.util.Calendar;
import java.util.LinkedList;

/**
 * Clase Pelicula implementada para cumplir la funcionalidad especificada en la
 * Practica 3 de ADSOF
 * @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
public class Pelicula{
    private String titulo;
    private String director;
    private String anno;
    private String sinopsis;
    private Genero genero;
    private LinkedList<Sesion> sesiones;
    /**
     * Constructor de la clase Pelicula
     * @param titulo Titulo de la Pelicula
     * @param director Director de la Pelicula
     * @param anno Ano de la Pelicula
     * @param sinopsis Sinopsis de la Pelicula
     * @param genero Genero de la Pelicula
     */
    public Pelicula(String titulo, String director, String anno, String sinopsis, Genero genero){
        this.titulo = titulo;
        this.director = director;
        this.anno = anno;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.sesiones = new LinkedList<Sesion>();
    }
    /**
     * Getter del titulo de la Pelicula
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
     * Getter del ano de la Pelicula
     * @return Ano de la Pelicula
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
     * Getter del genero de la Pelicula
     * @return Genero de la Pelicula
     */
    public Genero getGenero(){
        return this.genero;
    }
    /**
     * Setter del titulo de la Pelicula
     * @param titulo Nuevo titulo de la Pelicula
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
     * Setter del ano de la Pelicula
     * @param anno Nuevo ano de la Pelicula
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
     * Setter del genero de la Pelicula
     * @param genero Nuevo genero de la Pelicula
     */
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    /**
     * Metodo para mostrar la informacion de todas las Sesiones de la Pelicula
     */
    public void showSesiones(){
        for (Sesion sesion : this.sesiones) {
            System.out.println(sesion);
        }
    }
    /**
     * Metodo para anadir una Sesion a la lista de Sesiones de una Pelicula
     * @param sesion Nueva Sesion de la Pelicula
     */
    public void addSesion(Sesion sesion){
        this.sesiones.add(sesion);
    }
    /**
     * Metodo para buscar una Sesion en la lista de Sesiones de la Pelicula dados sus atributos
     * @param anno Ano de la Fecha de la Sesion
     * @param mes Mes de la Fecha de la Sesion
     * @param dia Dia de la Fecha de la Sesion
     * @param hora Hora de la Sesion
     * @param minutos Minutos de la hora de la Sesion
     * @return Sesion si se encuentra, null en caso contrario
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
     * Metodo para retirar todas las Sesiones de una Pelicula
     * @return Booleano que representa el exito o fallo de la operacion
     */
    public boolean remove(){
        for (Sesion s : this.sesiones) {
            s.remove();
        }
        return true;
    }
    /**
     * Metodo para retirar una Sesion concreta de una Pelicula
     * @param sesion Sesion a eliminar
     */
    public void removeSesion(Sesion sesion) {
        int i = 0;
        for (Sesion s : this.sesiones){
            if (s.equals(sesion)){
                this.sesiones.remove(i);
                return;
            }
            i++;
        }
    }
    /**
     * Sustitucion del toString estandar para la clase Pelicula
     * @return String con la informacion de la pelicula
     */
    @Override
    public String toString(){
        return "Titulo: " + titulo + "\n\t" +
        "Director: " + director + "\n\t" +
        "Ano: " + anno + "\n\t" +
        "Sinopsis: " + sinopsis + "\n\t" +
        "Genero: " + genero + "\n\t";
    }
    /**
     * Sustitucion del equals estandar para la clase Pelicula
     * @param object Pelicula a comparar
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
