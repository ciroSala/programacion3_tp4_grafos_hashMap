import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AlgoritmoBuscarCiclo<T> {
    private final Set<T> visitados;
    private final Set<T> visitando;

    public AlgoritmoBuscarCiclo() {
        this.visitados = new HashSet<>();
        this.visitando = new HashSet<>();
    }

    public boolean searchCycle(Grafo<T> grafo) {
        // Recibo el grafo
        // Reinicio los vertices visitados
        this.visitados.clear();

        // Recorro los vertices
        Iterator<T> verticesKey = grafo.obtenerVertices();
        while (verticesKey.hasNext()) {
            T vertice = verticesKey.next();
            if (!this.visitados.contains(vertice)) {
                if(this.searchCycle(vertice, grafo)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchCycle(T vertice, Grafo<T> grafo) {
        this.visitando.add(vertice); // Agrego el vertice a visitando
        // Obtengo sus adyacentes y los recorro
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            T adyacente = adyacentes.next();
            // Si un adyacente ya esta visitado y lo encuentro es un ciclo (volvi a un vertice en un camino simple)
            if (visitando.contains(adyacente)) {
                // Si ya está en el camino actual, hay un ciclo
                return true;
            } else if (!visitados.contains(adyacente)) { //Si no se esta visitando y no esta visitado
                if(this.searchCycle(adyacente, grafo)){
                    return true;
                }
            }
        }
        visitando.remove(vertice);
        visitados.add(vertice);
        return false;
    }
}
