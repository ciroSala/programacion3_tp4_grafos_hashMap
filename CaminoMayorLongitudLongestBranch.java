import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CaminoMayorLongitudLongestBranch<T> {
    private final HashSet<T> visitando;

    public CaminoMayorLongitudLongestBranch(){
        this.visitando = new HashSet<>();
    }

    public ArrayList<T> encontrarCaminoMasLargo(T verticeOrigen, T verticeDestino, GrafoDirigido<T> grafo){
        this.visitando.clear();
        // Busco el camino mas largo desde el origen
        return this.encontrarCaminoMasLargoLB(verticeOrigen, verticeDestino, grafo);
    }

    private ArrayList<T> encontrarCaminoMasLargoLB(T vertice, T destino, GrafoDirigido<T> grafo){
        //  Creo un arrayList para guardar el camino actual
        // Marco como visitado el vertice desde donde estoy buscando el camino mas largo
        ArrayList<T> caminoActual = new ArrayList<>();
        this.visitando.add(vertice);

        //  Caso base, cuando llegue al destino significa que llegue al final del camino, construyo la solucion por donde
        // vine, retorno el camino con el destino como parte del camino
        if(vertice==destino){
            this.visitando.remove(vertice);
            caminoActual.addFirst(vertice);
            return caminoActual;
        }

        // Busco el camino mas largo desde mis adyacentes
        Iterator<T> adyacentes = grafo.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){
            T ady = adyacentes.next();
            // Solo busco el camino desde los adyacentes que no estoy visitando
            if(!this.visitando.contains(ady)){
                ArrayList<T> caminoAdyacente = this.encontrarCaminoMasLargoLB(ady, destino, grafo);
                //  Si un adyacente me devuelve un camino, verifico si es el mas
                //  grande y lo actualizo
                if(caminoAdyacente.size()>caminoActual.size()){
                    caminoActual.clear();
                    caminoActual.addAll(caminoAdyacente);
                }
            }
        }
        //  Si ya busque por todos mi adyacentes me borro como visitando, asi otros caminos
        // pueden pasar por mi vertice
        this.visitando.remove(vertice);

        //  Si algun adyacente me devolvio un camino mayor a 0, significa que soy parte del camino
        // me agrego al arrayList y me retorno
        if(!caminoActual.isEmpty()){
            caminoActual.addFirst(vertice);
        }
        return caminoActual;
    }
}
