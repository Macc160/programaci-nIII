public class Burbuja {
    public static void main(String[] args) {
        int[] datos = {5, 2, 4, 1, 3};
        for (int i = 0; i < datos.length - 1; i++) {
            for (int j = 0; j < datos.length - 1 - i; j++) {
                if (datos[j] > datos[j + 1]) {
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
        for (int n : datos) System.out.print(n + " ");
    }
}
