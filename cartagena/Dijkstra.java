import java.util.*;
public class Dijkstra {
    private Map<String, List<Nodo>> grafo = new HashMap<>();
    public void agregarCiudad(String ciudad) { grafo.putIfAbsent(ciudad, new ArrayList<>()); }
    public void agregarConexion(String desde, String hasta, int distancia) {
        grafo.get(desde).add(new Nodo(hasta, distancia));
        grafo.get(hasta).add(new Nodo(desde, distancia));
    }
    public Map<String, Integer> calcularDistancias(String inicio) {
        Map<String, Integer> distancias = new HashMap<>();
        for (String ciudad : grafo.keySet()) distancias.put(ciudad, Integer.MAX_VALUE);
        distancias.put(inicio, 0);
        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));
        pq.add(new Nodo(inicio, 0));
        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            for (Nodo vecino : grafo.get(actual.nombre)) {
                int nuevaDist = distancias.get(actual.nombre) + vecino.distancia;
                if (nuevaDist < distancias.get(vecino.nombre)) {
                    distancias.put(vecino.nombre, nuevaDist);
                    pq.add(new Nodo(vecino.nombre, nuevaDist));
                }
            }
        }
        return distancias;
    }
}
