import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase Sesion que incluye la información sobre las Sesiones en las
 * que se proyectan las Peliculas.
 */
public class Sesion {
    private Calendar fecha;
    private Pelicula pelicula;
    private List<Butaca> butacas;
    private int butacasDisponibles;
    private Sala sala;

    public Sesion (Calendar fecha, Pelicula pelicula, Sala sala) {
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.sala = sala;
        butacasDisponibles = this.sala.calcularButacas();
        this.butacas = new ArrayList<Butaca>();
        for ( int i = 0; i < this.sala.getButacasFila() ; ++i ) {
            for (int j = 0; i < this.sala.getButacasColumna() ; ++j){
                this.butacas.add(new Butaca(i, j));
            }
        }
    }

    public boolean actualizarButacasVendidas () {
        if (butacasDisponibles <= 0) {
            return false;
        }
        butacasDisponibles--;
        return true;
    }

    public boolean actualizarButacasVendidas(int fila, int columna){
        
    }

    public int getButacasDisponibles () {
        return this.butacasDisponibles;
    }

}
