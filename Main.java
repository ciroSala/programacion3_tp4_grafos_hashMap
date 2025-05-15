import java.util.HashSet;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoNoDirigido<String> grafito = new GrafoNoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(20);
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(5);
        grafito.agregarVertice(4);
        grafito.agregarVertice(8);
        grafito.agregarVertice(34);
        grafito.agregarVertice(7);

        grafito.agregarVertice(15); // Vertice separado

        grafito.agregarArco(8, 4, null);
        grafito.agregarArco(8, 20, null);
        grafito.agregarArco(20, 2, null);
        grafito.agregarArco(4, 5, null);
        grafito.agregarArco(4, 2, null);
        grafito.agregarArco(2, 1, null);
        grafito.agregarArco(5, 1, null);
        grafito.agregarArco(20, 34, null);
        grafito.agregarArco(34, 7, null);


        Iterator<Arco<String>> iterator = grafito.obtenerArcos();
        while(iterator.hasNext()){
            Arco<String> arco = iterator.next();
            System.out.println(arco.getVerticeDestino());
        }

        System.out.println(grafito.cantidadArcos());
        System.out.print("\n");

        DeepFirstSearch<String> busquedaIntensiva = new DeepFirstSearch<>();
        busquedaIntensiva.deepFirstSearch(grafito);
        HashSet<Integer> visitados = (HashSet<Integer>) busquedaIntensiva.getVisitados();
        for(Integer visitado : visitados){
            System.out.println(visitado);
        }
    }
}