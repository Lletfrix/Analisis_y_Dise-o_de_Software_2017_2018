import java.util.*;
import java.util.Map.Entry;

public class GrafoDirigido<T> extends Grafo{
    public GrafoDirigido(){
        super();
    }

    @Override
    public void addArco(Vertice v1, Vertice v2, double peso) {
        if (!this.arcos.containsKey(v1.getId())){
            Map<Integer, Double> map = new TreeMap<>();
            this.arcos.put(v1.getId(), map);
            map.put(v2.getId(), peso);
        }
        Map<Integer, Double> aux = (Map<Integer, Double>) this.arcos.get(v1.getId());
        aux.put(v2.getId(), peso);
        return;
    }

    @Override
    public double getPesoDe(Vertice v1, Vertice v2) throws ArcoNoExistenteException {
        if(!this.arcos.containsKey(v1.getId()) || !((Map<Integer, Double>)this.arcos.get(v1.getId())).containsKey(v2.getId())){
            throw new ArcoNoExistenteException();
        }

        return ((Map<Integer, Double>)this.arcos.get(v1.getId())).get(v2.getId());
    }

    @Override
    public List<Vertice> getVecinosDe(Vertice v) {
        List vecinos = new ArrayList();
        Map aux = (Map) this.arcos.get(v.getId());
        for (int vecinoId : (Set<Integer>) aux.keySet()){
            vecinos.add(this.vertices.get(vecinoId));
        }
        return vecinos;
    }
}
