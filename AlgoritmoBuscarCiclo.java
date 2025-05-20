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

    public void buscarCiclo(Grafo<T> grafo) {
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
                this.dfs(vertice, grafo);
            }
        }
    }

    private void dfs(T vertice, Grafo<T> grafo) {
        if (tengoCiclo) return; // early exit si ya se encontró ciclo
        // Lo agrego a vertices visitados
        visitando.add(vertice);
        // Obtengo sus adyacentes y los recorro
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            T adyacente = adyacentes.next();
            // Si un adyacente ya esta visitado y lo encuentro es un ciclo (volvi a un vertice en un camino simple)
            if (visitando.contains(adyacente)) {
                // Si ya está en el camino actual, hay un ciclo
                tengoCiclo = true;
                return;
            } else if (!visitados.contains(adyacente)) {
                // Si no, verifico que ya no haya sido visitado y sigo la dfs
                dfs(adyacente, grafo);
            }
            if (tengoCiclo) return; // Cortar recursión si ya se encontró
        }
        visitando.remove(vertice);
        visitados.add(vertice);
    }

    public boolean tengoCiclo(){
        return this.tengoCiclo;
    }
}
