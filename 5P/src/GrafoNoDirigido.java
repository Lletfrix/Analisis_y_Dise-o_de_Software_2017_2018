import java.util.*;

public class GrafoNoDirigido<T> extends Grafo<T>{
    public GrafoNoDirigido(){
        super();
    }

    @Override
    public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
        if (!this.arcos.containsKey(v1.getId())){
            Map<Integer, Double> map1 = new TreeMap<>();
            this.arcos.put(v1.getId(), map1);
        }
        if(!this.arcos.containsKey(v2.getId())){
            Map<Integer, Double> map2 = new TreeMap<>();
            this.arcos.put(v2.getId(),map2);
        }

        this.arcos.get(v1.getId()).put(v2.getId(), peso);
        this.arcos.get(v2.getId()).put(v1.getId(), peso);
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
