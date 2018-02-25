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
     * @param año Año de la matriculacion del Alumno
     * @param carnet Tipo de carnet para el que esta matriculado el Alumno
     */
     public Alumno(String dni, String nombre, String apellido, int dia, int mes, int anio, String carnet){
       this.dni = dni;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fecha = new Fecha(dia, mes, anio);
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
       String datos = "Nombre: " + nombre + "\n" +
       "Apellido: " + apellido + "\n" +
       "DNI: " + dni + "\n" +
       "Fecha Matricula" + fecha + "\n" +
       "Tipo carnet: " + carnet;
       return datos;
     }

}
