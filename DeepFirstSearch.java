import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeepFirstSearch<T> {
    private final Set<Integer> visitados;

    DeepFirstSearch(){
        this.visitados = new HashSet<>();
    }

    public void deepFirstSearch(GrafoDirigido<T> grafo){
        // Vaciar mis vertices visitados
        this.visitados.clear();

        // Recorrer cada vertice si no fue visitado
        Iterator<Integer> verticesKey = grafo.obtenerVertices();
        while(verticesKey.hasNext()){
            //agarro cada vertice
            Integer vertice = verticesKey.next();
            //verifico si el vertice no fue visitado
            if(!this.visitados.contains(vertice)){
                this.deepFirstSearch(grafo, vertice);
            }
        }
    }

    private void deepFirstSearch(GrafoDirigido<T> g, int idVertice){
        this.visitados.add(idVertice);
        Iterator<Integer> iteratorAdyacentes = g.obtenerAdyacentes(idVertice);
        // Mientras tenga adyacentes hago un deepFirstSearch por cada uno
        while(iteratorAdyacentes.hasNext()){
            Integer ady = iteratorAdyacentes.next();
            if(!this.visitados.contains(ady)){
                this.deepFirstSearch(g, ady);
            }
        }
    }

    public Set<Integer> getVisitados() {
        return visitados;
    }
}
