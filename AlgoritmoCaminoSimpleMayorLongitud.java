import java.util.*;

public class AlgoritmoCaminoSimpleMayorLongitud<T> {
    private final Set<T> visitando;
    private LinkedList<T> caminoMasLargo;

    public AlgoritmoCaminoSimpleMayorLongitud(){
        this.caminoMasLargo = new LinkedList<>();
        this.visitando = new HashSet<>();
    }

    public void buscarCaminoMayorLongitud(Grafo<T> grafo, T origen, T destino){
        LinkedList<T> caminoActual = new LinkedList<>();
        this.buscarCaminoMayorLongitud(grafo, origen, destino, caminoActual);
    }

    private void buscarCaminoMayorLongitud(Grafo<T> grafo, T vertice, T destino, LinkedList<T> caminoActual){
        caminoActual.add(vertice);
        if(vertice.equals(destino)){ // Si llegue al vertice buscado me fijo si el camino es el mas largo hasta el momento y lo guardo
            if(caminoActual.size()>this.caminoMasLargo.size()){
                this.caminoMasLargo = caminoActual;
            }
        }else{
            // Desde el origen voy recorriendo los caminos posibles
            this.visitando.add(vertice);
            Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
            T value = null;
            while(adyacentes.hasNext()){
                // Por cada adyacente si no fue visitado aplico busqueda recursiva
                // y cada elemento lo agrego al camino
                T adyacente = adyacentes.next();
                if(!this.visitando.contains(adyacente)){
                    buscarCaminoMayorLongitud(grafo, adyacente, destino, caminoActual);
                }
            }
            this.visitando.remove(vertice);
        }
    }
}
