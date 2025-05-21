import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AlgoritmoBuscarCiclo<T> {
    private boolean tengoCiclo;
    private final Set<T> visitados;
    private final Set<T> visitando;

    public AlgoritmoBuscarCiclo() {
        this.visitados = new HashSet<>();
        this.visitando = new HashSet<>();
        this.tengoCiclo = false;
    }

    public boolean searchCycle(Grafo<T> grafo) {
        // Recibo el grafo
        // Reinicio la variable de tengo ciclo
        // Reinicio los vertices visitados
        this.tengoCiclo = false;
        this.visitados.clear();

        // Recorro los vertices
        Iterator<T> verticesKey = grafo.obtenerVertices();
        while (verticesKey.hasNext()) {
            T vertice = verticesKey.next();
            if (!this.visitados.contains(vertice)) {
                // Lo agrego a vertices visitados
                visitando.add(vertice);
                if(this.searchCycle(vertice, grafo)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchCycle(T vertice, Grafo<T> grafo) {
        // Obtengo sus adyacentes y los recorro
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            T adyacente = adyacentes.next();
            // Si un adyacente ya esta visitado y lo encuentro es un ciclo (volvi a un vertice en un camino simple)
            if (visitando.contains(adyacente)) {
                // Si ya está en el camino actual, hay un ciclo
                return true;
            } else if (!visitados.contains(adyacente)) {
                // Si no, verifico que ya no haya sido visitado y sigo la dfs
                if(this.searchCycle(adyacente, grafo)){
                    return true;
                }
            }
        }
        visitando.remove(vertice);
        visitados.add(vertice);
        return false;
    }

    public boolean tengoCiclo(){
        return this.tengoCiclo;
    }
}
