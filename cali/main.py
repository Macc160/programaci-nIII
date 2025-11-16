from dijkstra import Grafo
from ordenamiento import ordenar_recorridos

# Crear grafo con ciudades del mapa
g = Grafo()
ciudades = ["Cali", "Pereira", "Medellín", "Valledupar", "Bogotá", "Barranquilla", "Cartagena"]
for ciudad in ciudades:
    g.agregar_nodo(ciudad)

# Agregar aristas según el grafo de la imagen
g.agregar_arista("Cali", "Pereira", 105)
g.agregar_arista("Pereira", "Medellín", 180)
g.agregar_arista("Medellín", "Valledupar", 390)
g.agregar_arista("Valledupar", "Bogotá", 130)
g.agregar_arista("Bogotá", "Barranquilla", 100)
g.agregar_arista("Cartagena", "Barranquilla", 120)
g.agregar_arista("Cartagena", "Valledupar", 200)

# Ejecutar Dijkstra desde Cali
distancias, previo = g.dijkstra("Cali")
camino = g.reconstruir_camino(previo, "Cali", "Cartagena")

print("Camino más corto de Cali a Cartagena:", camino)
print("Distancia total:", distancias["Cartagena"])
