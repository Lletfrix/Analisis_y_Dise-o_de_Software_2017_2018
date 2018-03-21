package com.practica3;
/**
 * Clase Sala implementada para cumplir la funcionalidad especificada en la
 * Práctica 3 de ADSOF
 * @author Rafael Sánchez Sánchez y Sergio Galán Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
 *
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Sala{
    private static int idSerial = 1;
    private final int id;
    private int numButacasFila;
    private int numButacasColumna;
    private ArrayList<Sesion> sesiones;
    /**
     * Constructor de la clase Sala
     * @param numButacasFila Número de Butacas por fila de la Sala
     * @param numButacasColumna Número de Butacas por columna de la Sala
     */
    public Sala(int numButacasFila, int numButacasColumna){
        this.id = this.idSerial;
        this.numButacasFila = numButacasFila;
        this.numButacasColumna = numButacasColumna;
        this.sesiones = new ArrayList<Sesion>();
        this.idSerial++;
    }
    /**
     * Getter del id de la Sala
     * @return id de la Sala
     */
    public int getId() {
        return id;
    }
    /**
     * Getter del número de Butacas por fila de la Sala
     * @return número de Butacas por fila de la Sala
     */
    public int getNumButacasFila() {
        return numButacasFila;
    }
    /**
     * Getter del número de Butacas por columna de la Sala
     * @return número de Butacas por columna de la Sala
     */
    public int getNumButacasColumna() {
        return numButacasColumna;
    }
    /**
     * Getter de la lista de Sesiones de la Sala
     * @return lista de Sesiones de la Sala
     */
    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }
    /**
     * Setter del número de Butacas por fila de la Sala
     * @param numButacasFila nuevo número de Butacas por fila
     */
    public void setNumButacasFila(int numButacasFila) {
        this.numButacasFila = numButacasFila;
    }
    /**
     * Setter del número de Butacas por columna de la Sala
     * @param numButacasColumna nuevo número de Butacas por columna
     */
    public void setNumButacasColumna(int numButacasColumna) {
        this.numButacasColumna = numButacasColumna;
    }
    /**
     * Método que comprueba si una Sala está libre para una Fecha determinada
     * @param fecha Fecha que queremos comprobar
     * @return Booleano que representa si la Sala está libre en esa Fecha
     */
    private boolean isSalaDisponible(Calendar fecha){
        int i;
        for(i = 0; i < sesiones.size(); i++){
            Calendar fechaOriginal = sesiones.get(i).getFecha();
            if (fechaOriginal.get(Calendar.YEAR) == fecha.get(Calendar.YEAR) &&
                    fechaOriginal.get(Calendar.MONTH) == fecha.get(Calendar.MONTH) &&
                    fechaOriginal.get(Calendar.DATE) == fecha.get(Calendar.DATE) &&
                    fechaOriginal.get(Calendar.HOUR) == fecha.get(Calendar.HOUR) &&
                    fechaOriginal.get(Calendar.MINUTE) == fecha.get(Calendar.MINUTE)){
                return false;
            }
        }
        return true;
    }
    /**
     * Método que añade una Sesión a la lista de Sesiones de la Sala
     * @param sesion Sesión que añadir
     * @return Booleano representando el éxito o fallo de la operación
     */
    public Boolean addSesion(Sesion sesion){
        if(isSalaDisponible(sesion.getFecha())){
            sesiones.add(sesion);
            return true;
        }
        return false;
    }
    /**
     * Método que devuelve el número de Butacas total de una Sala
     * @return número de Butacas totales
     */
    public int calcularButacas(){
        return (this.numButacasFila*this.numButacasColumna);
    }
    /**
     * Sustitución del toString estándar para la clase Sala
     * @return String que contiene la información de la Sala
     */
    @Override
    public String toString(){
        return "Sala: " + id + "\n\tButacas totales: " + this.calcularButacas();
    }
    /**
     * Sustitución del equals estándar para la clase Sala
     * @param object Sala a comparar
     * @return Booleano representando si son iguales o no
     */
    @Override
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Sala s = (Sala) object;
            if (this.id==(s.getId())) {
                result = true;
            }
        }
        return result;
    }

}
