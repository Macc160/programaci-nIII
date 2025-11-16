import java.util.*;
public class Main {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        String[] ciudades = {"Cali", "Pereira", "Medellin", "Bogota", "Barranquilla", "Cartagena", "Valledupar"};
        for (String ciudad : ciudades) dijkstra.agregarCiudad(ciudad);
        dijkstra.agregarConexion("Cali", "Pereira", 105);
        dijkstra.agregarConexion("Pereira", "Medellin", 210);
        dijkstra.agregarConexion("Medellin", "Cartagena", 640);
        dijkstra.agregarConexion("Medellin", "Barranquilla", 390);
        dijkstra.agregarConexion("Barranquilla", "Cartagena", 100);
        dijkstra.agregarConexion("Barranquilla", "Valledupar", 100);
        dijkstra.agregarConexion("Valledupar", "Bogota", 390);
        dijkstra.agregarConexion("Bogota", "Cali", 460);
        Map<String, Integer> distancias = dijkstra.calcularDistancias("Cali");
        System.out.println("Distancias desde Cali:");
        distancias.forEach((ciudad, distancia) -> System.out.println(ciudad + " -> " + distancia + " km"));
        System.out.println("Ruta más corta a Cartagena: " + distancias.get("Cartagena") + " km");
    }
}
