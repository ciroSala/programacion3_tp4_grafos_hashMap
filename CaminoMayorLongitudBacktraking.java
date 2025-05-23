import java.util.*;

public class CaminoMayorLongitudBacktraking<T> {
    private final Set<T> visitando;
    private LinkedList<T> caminoMasLargo;

    public CaminoMayorLongitudBacktraking(){
        this.caminoMasLargo = new LinkedList<>();
        this.visitando = new HashSet<>();
    }

    public LinkedList<T> encontrarCaminoMasLargo(GrafoDirigido<T> grafo, T origen, T destino){
        this.caminoMasLargo.clear();
        LinkedList<T> caminoActual = new LinkedList<>();

        // Agrego el primero al camino y como estado visitando
        caminoActual.add(origen);
        this.visitando.add(origen);

        this.encontrarCaminoMasLargo(grafo, origen, destino, caminoActual);
        return new LinkedList<>(this.caminoMasLargo);
    }

    private void encontrarCaminoMasLargo(GrafoDirigido<T> grafo, T vertice, T destino, LinkedList<T> caminoActual){
        // 1. Comprobación si se llegó al destino.
        if(vertice.equals(destino)){
            //  Si llegue al vertice buscado (Soy una solución)
            // me comparo con la mejor solución hasta el momento
            if(caminoActual.size()>this.caminoMasLargo.size()){
                this.caminoMasLargo = new LinkedList<>(caminoActual);// Hacer una copia
            }
            return;
        }
        // 2. Explorar adyacentes
        //  Desde el vertice voy recorriendo los caminos posibles
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){
            T adyacente = adyacentes.next();
            // ¡Importante: Solo explorar adyacentes que NO han sido visitados en esta RAMA!
            if(!this.visitando.contains(adyacente)){
                // AVANZO, Marco el ADYACENTE como visitado y lo agrego al camino para luego
                // hacer la llamada recursiva
                this.visitando.add(adyacente);
                caminoActual.add(adyacente);
                encontrarCaminoMasLargo(grafo, adyacente, destino, caminoActual);
                // 4. Retroceso: Desmarcar el ADYACENTE y quitarlo del camino
                // AL SALIR de la llamada recursiva para buscar en todos los caminos posibles
                this.visitando.remove(adyacente);
                caminoActual.removeLast();
            }
        }
    }
}
