import java.util.*;

public class BreadthFirstSearch<T> {
    private final Queue<T> cola;
    private final Set<T> visitados;

    public BreadthFirstSearch(){
        this.cola = new LinkedList<>(); // Usamos LinkedList como implementación de Queue
        this.visitados = new HashSet<>();
    }

    public void bfs(Grafo<T> grafo){
        // Limpio los vertices visitados
        this.visitados.clear();

        // Recorro todos los vertices si no fueron visitados
        Iterator<T> verticesKey = grafo.obtenerVertices();
        T vertice = null;
        while(verticesKey.hasNext()){
            vertice = verticesKey.next();
            if(!this.visitados.contains(vertice)){
                this.bfs(vertice, grafo);
            }
        }
    }

    private void bfs(T verticePrincipal, Grafo<T> grafo){
        // Agregamos el primer elemento a la cola y lo agregamos como visitado
        this.cola.offer(verticePrincipal);
        this.visitados.add(verticePrincipal);
        while(!this.cola.isEmpty()){
            T vertice = this.cola.poll();
            Iterator<T> iteratorAdy = grafo.obtenerAdyacentes(vertice);
            while(iteratorAdy.hasNext()){
                T ady = iteratorAdy.next();
                if(!this.visitados.contains(ady)){
                    cola.offer(ady);
                    this.visitados.add(ady);
                }
            }
        }
    }
}
