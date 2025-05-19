import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BreadhtFirstSearch<T> {
    private  Grafo<T> grafo;
    private final Cola<T> cola;
    private final Set<T> visitados;

    public BreadhtFirstSearch(){
        this.grafo = new GrafoDirigido<>();
        this.cola = new Cola<>();
        this.visitados = new HashSet<>();
    }

    public void bfs(Grafo<T> g){
        // Limpio los vertices visitados
        this.visitados.clear();
        this.grafo = g;

        // Recorro todos los vertices si no fueron visitados
        Iterator<T> verticesKey = grafo.obtenerVertices();
        T vertice = null;
        while(verticesKey.hasNext()){
            vertice = verticesKey.next();
            if(!this.visitados.contains(vertice)){
                this.bfs(vertice);
            }
        }
    }

    private void bfs(T verticePrincipal){
        this.cola.addCola(verticePrincipal);
        while(!this.cola.isEmpty()){
            T vertice = this.cola.getCola();
            Iterator<T> iteratorAdy = this.grafo.obtenerAdyacentes(vertice);
            while(iteratorAdy.hasNext()){
                T ady = iteratorAdy.next();
                cola.addCola(ady);
            }
            this.visitados.add(vertice);
            }
        }
    }
}
