import java.util.Arrays;

public class Dijkstra {

    // Implementación clásica de Dijkstra sobre matriz de adyacencia (sin PriorityQueue)
    // graph[i][j] = peso de la arista i->j, 0 si no existe (o Integer.MAX_VALUE para no conexión)
    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        // Inicializar distancias
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited);
            if (u == -1) break; // no hay más vértices alcanzables
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Método auxiliar para mostrar distancias
    public static void imprimirDistancias(int[] dist, int src) {
        System.out.println("Distancias desde el nodo " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("Nodo " + i + " : INF");
            else System.out.println("Nodo " + i + " : " + dist[i]);
        }
    }
}
