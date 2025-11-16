package src;
import java.util.*;

// Clase que representa el grafo usando listas de adyacencia
public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(String city) {
        adjList.putIfAbsent(city, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        adjList.get(from).add(new Edge(to, weight));
        adjList.get(to).add(new Edge(from, weight)); // Grafo no dirigido
    }

    public Map<String, List<Edge>> getAdjList() {
        return adjList;
    }

    public static class Edge {
        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
