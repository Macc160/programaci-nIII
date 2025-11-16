package src;
import java.util.*;

// Programa principal
public class Main {
    public static void main(String[] args) {
        // Crear grafo y agregar ciudades
        Graph graph = new Graph();
        String[] cities = {"Cali", "Pereira", "Bogota", "Valledupar", "Barranquilla", "Cartagena"};
        for (String city : cities) {
            graph.addVertex(city);
        }

        // Agregar conexiones según la imagen
        graph.addEdge("Cali", "Pereira", 105);
        graph.addEdge("Pereira", "Bogota", 130);
        graph.addEdge("Bogota", "Valledupar", 390);
        graph.addEdge("Valledupar", "Barranquilla", 100);
        graph.addEdge("Barranquilla", "Cartagena", 200); // Peso necesario para llegar a Cartagena

        // Ejecutar Dijkstra desde Cali
        Map<String, Integer> distances = Dijkstra.shortestPath(graph, "Cali");
        System.out.println("Distancias desde Cali:");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Camino más corto a Cartagena
        List<String> shortestPath = Dijkstra.getPath(graph, "Cali", "Cartagena");
        System.out.println("
Camino más corto a Cartagena: " + shortestPath);
        System.out.println("Distancia: " + distances.get("Cartagena"));

        // Camino más largo (máxima distancia)
        String farthestCity = Collections.max(distances.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("
Camino más largo desde Cali: " + farthestCity + " con distancia " + distances.get(farthestCity));
    }
}
