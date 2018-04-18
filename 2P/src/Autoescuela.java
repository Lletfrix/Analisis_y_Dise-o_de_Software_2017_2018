/**
* Clase Autoescuela con los metodos necesarios para implementar el apartado 4 de la practica 2 por medio de la nueva clase Contrato.
* @author Rafael Sanchez Sanchez y Sergio Galan Martin: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Autoescuela{
    private String nombre;
    private String codigo;
    private String direccion;
    /**
     * Constructor de la clase Autoescuela
     * @param nombre Nombre de la Autoescuela
     * @param codigo Codigo de la Autoescuela
     * @param direccion Direccion de la Autoescuela
     */
    public Autoescuela(String nombre, String codigo, String direccion){
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
    }

    /**
     * Getter del atributo nombre de la clase Autoescuela
     * @return Nombre de la Autoescuela
     */
    public String getNombre(){
        return this.nombre;
    }
}
