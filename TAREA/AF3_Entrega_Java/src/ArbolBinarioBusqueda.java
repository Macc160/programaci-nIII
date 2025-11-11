public class ArbolBinarioBusqueda {

    public Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    // Inserción iterativa (propiedad ABB)
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (raiz == null) {
            raiz = nuevo;
            return;
        }
        Nodo actual = raiz;
        Nodo padre = null;
        while (actual != null) {
            padre = actual;
            if (valor < actual.dato) actual = actual.izq;
            else if (valor > actual.dato) actual = actual.der;
            else return; // no insertar duplicados
        }
        if (valor < padre.dato) padre.izq = nuevo;
        else padre.der = nuevo;
    }

    // Búsqueda (iterativa)
    public boolean buscar(int valor) {
        Nodo actual = raiz;
        while (actual != null) {
            if (valor == actual.dato) return true;
            if (valor < actual.dato) actual = actual.izq;
            else actual = actual.der;
        }
        return false;
    }

    // Recorridos recursivos
    public void preorden(Nodo r) {
        if (r != null) {
            System.out.print(r.dato + " ");
            preorden(r.izq);
            preorden(r.der);
        }
    }

    public void inorden(Nodo r) {
        if (r != null) {
            inorden(r.izq);
            System.out.print(r.dato + " ");
            inorden(r.der);
        }
    }

    public void posorden(Nodo r) {
        if (r != null) {
            posorden(r.izq);
            posorden(r.der);
            System.out.print(r.dato + " ");
        }
    }

    // Recorrido por niveles (anchura) usando ColaNodo
    public void recorridoAnchura() {
        if (raiz == null) return;
        ColaNodo q = new ColaNodo(1000);
        q.encolar(raiz);
        while (!q.vacia()) {
            Nodo cur = q.desencolar();
            System.out.print(cur.dato + " ");
            if (cur.izq != null) q.encolar(cur.izq);
            if (cur.der != null) q.encolar(cur.der);
        }
        System.out.println();
    }

    // Altura del árbol (nodos)
    public int altura(Nodo r) {
        if (r == null) return 0;
        int iz = altura(r.izq);
        int de = altura(r.der);
        return 1 + (iz > de ? iz : de);
    }

    // Está balanceado (altura diferencia <=1 para cada nodo)
    public boolean estaBalanceado(Nodo r) {
        if (r == null) return true;
        int iz = altura(r.izq);
        int de = altura(r.der);
        if (Math.abs(iz - de) > 1) return false;
        return estaBalanceado(r.izq) && estaBalanceado(r.der);
    }

    // Árbol degenerado: cada nodo tiene a lo sumo un hijo
    public boolean esDegenerado(Nodo r) {
        if (r == null) return true;
        if (r.izq != null && r.der != null) return false;
        return esDegenerado(r.izq != null ? r.izq : r.der);
    }

    // Contar nodos y hojas
    public int contarNodos(Nodo r) {
        if (r == null) return 0;
        return 1 + contarNodos(r.izq) + contarNodos(r.der);
    }

    public int contarHojas(Nodo r) {
        if (r == null) return 0;
        if (r.izq == null && r.der == null) return 1;
        return contarHojas(r.izq) + contarHojas(r.der);
    }

    // Árbol completo todos los niveles (excepto posiblemente el último) llenos y nodos a la izquierda
    public boolean esCompleto() {
        if (raiz == null) return true;
        ColaNodo q = new ColaNodo(1000);
        q.encolar(raiz);
        boolean flagHueco = false;
        while (!q.vacia()) {
            Nodo cur = q.desencolar();
            if (cur.izq != null) {
                if (flagHueco) return false;
                q.encolar(cur.izq);
            } else flagHueco = true;
            if (cur.der != null) {
                if (flagHueco) return false;
                q.encolar(cur.der);
            } else flagHueco = true;
        }
        return true;
    }

    // Árbol perfecto: todos los nodos son hojas o tienen dos hijos y todas las hojas al mismo nivel
    public boolean esPerfecto() {
        int h = altura(raiz);
        return esPerfectoRec(raiz, h, 1);
    }

    private boolean esPerfectoRec(Nodo n, int alturaTotal, int nivel) {
        if (n == null) return true;
        if (n.izq == null && n.der == null) return alturaTotal == nivel;
        if (n.izq == null || n.der == null) return false;
        return esPerfectoRec(n.izq, alturaTotal, nivel+1) && esPerfectoRec(n.der, alturaTotal, nivel+1);
    }
}
