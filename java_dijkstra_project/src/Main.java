package src;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Agregar ciudades
        String[] cities = {"Cali", "Medellin", "Cartagena", "Bogota", "Popayan", "Pasto", "Armenia", "Pereira"};
        for (String city : cities) {
            graph.addCity(city);
        }

        // Agregar conexiones con distancias aproximadas
        graph.addEdge("Cali", "Medellin", 420);
        graph.addEdge("Medellin", "Cartagena", 640);
        graph.addEdge("Cali", "Bogota", 460);
        graph.addEdge("Bogota", "Cartagena", 1020);
        graph.addEdge("Cali", "Popayan", 140);
        graph.addEdge("Popayan", "Pasto", 260);
        graph.addEdge("Pasto", "Bogota", 780);
        graph.addEdge("Cali", "Armenia", 190);
        graph.addEdge("Armenia", "Pereira", 50);
        graph.addEdge("Pereira", "Medellin", 210);

        // Ejecutar Dijkstra desde Cali
        Map<String, Integer> distances = graph.dijkstra("Cali");

        // Ordenar recorridos
        List<Map.Entry<String, Integer>> sortedDistances = graph.sortDistances(distances);

        System.out.println("Distancias desde Cali:");
        for (Map.Entry<String, Integer> entry : sortedDistances) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " km");
        }

        System.out.println("
Ruta más corta a Cartagena: " + distances.get("Cartagena") + " km");
    }
}
