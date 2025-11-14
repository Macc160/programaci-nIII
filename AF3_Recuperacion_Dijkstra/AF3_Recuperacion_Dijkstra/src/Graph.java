// Graph.java
// Grafo representado con listas de adyacencia (ArrayList de Edge)
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Graph: lista de adyacencia para representar el grafo.
 * Edge guarda nodo destino y peso (distancia en km en este modelo).
 */
public class Graph {
    public static class Edge {
        public int to;
        public int weight;
        public Edge(int to, int weight) { this.to = to; this.weight = weight; }
    }

    private List<Edge>[] adj;
    public final int n;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<Edge>();
    }

    // Añade arista dirigida u -> v con peso w
    public void addEdge(int u, int v, int w) {
        adj[u].add(new Edge(v, w));
    }

    // Obtiene vecinos de un nodo
    public List<Edge> neighbors(int u) {
        return adj[u];
    }
}
