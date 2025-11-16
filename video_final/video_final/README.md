# Proyecto: Dijkstra - Grafo de ciudades (Entrega)

Contenido del ZIP `video_final.zip`:
- `src/app/Main.java` : clase principal que construye el grafo y ejecuta Dijkstra.
- `src/graph/Graph.java` : implementación del grafo con listas de adyacencia y Dijkstra.
- `README.md` : este archivo con la explicación, supuestos y cómo compilar/ejecutar.
- `script/run.sh` : script para compilar y ejecutar (Linux / WSL / Git Bash).

## Supuestos y notas importantes
He modelado el grafo usando la imagen que me enviaste. En la imagen se observan claramente los siguientes pesos:
- Cali - Pereira = **105**
- Pereira - Bogotá = **130**
- Barranquilla - Bogotá = **100**
- Un número **390** en el centro (lo interpreté como Valledupar - Bogotá)

Para las aristas que no tienen peso visible en la imagen he hecho **asunciones razonables** para que el grafo sea conectable y permita demostrar el algoritmo:
- Pereira - Medellín = 160
- Medellín - Cartagena = 400
- Medellín - Valledupar = 80
- Valledupar - Barranquilla = 180
- Cartagena - Barranquilla = 260

> Si tu profe exige pesos exactos distintos a estos, reemplaza los valores en `src/app/Main.java` antes de compilar. Los nombres de nodos y la estructura del código cumplen con el requisito: **listas de adyacencia (ArrayList / LinkedList)** y algoritmo de **Dijkstra**.

## Cómo compilar y ejecutar (Java)
Desde la raíz del proyecto (donde está `src`):

```bash
# compilar
javac -d out src/graph/Graph.java src/app/Main.java

# ejecutar
java -cp out app.Main
```

O usar el script (Linux / WSL / Git Bash):
```bash
bash script/run.sh
```

## Entrega para GitHub
- Sube la carpeta `src` y este README.
- Agrega un `README` en el repo explicando los supuestos (copia el texto anterior).
- En el video de 3 minutos explica: el grafo, las asunciones, cómo corre el algoritmo paso a paso y muestra la ejecución en consola.

## Guion corto para el video (3 minutos)
1. (0:00-0:20) Presentación y objetivo: implementar Dijkstra con listas de adyacencia. Nodo inicial: **Cali**. Nodo final: **Cartagena**.
2. (0:20-0:50) Mostrar la imagen del mapa y explicar qué nodos se modelaron y por qué. Mostrar los pesos visibles y mencionar los supuestos.
3. (0:50-1:40) Explicar la estructura del código: `Graph.java` (lista de adyacencia), `Main.java` (construcción y ejecución). Mostrar pseudocódigo de Dijkstra.
4. (1:40-2:30) Ejecutar el programa en consola y explicar cómo se actualizan distancias y se elige el siguiente nodo (cola de prioridad).
5. (2:30-2:50) Mostrar resultado: camino mínimo y distancia.
6. (2:50-3:00) Cierre y referencias al repositorio (menciona nombre del ZIP: `video_final.zip`).

## Contacto
Si quieres que ajuste los pesos exactamente según la rubrica del profe o que agregue salida CSV con los recorridos paso a paso, dime y lo actualizo.
