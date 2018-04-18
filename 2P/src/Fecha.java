/**
* Clase Fecha en la que almacenamos todos los datos requeridos (dia, mes y ano), y los metodos necesarios para poder
* mostrar la informacion requerida en el apartado 1 de la practica 2.
* @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    static int[] diasMes= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     * Constructor de la clase Fecha
     * @param dia Dia de la fecha
     * @param mes Mes de la fecha
     * @param anio Anio de la fecha
     */
    public Fecha(int anio, int mes, int dia){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    /**
     * Sustitucion del toString estandar en la clase Fecha
     * @return String que representa los datos de cada objeto Fecha con el formato requerido
     */
    public String toString(){
        String datos = anio + "-" + mes + "-" + dia;
        return datos;
    }
    /**
     * Comprobador de la validez de una Fecha dada. Admitimos cualquier ano positivo.
     * @return Boolean que representa si una Fecha es valida o no
     */
    public Boolean isFechaValida(){
        if (this.mes < 1 || this.mes > 12 || this.anio < 0){
            return false;
        }
        if (this.anio%4 == 0 && this.mes == 2 && this.anio%100 != 0){
            return (0 < this.dia && 30 > this.dia);
        }
        if (diasMes[this.mes - 1] < this.dia || this.dia < 1){
            return false;
        }
        return true;
    }
}
