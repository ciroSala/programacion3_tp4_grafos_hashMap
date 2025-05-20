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
        // Comprobación si se llegó al destino.
        if(vertice.equals(destino)){
            // Si llegue al vertice buscado me fijo si el camino es el mas largo hasta el momento y lo guardo
            if(caminoActual.size()>this.caminoMasLargo.size()){
                this.caminoMasLargo = new LinkedList<>(caminoActual); // Hacer una copia
            }
            // No se retorna aquí, permitiendo que otras ramas sigan explorando.
        }
        // 2. Explorar adyacentes
        //  Desde el vertice voy recorriendo los caminos posibles
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        T value = null;
        while(adyacentes.hasNext()){
            T adyacente = adyacentes.next();
            // 3. Importante: Solo explorar adyacentes que NO han sido visitados en esta RAMA
            if(!this.visitando.contains(adyacente)){
                // Marcar el ADYACENTE como visitado y agregarlo al camino ANTES de la llamada recursiva
                this.visitando.add(adyacente);
                caminoActual.add(adyacente);

                // Llamada recursiva para el adyacente
                buscarCaminoMayorLongitud(grafo, adyacente, destino, caminoActual);
            }

            // 4. Retroceso: Desmarcar el ADYACENTE y quitarlo del camino AL SALIR de la llamada recursiva
            this.visitando.remove(vertice);
            caminoActual.removeLast();
        }
    }
}
