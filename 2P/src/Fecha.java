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
    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    /**
     * Sustitucion del toString estandar en la clase Fecha
     * @return String que representa los datos de cada objeto Fecha con el formato requerido
     */
    public String toString(){
        String datos = dia + "-" + mes + "-" + anio;
        return datos;
    }
    /**
     * Comprobador de la validez de una Fecha dada. Admitimos cualquier año positivo.
     * @return Boolean que representa si una Fecha es válida o no
     */
    public Boolean isValida(){
        if (fecha.mes < 1 || fecha.mes > 12 || fecha.anio < 0){
            return false;
        }
        if (fecha.anio%4 == 0 && fecha.mes == 2 && fecha.anio%100 != 0){
            return (0 < fecha.dia && 30 > fecha.dia);
        }
        if (diasMes[fecha.mes - 1] < fecha.dia || fecha.dia < 1){
            return false;
        }
        return true;
    }
}
