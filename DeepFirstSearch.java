import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeepFirstSearch<T> {
    private final Set<T> visitados;

    public DeepFirstSearch(){
        this.visitados = new HashSet<>();
        this.grafo = new GrafoDirigido<>();
    }

    public void deepFirstSearch(GrafoDirigido<T> grafo){
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
                this.deepFirstSearch(vertice, grafo);
            }
        }
    }

    private void deepFirstSearch(T vertice, Grafo<T> grafo){
            Iterator<T> iteratorAdyacentes = grafo.obtenerAdyacentes(vertice);
            // Mientras tenga adyacentes hago un deepFirstSearch por cada uno
            while(iteratorAdyacentes.hasNext()){
                T ady = iteratorAdyacentes.next();
                if(!this.visitados.contains(ady)) {
                    this.visitados.add(ady);
                    this.deepFirstSearch(ady, grafo);
                }
            }
    }

    public Set<T> getVisitados() {
        return this.visitados;
    }
}

