import java.util.*;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        String[] ciudades = {"Cali", "Pereira", "Medellín", "Valledupar", "Bogotá", "Barranquilla", "Cartagena"};
        for (String ciudad : ciudades) {
            grafo.agregarNodo(ciudad);
        }

        grafo.agregarArista("Cali", "Pereira", 105);
        grafo.agregarArista("Pereira", "Medellín", 180);
        grafo.agregarArista("Medellín", "Valledupar", 390);
        grafo.agregarArista("Valledupar", "Bogotá", 130);
        grafo.agregarArista("Bogotá", "Barranquilla", 100);
        grafo.agregarArista("Cartagena", "Barranquilla", 120);
        grafo.agregarArista("Cartagena", "Valledupar", 200);

        Map<String, String> previo = new HashMap<>();
        Map<String, Integer> distancias = Dijkstra.calcularDistancias(grafo, "Cali", previo);

        System.out.println("Distancia más corta de Cali a Cartagena: " + distancias.get("Cartagena") + " km");
        System.out.println("Camino: " + Dijkstra.reconstruirCamino(previo, "Cali", "Cartagena"));
    }
}
