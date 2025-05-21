import java.util.HashSet;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
        AlgoritmoBuscarCiclo<Integer> algoritmo = new AlgoritmoBuscarCiclo<>();
        BreadthFirstSearch<Integer> busquePorCapas = new BreadthFirstSearch<>();
        AlgoritmoCaminoSimpleMayorLongitud<Integer> mayoCamino = new AlgoritmoCaminoSimpleMayorLongitud<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(8);
        grafito.agregarVertice(10);
        grafito.agregarVertice(5);
        grafito.agregarVertice(4);
        grafito.agregarVertice(1);
        grafito.agregarVertice(3);
        grafito.agregarVertice(2);


        grafito.agregarArco(8, 10, null);
        grafito.agregarArco(10, 5, null);
        grafito.agregarArco(8, 4, null);
        grafito.agregarArco(4, 1, null);
        grafito.agregarArco(4, 3, null);
        grafito.agregarArco(8, 2, null);
        grafito.agregarArco(2, 4, null);

        mayoCamino.buscarCaminoMayorLongitud(grafito,8,3);
    }
}