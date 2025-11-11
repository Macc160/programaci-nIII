public class MergeSort {
    public static void main(String[] args) {
        int[] datos = {5, 2, 4, 1, 3};
        mergeSort(datos, 0, datos.length - 1);
        for (int n : datos) System.out.print(n + " ");
    }
    static void mergeSort(int[] a, int i, int f) {
        if (i < f) {
            int m = (i + f) / 2;
            mergeSort(a, i, m);
            mergeSort(a, m + 1, f);
            merge(a, i, m, f);
        }
    }
    static void merge(int[] a, int i, int m, int f) {
        int[] aux = new int[f - i + 1];
        int p = i, q = m + 1, k = 0;
        while (p <= m && q <= f) aux[k++] = (a[p] <= a[q]) ? a[p++] : a[q++];
        while (p <= m) aux[k++] = a[p++];
        while (q <= f) aux[k++] = a[q++];
        System.arraycopy(aux, 0, a, i, aux.length);
    }
}
