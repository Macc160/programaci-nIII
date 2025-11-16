# Proyecto: Algoritmo de Dijkstra en Java (Maven)

Este proyecto implementa el algoritmo de Dijkstra usando listas de adyacencia en Java para encontrar el camino más corto entre Cali y Cartagena, basado en el grafo proporcionado.

## Instrucciones:
1. Compila el proyecto:
   ```bash
   mvn compile
   ```
2. Ejecuta el programa:
   ```bash
   mvn exec:java -Dexec.mainClass="Main"
   ```

## Grafo:
Cali → Pereira (105)
Pereira → Medellín (180)
Medellín → Valledupar (390)
Valledupar → Bogotá (130)
Bogotá → Barranquilla (100)
Cartagena → Barranquilla (120)
Cartagena → Valledupar (200)
