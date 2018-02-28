/**
* Clase Contrato creada para hacer posible que la clase Profesor sea general para el mismo profesor en toda la cadena de autoescuelas.
* @author Rafael Sánchez Sánchez y Sergio Galan Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Contrato{
    private Fecha fechaInic;
    private Fecha fechaFin;
    private Autoescuela autoescuela;

    public Contrato(int anyoInic, int mesInic, int diaInic, int anyoFin, int mesFin, int diaFin, Autoescuela autoescuela){
        this.fechaInic = new Fecha(anyoInic, mesInic, diaInic);
        this.fechaFin = new Fecha(anyoFin, mesFin, diaFin);
        this.autoescuela = autoescuela;
    }

    public Fecha getFechaInic(){
        return this.fechaInic;
    }

    public Fecha getFechaFin(){
        return this.fechaFin;
    }

    public Autoescuela getAutoescuela(){
        return this.autoescuela;
    }
}
