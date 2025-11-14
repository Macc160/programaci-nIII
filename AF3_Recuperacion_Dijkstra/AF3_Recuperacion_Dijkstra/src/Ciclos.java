// Ciclos.java - clase principal para la AF3 (Dijkstra con listas de adyacencia)
// Modelo didáctico del mapa de Colombia: origen = Cali, destino = Cartagena.
// También se generan rutas candidatas y se ordenan por distancia.
public class Ciclos {

    public static void main(String[] args) {
        // Nodo: ciudad (índice)
        String[] cities = {
            "Cali",       // 0  origen
            "Palmira",    // 1
            "Buga",       // 2
            "Tuluá",      // 3
            "Armenia",    // 4
            "Pereira",    // 5
            "Manizales",  // 6
            "Bogotá",     // 7
            "Sincelejo",  // 8
            "Montería",   // 9
            "Cartagena",  //10 destino
            "Barranquilla"//11
        };

        int n = cities.length;
        Graph g = new Graph(n);

        // Añadir aristas dirigidas (modelo simplificado — pesos en km aproximados)
        g.addEdge(0,1,35);    // Cali -> Palmira
        g.addEdge(1,2,40);    // Palmira -> Buga
        g.addEdge(2,3,45);    // Buga -> Tuluá
        g.addEdge(3,4,70);    // Tuluá -> Armenia
        g.addEdge(4,5,65);    // Armenia -> Pereira
        g.addEdge(5,6,60);    // Pereira -> Manizales
        g.addEdge(6,7,250);   // Manizales -> Bogotá
        g.addEdge(0,5,220);   // Cali -> Pereira (ruta directa)
        g.addEdge(5,7,200);   // Pereira -> Bogotá (otra ruta)
        g.addEdge(7,8,350);   // Bogotá -> Sincelejo (hacia costa)
        g.addEdge(8,10,160);  // Sincelejo -> Cartagena
        g.addEdge(7,11,300);  // Bogotá -> Barranquilla
        g.addEdge(11,10,130); // Barranquilla -> Cartagena
        g.addEdge(0,11,700);  // Cali -> Barranquilla (ruta larga directa)
        g.addEdge(3,5,80);    // Tuluá -> Pereira (alternativa)
        g.addEdge(2,0,45);    // Buga -> Cali (bidireccional modelado)
        g.addEdge(5,0,220);   // Pereira -> Cali
        g.addEdge(10,11,120); // Cartagena -> Barranquilla
        g.addEdge(11,7,300);  // Barranquilla -> Bogotá

        // Ejecutar Dijkstra desde Cali (0)
        int src = 0;
        int dest = 10; // Cartagena
        int[] prev = new int[n];
        int[] dist = DijkstraAdj.dijkstra(g, src, prev);

        System.out.println("Distancias desde " + cities[src] + ":");
        for (int i = 0; i < n; i++) {
            String d = (dist[i] >= DijkstraAdj.INF ? "INF" : String.valueOf(dist[i]));
            System.out.println("  " + cities[i] + " -> " + d);
        }

        System.out.println();
        System.out.println("Camino más corto (reconstruido):");
        String path = DijkstraAdj.reconstruirCamino(src, dest, prev, cities);
        System.out.println("  " + path);
        System.out.println("  Distancia total: " + (dist[dest] >= DijkstraAdj.INF ? "INF" : dist[dest] + " km"));

        // Rutas candidatas (ejemplo) y ordenamiento para elegir la menor
        int[][] rutas = new int[][] {
            {0,1,2,3,5,7,11,10}, // A
            {0,5,7,11,10},       // B
            {0,11,10}            // C (directa, modelo)
        };
        int[] pesos = new int[rutas.length];
        for (int i = 0; i < rutas.length; i++) pesos[i] = pesoRuta(g, rutas[i]);

        // Ordenar rutas por peso (Selection sort simple)
        selectionSortWithLabels(pesos, rutas);

        System.out.println();
        System.out.println("Rutas candidatas ordenadas por distancia:");
        for (int i = 0; i < rutas.length; i++) {
            System.out.print(" Ruta " + (char)('A'+i) + ": ");
            printRuta(rutas[i], cities);
            System.out.println("  Distancia = " + (pesos[i] >= DijkstraAdj.INF ? "INF" : pesos[i] + " km"));
        }

        System.out.println();
        System.out.println("(Fin del demo) - Adjunte diagrama y video de 3 minutos explicando los pasos."); 
    }

    // Calcula peso total de una ruta (devuelve INF si falta arista)
    public static int pesoRuta(Graph g, int[] ruta) {
        int total = 0;
        for (int i = 0; i < ruta.length - 1; i++) {
            int u = ruta[i], v = ruta[i+1];
            boolean found = false;
            for (Graph.Edge e : g.neighbors(u)) {
                if (e.to == v) { total += e.weight; found = true; break; }
            }
            if (!found) return DijkstraAdj.INF;
        }
        return total;
    }

    public static void printRuta(int[] ruta, String[] names) {
        for (int i = 0; i < ruta.length; i++) {
            if (i > 0) System.out.print(" -> ");
            System.out.print(names[ruta[i]]);
        }
        System.out.println();
    }

    // Selection sort que mantiene rutas paralelas
    public static void selectionSortWithLabels(int[] pesos, int[][] rutas) {
        int n = pesos.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) if (pesos[j] < pesos[min]) min = j;
            int t = pesos[i]; pesos[i] = pesos[min]; pesos[min] = t;
            int[] tmp = rutas[i]; rutas[i] = rutas[min]; rutas[min] = tmp;
        }
    }
}
