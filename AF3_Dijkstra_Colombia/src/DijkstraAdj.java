// DijkstraAdj.java
public class DijkstraAdj {
    public static final int INF = Integer.MAX_VALUE / 4;

    public static int[] dijkstra(Graph g, int src, int[] prev) {
        int n = g.n;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) { dist[i] = INF; visited[i] = false; prev[i] = -1; }
        dist[src] = 0;

        for (int it = 0; it < n; it++) {
            int u = -1; int best = INF;
            for (int i = 0; i < n; i++) if (!visited[i] && dist[i] < best) { best = dist[i]; u = i; }
            if (u == -1) break;
            visited[u] = true;
            for (Graph.Edge e : g.neighbors(u)) {
                int v = e.to; int w = e.weight;
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w; prev[v] = u;
                }
            }
        }
        return dist;
    }

    public static String reconstruirCamino(int src, int dest, int[] prev, String[] names) {
        if (dest < 0) return "";
        java.util.ArrayList<Integer> path = new java.util.ArrayList<Integer>();
        int cur = dest;
        while (cur != -1) { path.add(0, cur); if (cur == src) break; cur = prev[cur]; }
        if (path.size() == 0 || path.get(0) != src) return "(no hay camino)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(names[path.get(i)]);
        }
        return sb.toString();
    }
}
