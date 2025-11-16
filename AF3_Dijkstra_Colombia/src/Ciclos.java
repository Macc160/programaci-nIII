// Ciclos.java (main) - AF3 Dijkstra Colombia (Cali -> Cartagena)
public class Ciclos {
    public static void main(String[] args) {
        String[] cities = {"Cali","Palmira","Buga","Tuluá","Armenia","Pereira","Manizales","Medellín","Sincelejo","Montería","Cartagena","Barranquilla"};
        int n = cities.length;
        Graph g = new Graph(n);

        // modelado simplificado (kms aproximados)
        g.addEdge(0,1,35); g.addEdge(1,2,40); g.addEdge(2,3,45); g.addEdge(3,4,70);
        g.addEdge(4,5,65); g.addEdge(5,6,60); g.addEdge(6,7,200); g.addEdge(7,9,170);
        g.addEdge(9,10,300); g.addEdge(7,11,220); g.addEdge(11,10,130); g.addEdge(0,5,220);
        g.addEdge(5,7,260); g.addEdge(7,8,280); g.addEdge(8,10,160); g.addEdge(0,11,700);

        int src = 0; int dest = 10;
        int[] prev = new int[n];
        int[] dist = DijkstraAdj.dijkstra(g, src, prev);

        System.out.println("Distancias desde " + cities[src] + ":");
        for (int i = 0; i < n; i++) {
            String d = (dist[i] >= DijkstraAdj.INF ? "INF" : String.valueOf(dist[i]));
            System.out.println("  " + cities[i] + " -> " + d + " km");
        }

        System.out.println();
        String camino = DijkstraAdj.reconstruirCamino(src, dest, prev, cities);
        System.out.println("Camino más corto: " + camino);
        System.out.println("Distancia total: " + (dist[dest] >= DijkstraAdj.INF ? "INF" : dist[dest] + " km"));

        // Rutas candidatas y ordenamiento
        int[][] rutas = {{0,1,2,3,4,5,7,9,10},{0,5,7,11,10},{0,11,10}};
        int[] pesos = new int[rutas.length];
        for (int i = 0; i < rutas.length; i++) pesos[i] = pesoRuta(g, rutas[i]);
        selectionSortWithLabels(pesos, rutas);

        System.out.println(); System.out.println("Rutas candidatas ordenadas por distancia:");
        for (int i = 0; i < rutas.length; i++) {
            System.out.print(" Ruta " + (char)('A'+i) + ": ");
            printRuta(rutas[i], cities);
            System.out.println("  Distancia = " + (pesos[i] >= DijkstraAdj.INF ? "INF" : pesos[i] + " km"));
        }

        System.out.println(); System.out.println("Adjuntar diagrama en imagenes/diagrama_cali_cartagena.png y grabar video de 3 minutos.");
    }

    public static int pesoRuta(Graph g, int[] ruta) {
        int total = 0;
        for (int i = 0; i < ruta.length-1; i++) {
            int u = ruta[i], v = ruta[i+1]; boolean found = false;
            for (Graph.Edge e : g.neighbors(u)) if (e.to == v) { total += e.weight; found = true; break; }
            if (!found) return DijkstraAdj.INF;
        }
        return total;
    }

    public static void printRuta(int[] ruta, String[] names) {
        for (int i = 0; i < ruta.length; i++) {
            if (i>0) System.out.print(" -> ");
            System.out.print(names[ruta[i]]);
        }
        System.out.println();
    }

    public static void selectionSortWithLabels(int[] pesos, int[][] rutas) {
        int n = pesos.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) if (pesos[j] < pesos[min]) min = j;
            int t = pesos[i]; pesos[i] = pesos[min]; pesos[min] = t;
            int[] tmp = rutas[i]; rutas[i] = rutas[min]; rutas[min] = tmp;
        }
    }
}
