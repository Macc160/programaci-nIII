package app;

import graph.Graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Construcción del grafo basado en la imagen proporcionada.
        // Nodos: Cali, Pereira, Medellin, Valledupar, Bogota, Barranquilla, Cartagena
        Graph g = new Graph();
        g.addNode("Cali");
        g.addNode("Pereira");
        g.addNode("Medellin");
        g.addNode("Valledupar");
        g.addNode("Bogota");
        g.addNode("Barranquilla");
        g.addNode("Cartagena");

        // Aristas (no dirigidas) con pesos. 
        // NOTA: Los pesos visibles en la imagen son: Cali-Pereira=105, Pereira-Bogota=130, Barranquilla-Bogota=100, y 390 en el centro.
        // Para las aristas sin peso visible he asumido valores razonables y los he documentado en README.
        g.addEdge("Cali","Pereira",105);
        g.addEdge("Pereira","Medellin",160);
        g.addEdge("Medellin","Cartagena",400);
        g.addEdge("Pereira","Bogota",130);
        g.addEdge("Bogota","Barranquilla",100);
        g.addEdge("Medellin","Valledupar",80);
        g.addEdge("Valledupar","Bogota",390);
        g.addEdge("Valledupar","Barranquilla",180);
        g.addEdge("Cartagena","Barranquilla",260);

        // Ejecutar Dijkstra desde Cali hasta Cartagena
        String source = "Cali";
        String target = "Cartagena";
        Graph.PathResult res = g.dijkstra(source, target);

        System.out.println("Resultado Dijkstra de " + source + " a " + target);
        if (res.path == null) {
            System.out.println("No existe camino.");
        } else {
            System.out.println("Distancia total: " + res.distance);
            System.out.println("Camino: " + String.join(" -> ", res.path));
        }
    }
}
