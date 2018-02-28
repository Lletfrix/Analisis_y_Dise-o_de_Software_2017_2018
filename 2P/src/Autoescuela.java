/**
* Clase Autoescuela con los métodos necesarios para implementar el apartado 4 de la práctica 2 por medio de la nueva clase Contrato.
* @author Rafael Sánchez Sánchez y Sergio Galan Martín: rafael.sanchez@estudiante.uam.es y sergio.galanm@estudiante.uam.es
*/
public class Autoescuela{
    private String nombre;
    private String codigo;
    private String direccion;

    public Autoescuela(String nombre, String codigo, String direccion){
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
    }

    public String getNombre(){
        return this.nombre;
    }
}
