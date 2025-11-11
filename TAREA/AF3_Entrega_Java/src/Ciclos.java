// Clase principal Ciclos (Programacion 3+), sin paquetes ni imports externos
public class Ciclos {

    public static void demoOrdenamientos() {
        int[] original = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Original: "); printArr(original);

        int[] a = copy(original);
        BubbleSort.sort(a);
        System.out.print("BubbleSort: "); printArr(a);

        a = copy(original);
        BubbleMejorado.sort(a);
        System.out.print("BubbleMejorado: "); printArr(a);

        a = copy(original);
        SelectionSort.sort(a);
        System.out.print("SelectionSort: "); printArr(a);

        a = copy(original);
        InsertionSort.sort(a);
        System.out.print("InsertionSort: "); printArr(a);

        a = copy(original);
        QuickSort.sort(a);
        System.out.print("QuickSort: "); printArr(a);

        a = copy(original);
        MergeSort.sort(a);
        System.out.print("MergeSort: "); printArr(a);
    }

    private static int[] copy(int[] src) {
        int[] r = new int[src.length];
        for (int i = 0; i < src.length; i++) r[i] = src[i];
        return r;
    }

    private static void printArr(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length-1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void demoDijkstra() {
        // Grafo ejemplo (puedes cambiarlo por el tuyo)
        int[][] graph = {
            {0,2,0,1,0,0},
            {0,0,1,0,0,0},
            {0,0,0,3,0,0},
            {0,0,0,0,2,0},
            {0,0,0,0,0,2},
            {1,0,0,0,4,0}
        };
        int src = 0;
        int[] dist = Dijkstra.dijkstra(graph, src);
        Dijkstra.imprimirDist(dist, src);
    }

    public static void demoArbol() {
        ArbolBinarioBusqueda ar = new ArbolBinarioBusqueda();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) ar.insertar(v);

        System.out.print("Preorden: "); ar.preorden(ar.raiz); System.out.println();
        System.out.print("Inorden: "); ar.inorden(ar.raiz); System.out.println();
        System.out.print("Posorden: "); ar.posorden(ar.raiz); System.out.println();

        System.out.print("Anchura: "); ar.recorridoAnchura();

        System.out.println("Altura: " + ar.altura(ar.raiz));
        System.out.println("Nodos totales: " + ar.contarNodos(ar.raiz));
        System.out.println("Hojas: " + ar.contarHojas(ar.raiz));
        System.out.println("Balanceado?: " + (ar.estaBalanceado(ar.raiz) ? "Si" : "No"));
        System.out.println("Degenerado?: " + (ar.esDegenerado(ar.raiz) ? "Si" : "No"));
        System.out.println("Completo?: " + (ar.esCompleto() ? "Si" : "No"));
        System.out.println("Perfecto?: " + (ar.esPerfecto() ? "Si" : "No"));
    }

    public static void main(String[] args) {
        System.out.println("=== DEMO ORDENAMIENTOS ===");
        demoOrdenamientos();
        System.out.println("\n=== DEMO DIJKSTRA ===");
        demoDijkstra();
        System.out.println("\n=== DEMO ARBOL BINARIO DE BUSQUEDA ===");
        demoArbol();
    }
}
