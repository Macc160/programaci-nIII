package src;
import java.util.*;

/**
 * Clase Graph representa un grafo utilizando listas de adyacencia.
 * Cada vértice es una ciudad y cada arista tiene un peso (distancia).
 */
public class Graph {
    private Map<String, List<Edge>> adjList;

    /**
     * Constructor: inicializa la lista de adyacencia.
     */
    public Graph() {
        adjList = new HashMap<>();
    }

    /**
     * Agrega un vértice (ciudad) al grafo.
     * @param city Nombre de la ciudad.
     */
    public void addVertex(String city) {
        adjList.putIfAbsent(city, new ArrayList<>());
    }

    /**
     * Agrega una arista entre dos ciudades con un peso.
     * @param from Ciudad origen.
     * @param to Ciudad destino.
     * @param weight Distancia entre las ciudades.
     */
    public void addEdge(String from, String to, int weight) {
        adjList.get(from).add(new Edge(to, weight));
        adjList.get(to).add(new Edge(from, weight)); // Grafo no dirigido
    }

    /**
     * Devuelve la lista de adyacencia completa.
     * @return Mapa con las ciudades y sus conexiones.
     */
    public Map<String, List<Edge>> getAdjList() {
        return adjList;
    }

    /**
     * Clase interna Edge representa una conexión entre dos ciudades.
     */
    public static class Edge {
        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
