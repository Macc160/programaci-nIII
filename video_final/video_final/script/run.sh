#!/bin/bash
mkdir -p out
javac -d out src/graph/Graph.java src/app/Main.java
echo "Ejecutando..."
java -cp out app.Main
