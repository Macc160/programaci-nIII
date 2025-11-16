import java.util.LinkedList;
public class ColaNodo {
    private LinkedList<Nodo> cola = new LinkedList<>();
    public void encolar(Nodo nodo) { cola.addLast(nodo); }
    public Nodo desencolar() { return cola.pollFirst(); }
    public boolean estaVacia() { return cola.isEmpty(); }
}
