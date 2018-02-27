/**
* Clase Alumno en la que almacenamos todos los datos requeridos, y los métodos necesarios para poder
* mostrar la información requerida en el apartado 1 de la práctica 2.
* @author Rafael Sánchez Sánchez y Sergio Galan Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Alumno {
    private String dni;
    private String nombre;
    private String apellido;
    private Fecha fecha;
    private String carnet;
    /**
     * Constructor de la clase Alumno
     * @param dni Dni del Alumno como cadena de caracteres
     * @param nombre Nombre del Alumno
     * @param apellido Apellido del Alumno
     * @param dia Dia de la fecha de matriculacion del alumno
     * @param mes Mes de la matriculacion del Alumno (como entero)
     * @param anio Año de la matriculacion del Alumno
     * @param carnet Tipo de carnet para el que esta matriculado el Alumno
     */
     public Alumno(String dni, String nombre, String apellido, int anio, int mes, int dia, String carnet){
       this.dni = dni;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fecha = new Fecha(anio, mes, dia);
       this.carnet = carnet;
     }
     /**
      * Funcion para obtener la fecha de matriculacion de un Alumno
      * @return Fecha de matriculacion del Alumno
      */
     public Fecha getFechaMatr(){
       return fecha;
     }
     /**
      * Sustitucion del toString estandar en la clase Alumno
      * @return String que representa todos los datos de cada objeto Alumno con el formato requerido
      */
     public String toString(){
       String datos = "\n\tNombre: " + nombre + "\n\t" +
       "Apellido: " + apellido + "\n\t" +
       "DNI: " + dni + "\n\t" +
       "Fecha Matricula: " + fecha + "\n\t" +
       "Tipo carnet: " + carnet;
       return datos;
     }

}
