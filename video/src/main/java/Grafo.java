import java.util.*;

class Arista {
    String destino;
    int peso;

    Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

public class Grafo {
    private Map<String, List<Arista>> adyacencia;

    public Grafo() {
        adyacencia = new HashMap<>();
    }

    public void agregarNodo(String nodo) {
        adyacencia.putIfAbsent(nodo, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso));
    }

    public Map<String, List<Arista>> getAdyacencia() {
        return adyacencia;
    }
}
