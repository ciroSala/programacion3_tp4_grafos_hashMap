import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DepthFirstSearch<T> {
    private final Set<T> visitados;

    public DepthFirstSearch(){
        this.visitados = new HashSet<>();
    }

    public void depthFirstSearch(GrafoDirigido<T> grafo){
        // Vaciar mis vertices visitados y setear grafo
        this.visitados.clear();

        // Recorrer cada vertice si no fue visitado
        Iterator<T> verticesKey = grafo.obtenerVertices();

        while(verticesKey.hasNext()){
            //agarro cada vertice
            T vertice = verticesKey.next();
            //verifico si el vertice no fue visitado
            if(!this.visitados.contains(vertice)){
                this.visitados.add(vertice);
                this.depthFirstSearch(vertice, grafo);
            }
        }
    }

    private void depthFirstSearch(T vertice, GrafoDirigido<T> grafo){
        Iterator<T> iteratorAdyacentes = grafo.obtenerAdyacentes(vertice);
        // Mientras tenga adyacentes hago un deepFirstSearch por cada uno
        while(iteratorAdyacentes.hasNext()){
            T ady = iteratorAdyacentes.next();
            if(!this.visitados.contains(ady)) {
                this.visitados.add(ady);
                this.depthFirstSearch(ady, grafo);
            }
        }
    }

    public Set<T> getVisitados() {
        return this.visitados;
    }
}

