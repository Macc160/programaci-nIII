import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> calcularDistancias(Grafo grafo, String inicio, Map<String, String> previo) {
        Map<String, Integer> distancias = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (String nodo : grafo.getAdyacencia().keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
            previo.put(nodo, null);
        }
        distancias.put(inicio, 0);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            for (Arista arista : grafo.getAdyacencia().get(actual)) {
                int nuevaDistancia = distancias.get(actual) + arista.peso;
                if (nuevaDistancia < distancias.get(arista.destino)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    previo.put(arista.destino, actual);
                    cola.add(arista.destino);
                }
            }
        }
        return distancias;
    }

    public static List<String> reconstruirCamino(Map<String, String> previo, String inicio, String fin) {
        List<String> camino = new ArrayList<>();
        String actual = fin;
        while (actual != null) {
            camino.add(actual);
            actual = previo.get(actual);
        }
        Collections.reverse(camino);
        return camino;
    }
}
