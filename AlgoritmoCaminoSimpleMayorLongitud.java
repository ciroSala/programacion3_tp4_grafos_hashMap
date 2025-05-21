import java.util.*;

public class AlgoritmoCaminoSimpleMayorLongitud<T> {
    private final Set<T> visitando;
    private LinkedList<T> caminoMasLargo;

    public AlgoritmoCaminoSimpleMayorLongitud(){
        this.caminoMasLargo = new LinkedList<>();
        this.visitando = new HashSet<>();
    }

    public void buscarCaminoMayorLongitud(GrafoDirigido<T> grafo, T origen, T destino){
        LinkedList<T> caminoActual = new LinkedList<>();
        // Agrego el primero al camino y como visitando
        caminoActual.add(origen);
        this.visitando.add(origen);
        this.buscarCaminoMayorLongitud(grafo, origen, destino, caminoActual);
    }

    private void buscarCaminoMayorLongitud(GrafoDirigido<T> grafo, T vertice, T destino, LinkedList<T> caminoActual){
        // 1. Comprobación si se llegó al destino.
        if(vertice.equals(destino)){
            // Si llegue al vertice buscado me fijo si el camino es el mas largo hasta el momento y lo guardo
            if(caminoActual.size()>this.caminoMasLargo.size()){
                this.caminoMasLargo = new LinkedList<>(caminoActual);// Hacer una copia
            }
            // Luego de encontrarlo, borro el el vertice como visitado asi otros vertices
            // pueden llegar a encontrarlo y corto la busqueda
            this.visitando.remove(vertice);
            return;
        }

        // 2. Explorar adyacentes
        //  Desde el vertice voy recorriendo los caminos posibles
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        T value = null;
        while(adyacentes.hasNext()){
            T adyacente = adyacentes.next();
            // ¡Importante: Solo explorar adyacentes que NO han sido visitados en esta RAMA!
            if(!this.visitando.contains(adyacente)){
                // Marcar el ADYACENTE como visitado y agregarlo al camino ANTES de la llamada recursiva
                this.visitando.add(adyacente);
                caminoActual.add(adyacente);
                // Llamada recursiva para el adyacente
                buscarCaminoMayorLongitud(grafo, adyacente, destino, caminoActual);
            }
        }
        // 4. Retroceso: Desmarcar el ADYACENTE y quitarlo del camino AL SALIR de la llamada recursiva
        this.visitando.remove(vertice);
        caminoActual.removeLast();
    }
}
