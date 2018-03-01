/**
* Clase Contrato creada para hacer posible que la clase Profesor sea general para el mismo profesor en toda la cadena de autoescuelas.
* @author Rafael Sánchez Sánchez y Sergio Galan Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Contrato{
    private Fecha fechaInic;
    private Fecha fechaFin;
    private Autoescuela autoescuela;

    /**
     * Constructor de la clase Contrato
     * @param anyoInic Año de inicio del Contrato
     * @param mesInic Mes de inicio del Contrato
     * @param diaInic Dia de inicio del Contrato
     * @param anyoFin Año de fin del Contrato
     * @param mesFin Mes de fin del Contrato
     * @param diaFin Dia de fin del Contrato
     * @param autoescuela Autoescuela que contrata al profesor
     */
    public Contrato(int anyoInic, int mesInic, int diaInic, int anyoFin, int mesFin, int diaFin, Autoescuela autoescuela){
        this.fechaInic = new Fecha(anyoInic, mesInic, diaInic);
        this.fechaFin = new Fecha(anyoFin, mesFin, diaFin);
        this.autoescuela = autoescuela;
    }

    /**
     * Getter de la fecha de inicio del Contrato
     * @return Fecha de inicio del Contrato
     */
    public Fecha getFechaInic(){
        return this.fechaInic;
    }

    /**
     * Getter de la fecha de fin del Contrato
     * @return Fecha de fin del Contrato
     */
    public Fecha getFechaFin(){
        return this.fechaFin;
    }

    /**
     * Getter de la Autoescula del Contrato
     * @return Autoescuela del Contrato
     */
    public Autoescuela getAutoescuela(){
        return this.autoescuela;
    }
}
