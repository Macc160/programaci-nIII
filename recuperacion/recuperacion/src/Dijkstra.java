package src;
import java.util.*;

// Implementación del algoritmo de Dijkstra
public class Dijkstra {

    // Calcula las distancias más cortas desde una ciudad inicial
    public static Map<String, Integer> shortestPath(Graph graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String city : graph.getAdjList().keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            for (Graph.Edge edge : graph.getAdjList().get(current)) {
                int newDist = distances.get(current) + edge.weight;
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    pq.add(edge.destination);
                }
            }
        }
        return distances;
    }

    // Obtiene el camino más corto entre dos ciudades
    public static List<String> getPath(Graph graph, String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        for (String city : graph.getAdjList().keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            for (Graph.Edge edge : graph.getAdjList().get(current)) {
                int newDist = distances.get(current) + edge.weight;
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current);
                    pq.add(edge.destination);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String step = end;
        while (step != null) {
            path.add(step);
            step = previous.get(step);
        }
        Collections.reverse(path);
        return path;
    }
}
