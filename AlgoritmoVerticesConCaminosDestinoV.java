import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AlgoritmoVerticesConCaminosDestinoV<T> {
    private ArrayList<T> vertices;
    private Set<T> visitados;
    private boolean tengoCamino;

    public AlgoritmoVerticesConCaminosDestinoV(){
        this.vertices = new ArrayList<T>();
        this.tengoCamino = false;
    }

    public ArrayList<T> obtenerVerticesConCaminosDestinoV(Grafo<T> g, T verticeDestino){
        Iterator<T> verticesIterator = g.obtenerVertices();
        T vertice = null;

        // Recorro todos los vertices
        while(verticesIterator.hasNext()){
            vertice = verticesIterator.next();

            // Si el verticeOrigen es el verticeDestino, siempre hay un camino (el camino vacío).
            // Depende de la definición de "camino". Si un camino debe tener al menos una arista,
            // entonces este caso se manejaría dentro de tieneCaminoDestinoV.
            // Para simplicidad, si el origen es el destino, se considera que hay un camino.
            if (vertice.equals(verticeDestino)) {
                this.vertices.add(vertice);
                continue; // Ya lo agregamos, pasamos al siguiente
            }

            // Para cada vertice de origen, se inicia una NUEVA búsqueda DFS.
            // Esto significa que 'visitados' debe ser nuevo y limpio para cada origen.
            HashSet<T> visitados = new HashSet<>();


            // Iniciamos la búsqueda desde vertice.
            // Es crucial que el vertice se marque como visitado ANTES de la primera llamada.
            this.visitados.add(vertice);

            if(this.tieneCaminoDestinoV(vertice, verticeDestino, g, visitados)){
                this.vertices.add(vertice);
            }

            // No necesitamos limpiar 'visitadosPorBusquedaActual' explícitamente aquí
            // porque se crea una nueva instancia en la siguiente iteración.
        }
        return this.vertices;
    }

    /*
     * Realiza una búsqueda DFS para determinar si existe un camino desde 'verticeActual'
     * hasta 'verticeDestino' sin repetir vértices.
     * @param verticeActual El vértice desde el que se está explorando actualmente.
     * @param verticeDestino El vértice al que se busca llegar.
     * @param g El grafo.
     * @param visitados La lista de vértices visitados en la **rama actual** de la recursión.
     * @return true si se encontró un camino, false en caso contrario.
     */
    private boolean tieneCaminoDestinoV(T vertice, T verticeDestino, Grafo<T> g, HashSet<T> visitados){
        // Caso Base/Caso corte cuando se llegue al verticeDestino sin arcos repetidos ya se que tengo camino
        if(vertice.equals(verticeDestino)){
            return true;
        }

        // Obtengo del vertice sus adyacentes
        Iterator<T> adyacentes = g.obtenerAdyacentes(vertice);
        T ady = null;
        while(adyacentes.hasNext()){
            ady = adyacentes.next();
            // Si es un vertice no visitado busco recursivamente
            if(!this.visitados.contains(ady)){
                this.visitados.add(ady);
                if(this.tieneCaminoDestinoV(ady, verticeDestino, g, visitados)){
                    // Si se encontró un camino, no necesitamos seguir explorando otras ramas
                    // desde este verticeActual. Simplemente retrocedemos indicando éxito.
                    this.visitados.remove(ady); // Backtracking: eliminar el adyacente
                    return true; // Propagamos el éxito hacia arriba
                }
                // Retroceso (Backtracking): Si la llamada recursiva no encontró un camino
                // desde 'ady', o si se exploraron todas sus sub-ramas y no se encontró,
                // eliminamos 'ady' de 'visitados' para permitir que otras ramas lo usen.
                this.visitados.remove(ady);
            }
        }
        // Si se exploraron todos los adyacentes y ninguno llevó al destino,
        // no hay camino desde verticeActual a verticeDestino en esta rama.
        return false;
    }

}
