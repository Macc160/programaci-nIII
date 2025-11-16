public class ArbolBinarioBusqueda {
    class NodoArbol {
        int valor;
        NodoArbol izquierda, derecha;
        NodoArbol(int valor) { this.valor = valor; }
    }
    NodoArbol raiz;
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }
    private NodoArbol insertarRec(NodoArbol raiz, int valor) {
        if (raiz == null) return new NodoArbol(valor);
        if (valor < raiz.valor) raiz.izquierda = insertarRec(raiz.izquierda, valor);
        else if (valor > raiz.valor) raiz.derecha = insertarRec(raiz.derecha, valor);
        return raiz;
    }
}
