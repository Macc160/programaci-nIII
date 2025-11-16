package src;
import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addCity(String city) {
        adjList.putIfAbsent(city, new ArrayList<>());
    }

    public void addEdge(String from, String to, int distance) {
        adjList.get(from).add(new Edge(to, distance));
        adjList.get(to).add(new Edge(from, distance)); // Grafo no dirigido
    }

    public Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String city : adjList.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            String city = current.to;

            for (Edge neighbor : adjList.get(city)) {
                int newDist = distances.get(city) + neighbor.distance;
                if (newDist < distances.get(neighbor.to)) {
                    distances.put(neighbor.to, newDist);
                    pq.add(new Edge(neighbor.to, newDist));
                }
            }
        }
        return distances;
    }

    // Método de ordenamiento Burbuja
    public List<Map.Entry<String, Integer>> bubbleSort(Map<String, Integer> distances) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(distances.entrySet());
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getValue() > list.get(j + 1).getValue()) {
                    Map.Entry<String, Integer> temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
}

class Edge {
    String to;
    int distance;

    public Edge(String to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}
