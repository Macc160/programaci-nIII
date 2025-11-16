package src;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Ciudades del grafo
        String[] cities = {"Cali", "Pereira", "Bogota", "Valledupar", "Barranquilla", "Cartagena", "Medellin"};
        for (String city : cities) {
            graph.addVertex(city);
        }

        // Conexiones según la imagen y pesos asignados
        graph.addEdge("Cali", "Pereira", 105);
        graph.addEdge("Pereira", "Bogota", 130);
        graph.addEdge("Bogota", "Valledupar", 390);
        graph.addEdge("Valledupar", "Barranquilla", 100);
        graph.addEdge("Barranquilla", "Cartagena", 120);
        graph.addEdge("Medellin", "Pereira", 50);
        graph.addEdge("Cartagena", "Medellin", 500);

        // Ejecutar Dijkstra desde Cali
        Map<String, Integer> distances = Dijkstra.shortestPath(graph, "Cali");
        System.out.println("Distancias desde Cali:");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Camino más corto a Cartagena
        List<String> shortestPath = Dijkstra.getPath(graph, "Cali", "Cartagena");
        System.out.println("Camino más corto a Cartagena: " + shortestPath);
        System.out.println("Distancia: " + distances.get("Cartagena"));

        // Camino más largo
        String farthestCity = Collections.max(distances.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Camino más largo desde Cali: " + farthestCity + " con distancia " + distances.get(farthestCity));
    }
}
