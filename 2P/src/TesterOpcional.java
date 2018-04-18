/**
* Tester del apartado opcional de la P2
* @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class TesterOpcional {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("00000A", 2100, "Eduardo", "Perez Serrano", "31415927P", "+34 91 497-2253");
        Autoescuela autoescuela1 = new Autoescuela("Gala", "ES000", "C/Genova 13, Madrid, Spain");
        Autoescuela autoescuela2 = new Autoescuela("Adsof", "EPS001", "C/Francisco Tomas y Valiente 11, Madrid, Spain");
        Contrato contrato1 = new Contrato(0, 1, 1, 34, 4, 23, autoescuela1);
        Contrato contrato2 = new Contrato(1998, 1, 23, 1998, 3, 11, autoescuela2);
        prof1.addContrato(contrato1);
        prof1.addContrato(contrato2);

        prof1.printInformacion();
    }
}
