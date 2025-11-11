public class ColaNodo {
    private Nodo[] datos;
    private int frente, fin, tam;

    public ColaNodo(int capacidad) {
        tam = capacidad;
        datos = new Nodo[tam];
        frente = 0;
        fin = 0;
    }

    public boolean vacia() {
        return frente == fin;
    }

    public boolean encolar(Nodo x) {
        if (fin == tam) return false;
        datos[fin++] = x;
        return true;
    }

    public Nodo desencolar() {
        if (vacia()) return null;
        Nodo r = datos[frente++];
        return r;
    }
}
