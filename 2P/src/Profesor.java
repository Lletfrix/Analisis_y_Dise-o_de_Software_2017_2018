/**
* Clase Profesor en la que almacenamos todos los datos requeridos, y los métodos necesarios para poder
* mostrar la información requerida en el apartado 4 opcional de la práctica 2. No se implementa la clase
* persona por simplicidad del código aunque ésta esté reflejada en el diagrama de clases.
* @author Rafael Sánchez Sánchez y Sergio Galan Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Profesor{
    private String numSS;
    private float salario;
    private boolean activo;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private Fecha fechaInic;
    private Fecha fechaFin;
    /**
     * Constructor de la clase Profesor
     * @param numSS Numero de la Seguridad Social del profesor
     * @param salario Salario del profesor
     * @param nombre Nombre de Profesor
     * @param apellidos Apellidos del Profesor
     * @param dni Dni del Profesor
     * @param telefono Telefono del Profesor
     * @param anio Año de la primera clase del Profesor
     * @param mes Mes de la primera clase del Profesor
     * @param dia Dia de la primera clase del Profesor
     */
    public Profesor(String numSS, float salario, String nombre, String apellidos, String dni, String telefono, int anio, int mes, int dia){
        this.numSS = numSS;
        this.salario = salario;
        this.activo = true;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaInic = new Fecha(anio, mes, dia);
    }

    /**
     * Setter de la fecha final del Profesor
     * @param anio Último año de clase del Profesor
     * @param mes Último mes de clase del Profesor
     * @param dia Último dia de clase del Profesor
     */
    public void finDeContrato(int anio, int mes, int dia){
        this.fechaFin = new Fecha(anio, mes, dia);
        if (!this.fechaFin.isFechaValida()){
            return;
        }
        this.activo = false;
    }

    /**
     * Getter de la Fecha de inicio del Profesor
     * @return Fecha de inicio del Profesor
     */
    public Fecha getFechaInic(){
        return this.fechaInic;
    }

    /**
     * Getter de la Fecha de finalización de docencia del Profesor
     * @return Fecha de finalización de docencia del Profesor. NULL si aún está en activo, aunque en principio nunca deberá retornar eso
     */
    public Fecha getFechaFin(){
        if(activo){
            return this.fechaFin;
        }
        return NULL;
    }

    /**
     * Getter del nombre del Profesor
     * @return String que contiene el nombre del profesor
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Getter de los apellidos del Profesor
     * @return String que contiene los apellidos del Profesor
     */
    public String getApellidos(){
        return this.apellidos;
    }
}
