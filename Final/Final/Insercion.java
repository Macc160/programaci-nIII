public class Insercion {
    public static void main(String[] args) {
        int[] datos = {5, 2, 4, 1, 3};
        for (int i = 1; i < datos.length; i++) {
            int valor = datos[i];
            int j = i - 1;
            while (j >= 0 && datos[j] > valor) {
                datos[j + 1] = datos[j];
                j--;
            }
            datos[j + 1] = valor;
        }
        for (int n : datos) System.out.print(n + " ");
    }
}
