package graph;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adj = new HashMap<>();

    public static class Edge {
        public final String to;
        public final int weight;
        public Edge(String to, int weight) { this.to = to; this.weight = weight; }
    }

    public static class PathResult {
        public final List<String> path;
        public final int distance;
        public PathResult(List<String> path, int distance) { this.path = path; this.distance = distance; }
    }

    public void addNode(String name) {
        adj.putIfAbsent(name, new ArrayList<>());
    }

    public void addEdge(String a, String b, int w) {
        addNode(a);
        addNode(b);
        adj.get(a).add(new Edge(b,w));
        adj.get(b).add(new Edge(a,w)); // grafo no dirigido
    }

    public PathResult dijkstra(String source, String target) {
        if (!adj.containsKey(source) || !adj.containsKey(target)) return new PathResult(null, -1);
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        for (String v : adj.keySet()) dist.put(v, Integer.MAX_VALUE);
        dist.put(source, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.dist));
        pq.add(new Node(source,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist != dist.get(cur.name)) continue;
            if (cur.name.equals(target)) break;
            for (Edge e : adj.getOrDefault(cur.name, List.of())) {
                int nd = cur.dist + e.weight;
                if (nd < dist.get(e.to)) {
                    dist.put(e.to, nd);
                    prev.put(e.to, cur.name);
                    pq.add(new Node(e.to, nd));
                }
            }
        }

        if (dist.get(target) == Integer.MAX_VALUE) return new PathResult(null, -1);

        List<String> path = new ArrayList<>();
        String cur = target;
        while (cur != null) {
            path.add(cur);
            cur = prev.get(cur);
        }
        Collections.reverse(path);
        return new PathResult(path, dist.get(target));
    }

    private static class Node {
        String name; int dist;
        Node(String n,int d){name=n;dist=d;}
    }
}
