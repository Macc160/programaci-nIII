"""
Ordena recorridos por distancia.
"""

def ordenar_recorridos(recorridos):
    return sorted(recorridos, key=lambda x: x[1])
