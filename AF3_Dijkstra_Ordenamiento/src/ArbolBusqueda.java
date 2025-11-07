import java.util.LinkedList;
import java.util.Queue;

public class ArbolBusqueda {

    static class NodoA {
        int dato;
        NodoA izq, der;
        NodoA(int d) { dato = d; izq = der = null; }
    }

    private NodoA raiz;

    public ArbolBusqueda() { raiz = null; }

    public void insertar(int valor) { raiz = insertarRec(raiz, valor); }
    private NodoA insertarRec(NodoA nodo, int valor) {
        if (nodo == null) return new NodoA(valor);
        if (valor < nodo.dato) nodo.izq = insertarRec(nodo.izq, valor);
        else if (valor > nodo.dato) nodo.der = insertarRec(nodo.der, valor);
        return nodo;
    }

    public void preorden() { preordenRec(raiz); System.out.println(); }
    private void preordenRec(NodoA n) {
        if (n != null) { System.out.print(n.dato + " "); preordenRec(n.izq); preordenRec(n.der); }
    }
    public void inorden() { inordenRec(raiz); System.out.println(); }
    private void inordenRec(NodoA n) {
        if (n != null) { inordenRec(n.izq); System.out.print(n.dato + " "); inordenRec(n.der); }
    }
    public void postorden() { postordenRec(raiz); System.out.println(); }
    private void postordenRec(NodoA n) {
        if (n != null) { postordenRec(n.izq); postordenRec(n.der); System.out.print(n.dato + " "); }
    }

    public int altura() { return alturaRec(raiz); }
    private int alturaRec(NodoA n) {
        if (n == null) return 0;
        return 1 + Math.max(alturaRec(n.izq), alturaRec(n.der));
    }

    public boolean esBalanceado() { return esBalanceadoRec(raiz); }
    private boolean esBalanceadoRec(NodoA n) {
        if (n == null) return true;
        int izq = alturaRec(n.izq);
        int der = alturaRec(n.der);
        if (Math.abs(izq - der) > 1) return false;
        return esBalanceadoRec(n.izq) && esBalanceadoRec(n.der);
    }

    public boolean esDegenerado() { return esDegeneradoRec(raiz); }
    private boolean esDegeneradoRec(NodoA n) {
        if (n == null) return true;
        if (n.izq != null && n.der != null) return false;
        return esDegeneradoRec(n.izq != null ? n.izq : n.der);
    }

    public boolean esCompleto() {
        if (raiz == null) return true;
        Queue<NodoA> q = new LinkedList<>();
        q.add(raiz);
        boolean hueco = false;
        while (!q.isEmpty()) {
            NodoA cur = q.poll();
            if (cur.izq != null) {
                if (hueco) return false;
                q.add(cur.izq);
            } else hueco = true;
            if (cur.der != null) {
                if (hueco) return false;
                q.add(cur.der);
            } else hueco = true;
        }
        return true;
    }

    public boolean esPerfecto() {
        int h = altura();
        return esPerfectoRec(raiz, h, 1);
    }
    private boolean esPerfectoRec(NodoA n, int h, int nivel) {
        if (n == null) return true;
        if (n.izq == null && n.der == null) return h == nivel;
        if (n.izq == null || n.der == null) return false;
        return esPerfectoRec(n.izq, h, nivel+1) && esPerfectoRec(n.der, h, nivel+1);
    }

    public int contarNodos() { return contarRec(raiz); }
    private int contarRec(NodoA n) { if (n==null) return 0; return 1 + contarRec(n.izq) + contarRec(n.der); }
    public int contarHojas() { return contarHojasRec(raiz); }
    private int contarHojasRec(NodoA n) { if (n==null) return 0; if (n.izq==null && n.der==null) return 1; return contarHojasRec(n.izq)+contarHojasRec(n.der); }

    public void recorridoAnchura() {
        if (raiz == null) return;
        Queue<NodoA> q = new LinkedList<>();
        q.add(raiz);
        while (!q.isEmpty()) {
            NodoA cur = q.poll();
            System.out.print(cur.dato + " ");
            if (cur.izq != null) q.add(cur.izq);
            if (cur.der != null) q.add(cur.der);
        }
        System.out.println();
    }
}
