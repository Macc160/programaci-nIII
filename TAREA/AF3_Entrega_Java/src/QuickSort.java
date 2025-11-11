public class QuickSort {
    public static void sort(int[] a) {
        quick(a, 0, a.length-1);
    }
    private static void quick(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quick(a, lo, p-1);
            quick(a, p+1, hi);
        }
    }
    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }
        int t = a[i+1]; a[i+1] = a[hi]; a[hi] = t;
        return i+1;
    }
}
