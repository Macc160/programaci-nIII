package src;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Agregar ciudades
        String[] cities = {"Cali", "Pereira", "Medellin", "Bogota", "Barranquilla", "Cartagena", "Valledupar"};
        for (String city : cities) {
            graph.addCity(city);
        }

        // Agregar conexiones con distancias aproximadas
        graph.addEdge("Cali", "Pereira", 105);
        graph.addEdge("Pereira", "Medellin", 210);
        graph.addEdge("Medellin", "Cartagena", 640);
        graph.addEdge("Medellin", "Barranquilla", 390);
        graph.addEdge("Barranquilla", "Cartagena", 100);
        graph.addEdge("Barranquilla", "Valledupar", 100);
        graph.addEdge("Valledupar", "Bogota", 390);
        graph.addEdge("Bogota", "Cali", 460);

        // Ejecutar Dijkstra desde Cali
        Map<String, Integer> distances = graph.dijkstra("Cali");

        // Ordenar recorridos con Burbuja
        List<Map.Entry<String, Integer>> sortedDistances = graph.bubbleSort(distances);

        System.out.println("Distancias desde Cali:");
        for (Map.Entry<String, Integer> entry : sortedDistances) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " km");
        }

        System.out.println("
Ruta más corta a Cartagena: " + distances.get("Cartagena") + " km");
    }
}
