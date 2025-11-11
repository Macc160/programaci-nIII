// Dijkstra clásico usando matriz de adyacencia y sin PriorityQueue
public class Dijkstra {

    // graph: matriz n x n, usar 0 si no hay arista, diagonal 0
    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int INF = Integer.MAX_VALUE / 4;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            visited[i] = false;
        }
        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int min = INF;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }
            if (u == -1) break;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] > 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    // Método de ayuda para imprimir
    public static void imprimirDist(int[] dist, int src) {
        System.out.println("Distancias desde " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] >= Integer.MAX_VALUE/4) System.out.println(i + " : INF");
            else System.out.println(i + " : " + dist[i]);
        }
    }
}
