// DijkstraAdj.java
// Implementación de Dijkstra sobre listas de adyacencia (versión sin PriorityQueue).
public class DijkstraAdj {

    public static final int INF = Integer.MAX_VALUE / 4;

    /**
     * Ejecuta Dijkstra sobre el grafo g desde la fuente src.
     * Rellena el array prev con el predecesor en el camino más corto o -1.
     * Retorna el arreglo de distancias mínimas.
     */
    public static int[] dijkstra(Graph g, int src, int[] prev) {
        int n = g.n;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            visited[i] = false;
            prev[i] = -1;
        }
        dist[src] = 0;

        for (int it = 0; it < n; it++) {
            int u = -1;
            int best = INF;
            // Seleccionar el nodo no visitado con menor distancia (O(n))
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < best) {
                    best = dist[i];
                    u = i;
                }
            }
            if (u == -1) break; // todos los alcanzables ya visitados
            visited[u] = true;

            // Relajar aristas salientes de u
            for (Graph.Edge e : g.neighbors(u)) {
                int v = e.to;
                int w = e.weight;
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                }
            }
        }
        return dist;
    }

    // Reconstruye el camino desde src hasta dest usando prev[] y devuelve como String con nombres
    public static String reconstruirCamino(int src, int dest, int[] prev, String[] names) {
        if (dest < 0) return "";
        java.util.ArrayList<Integer> path = new java.util.ArrayList<Integer>();
        int cur = dest;
        while (cur != -1) {
            path.add(0, cur);
            if (cur == src) break;
            cur = prev[cur];
        }
        if (path.size() == 0 || path.get(0) != src) return "(no hay camino)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(names[path.get(i)]);
        }
        return sb.toString();
    }
}
