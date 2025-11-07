import java.util.Arrays;
import java.util.Scanner;

public class Ciclos {

    private static Scanner sc = new Scanner(System.in);

    private static void demoOrdenamientos() {
        System.out.println("--- DEMO MÉTODOS DE ORDENAMIENTO ---");
        int[] original = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + Arrays.toString(original));

        // Burbuja
        int[] arr = Arrays.copyOf(original, original.length);
        BubbleSort.sort(arr);
        System.out.println("Burbuja: " + Arrays.toString(arr));

        // Burbuja mejorado
        arr = Arrays.copyOf(original, original.length);
        BubbleMejorado.sort(arr);
        System.out.println("Burbuja mejorado: " + Arrays.toString(arr));

        // Selección
        arr = Arrays.copyOf(original, original.length);
        SelectionSort.sort(arr);
        System.out.println("Selección: " + Arrays.toString(arr));

        // Inserción
        arr = Arrays.copyOf(original, original.length);
        InsertionSort.sort(arr);
        System.out.println("Inserción: " + Arrays.toString(arr));

        // QuickSort
        arr = Arrays.copyOf(original, original.length);
        QuickSort.sort(arr);
        System.out.println("QuickSort: " + Arrays.toString(arr));

        // MergeSort
        arr = Arrays.copyOf(original, original.length);
        MergeSort.sort(arr);
        System.out.println("MergeSort: " + Arrays.toString(arr));
    }

    private static void demoDijkstra() {
        System.out.println("--- DEMO DIJKSTRA (MATRIZ DE ADYACENCIA) ---");

        // Ejemplo de grafo con 9 nodos (usar Integer.MAX_VALUE como INF)
        int INF = Integer.MAX_VALUE;
        int[][] graph = {
            {0, 4, INF, INF, INF, INF, INF, 8, INF},
            {4, 0, 8, INF, INF, INF, INF, 11, INF},
            {INF, 8, 0, 7, INF, 4, INF, INF, 2},
            {INF, INF, 7, 0, 9, 14, INF, INF, INF},
            {INF, INF, INF, 9, 0, 10, INF, INF, INF},
            {INF, INF, 4, 14, 10, 0, 2, INF, INF},
            {INF, INF, INF, INF, INF, 2, 0, 1, 6},
            {8, 11, INF, INF, INF, INF, 1, 0, 7},
            {INF, INF, 2, INF, INF, INF, 6, 7, 0}
        };

        System.out.print("Ingresa el nodo origen (0-8), por defecto 0: ");
        String line = sc.nextLine().trim();
        int src = 0;
        if (!line.isEmpty()) {
            try { src = Integer.parseInt(line); if (src < 0 || src >= graph.length) src = 0; } catch (Exception e){ src = 0; }
        }
        int[] dist = Dijkstra.dijkstra(graph, src);
        Dijkstra.imprimirDistancias(dist, src);
    }

    private static void demoArbolBusqueda() {
        System.out.println("--- DEMO ÁRBOL BINARIO DE BÚSQUEDA ---");
        ArbolBusqueda ar = new ArbolBusqueda();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) ar.insertar(v);

        System.out.print("Preorden: "); ar.preorden();
        System.out.print("Inorden: "); ar.inorden();
        System.out.print("Postorden: "); ar.postorden();
        System.out.print("Anchura: "); ar.recorridoAnchura();

        System.out.println("Altura: " + ar.altura());
        System.out.println("Nodos totales: " + ar.contarNodos());
        System.out.println("Hojas: " + ar.contarHojas());
        System.out.println("¿Balanceado?: " + (ar.esBalanceado() ? "Sí" : "No"));
        System.out.println("¿Degenerado?: " + (ar.esDegenerado() ? "Sí" : "No"));
        System.out.println("¿Completo?: " + (ar.esCompleto() ? "Sí" : "No"));
        System.out.println("¿Perfecto?: " + (ar.esPerfecto() ? "Sí" : "No"));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1) Métodos de ordenamiento (Burbuja, Quick, Merge, Inserción, Selección, Burbuja Mejorado)");
            System.out.println("2) Algoritmo de Dijkstra (matriz de adyacencia)"); 
            System.out.println("3) Árbol binario de búsqueda (recorridos y análisis)"); 
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            String opt = sc.nextLine().trim();
            if (opt.equals("0")) {
                System.out.println("Saliendo...");
                break;
            }
            switch (opt) {
                case "1": demoOrdenamientos(); break;
                case "2": demoDijkstra(); break;
                case "3": demoArbolBusqueda(); break;
                default: System.out.println("Opción no válida, intenta otra vez."); break;
            }
        }
        sc.close();
    }
}
