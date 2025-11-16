"""
Implementación del algoritmo de Dijkstra usando listas de adyacencia.
Autor: Estudiante
"""

class Grafo:
    def __init__(self):
        # Diccionario para listas de adyacencia {nodo: [(vecino, peso), ...]}
        self.adyacencia = {}

    def agregar_nodo(self, nodo):
        if nodo not in self.adyacencia:
            self.adyacencia[nodo] = []

    def agregar_arista(self, origen, destino, peso):
        # Grafo no dirigido
        self.adyacencia[origen].append((destino, peso))
        self.adyacencia[destino].append((origen, peso))

    def dijkstra(self, inicio):
        import heapq
        distancias = {nodo: float('inf') for nodo in self.adyacencia}
        distancias[inicio] = 0
        previo = {nodo: None for nodo in self.adyacencia}
        cola = [(0, inicio)]

        while cola:
            distancia_actual, nodo_actual = heapq.heappop(cola)
            if distancia_actual > distancias[nodo_actual]:
                continue
            for vecino, peso in self.adyacencia[nodo_actual]:
                nueva_distancia = distancia_actual + peso
                if nueva_distancia < distancias[vecino]:
                    distancias[vecino] = nueva_distancia
                    previo[vecino] = nodo_actual
                    heapq.heappush(cola, (nueva_distancia, vecino))
        return distancias, previo

    def reconstruir_camino(self, previo, inicio, fin):
        camino = []
        actual = fin
        while actual is not None:
            camino.append(actual)
            actual = previo[actual]
        return list(reversed(camino))
