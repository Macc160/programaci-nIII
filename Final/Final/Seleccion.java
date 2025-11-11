public class Seleccion {
    public static void main(String[] args) {
        int[] datos = {5, 2, 4, 1, 3};
        for (int i = 0; i < datos.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[min]) min = j;
            }
            int temp = datos[min];
            datos[min] = datos[i];
            datos[i] = temp;
        }
        for (int n : datos) System.out.print(n + " ");
    }
}
