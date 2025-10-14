import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si esta vacia

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() { 
            return tope == -1; 
        }

        public boolean estaLlena() { 
            return tope + 1 == datos.length; 
        }

        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacia");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts) Verifica si los parentesis estan balanceados.
    public static boolean esBalanceado(String s) {
        // Usa la pila para comprobar los parentesis
        PilaEnteros pila = new PilaEnteros(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') pila.apilar(1); // guarda el parentesis abierto
            else if (c == ')') {
                if (pila.estaVacia()) return false; // no hay con que cerrar
                pila.desapilar(); // quita el abierto
            }
        }
        return pila.estaVacia(); // vacia = balanceado
    }

    // (50 pts) Actualiza la calificacion si existe el id y esta en rango 0..100.
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        // valida rango y existencia
        if (nuevo < 0 || nuevo > 100) return false;
        if (califPorId.containsKey(id)) {
            califPorId.put(id, nuevo);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}
