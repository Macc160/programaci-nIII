public class QuickSort {
    public static void main(String[] args) {
        int[] datos = {5, 2, 4, 1, 3};
        quick(datos, 0, datos.length - 1);
        for (int n : datos) System.out.print(n + " ");
    }
    static void quick(int[] a, int i, int f) {
        if (i < f) {
            int p = part(a, i, f);
            quick(a, i, p - 1);
            quick(a, p + 1, f);
        }
    }
    static int part(int[] a, int i, int f) {
        int piv = a[f], p = i - 1;
        for (int j = i; j < f; j++) {
            if (a[j] <= piv) {
                p++;
                int t = a[p]; a[p] = a[j]; a[j] = t;
            }
        }
        int t = a[p + 1]; a[p + 1] = a[f]; a[f] = t;
        return p + 1;
    }
}
