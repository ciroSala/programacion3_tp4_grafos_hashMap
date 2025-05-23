import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AlgoritmoVerticesConCaminoDestinoV<T> {
    private final HashSet<T> vertices;
    private final HashSet<T> visitando;


    public AlgoritmoVerticesConCaminoDestinoV(){
        this.vertices = new HashSet<>();
        this.visitando = new HashSet<>();
    }

    /*
      Devuelve todos los vértices desde los cuales existe al menos un camino hacia verticeDestino.
      @param g El grafo dirigido
      @param verticeDestino El vértice destino al que deben llegar los caminos
      @return Conjunto de vértices con camino hacia verticeDestino
     */
    public HashSet<T> obtenerVerticesConCaminosDestinoV(Grafo<T> g, T verticeDestino){
        this.vertices.clear();
        this.visitando.clear();

        Iterator<T> verticesIterator = g.obtenerVertices();
        // Recorro todos los vertices
        while(verticesIterator.hasNext()){
            T vertice = verticesIterator.next();
            //  Para cada vertice, se busca si hay camino a vertice destino.
            // si me devuelve true el vertice tiene camino, lo agrego a vertices
            if (this.tieneCaminoDestinoV(vertice, verticeDestino, g)) {
                this.vertices.add(vertice);
            }
        }
        return this.vertices;
    }

    private boolean tieneCaminoDestinoV(T vertice, T verticeDestino, Grafo<T> g){
        // El vertice donde estoy buscando lo pongo en estado visitando
        this.visitando.add(vertice);

        // Caso Base, cuando el vertice sea igual al vertice destino
        // sin arcos repetidos, ya se que tengo camino, me borro de
        // estado visitando, asi otros elementos pueden llegar a este y retorno true
        if(vertice.equals(verticeDestino)){
            this.visitando.remove(vertice);
            return true;
        }

        // Obtengo del vertice sus adyacentes para buscar camino hacia verticeDestino
        Iterator<T> adyacentes = g.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){
            T ady = adyacentes.next();
            // Si es un vertice no visitado busco recursivamente
            if(!this.visitando.contains(ady)){
                // Si un vertice ady ya me devuelve true, me elimino de estado visitando y devuelvo true
                if(this.tieneCaminoDestinoV(ady, verticeDestino, g)){
                    // Si se encontró un camino, no necesitamos seguir explorando otras ramas
                    // desde este verticeActual. Simplemente retrocedemos indicando éxito.
                    this.visitando.remove(vertice); // Backtracking: eliminar el adyacente
                    return true; // Propagamos el éxito hacia arriba
                }
            }
        }
        // Si se exploraron todos los adyacentes y ninguno llevó al destino,
        // no hay camino desde verticeActual a verticeDestino en esta rama.
        this.visitando.remove(vertice);
        return false;
    }
}
