import java.util.*;

public class GrafoDirigido<T> extends Grafo<T>{
    public GrafoDirigido(){
        super();
    }

    @Override
    public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
        if (!this.arcos.containsKey(v1.getId())){
            Map<Integer, Double> map = new TreeMap<>();
            this.arcos.put(v1.getId(), map);
            map.put(v2.getId(), peso);
        }
        Map<Integer, Double> aux = this.arcos.get(v1.getId());
        aux.put(v2.getId(), peso);
        return;
    }

    @Override
    public double getPesoDe(Vertice<T> v1, Vertice<T> v2) throws ArcoNoExistenteException {
        if(!this.arcos.containsKey(v1.getId()) || !this.arcos.get(v1.getId()).containsKey(v2.getId())){
            throw new ArcoNoExistenteException();
        }

        return ((Map<Integer, Double>)this.arcos.get(v1.getId())).get(v2.getId());
    }

    @Override
    public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
        List<Vertice<T>> vecinos = new ArrayList<>();
        Map<Integer, Double> aux = this.arcos.get(v.getId());
        for (int vecinoId : aux.keySet()){
            vecinos.add(this.vertices.get(vecinoId));
        }
        return vecinos;
    }
}
