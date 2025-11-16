/**
 * Clase Main: Ejecuta el grafo y el algoritmo de Dijkstra.
 */
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        String[] ciudades = {"Cali", "Pereira", "Medellín", "Valledupar", "Bogotá", "Barranquilla", "Cartagena"};
        for (String ciudad : ciudades) {
            grafo.agregarNodo(ciudad);
        }

        // Agregar aristas según el grafo de la imagen
        grafo.agregarArista("Cali", "Pereira", 105);
        grafo.agregarArista("Pereira", "Medellín", 180);
        grafo.agregarArista("Medellín", "Valledupar", 390);
        grafo.agregarArista("Valledupar", "Bogotá", 130);
        grafo.agregarArista("Bogotá", "Barranquilla", 100);
        grafo.agregarArista("Cartagena", "Barranquilla", 120);
        grafo.agregarArista("Cartagena", "Valledupar", 200);

        // Ejecutar Dijkstra desde Cali
        java.util.Map<String, Integer> distancias = Dijkstra.calcularDistancias(grafo, "Cali");
        System.out.println("Distancia más corta de Cali a Cartagena: " + distancias.get("Cartagena") + " km");
    }
}
