import java.util.HashSet;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Character> grafito = new GrafoDirigido<>();
        AlgoritmoBuscarCiclo<Character> algoritmo = new AlgoritmoBuscarCiclo<>();
        BreadhtFirstSearch<Character> busquePorCapas = new BreadhtFirstSearch<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice('A');
        grafito.agregarVertice('B');
        grafito.agregarVertice('C');
        grafito.agregarVertice('E');
        grafito.agregarVertice('D');
        grafito.agregarVertice('F');
        grafito.agregarVertice('W');
        grafito.agregarVertice('G');
        grafito.agregarVertice('X');
        grafito.agregarVertice('Y');
        grafito.agregarVertice('H');
        grafito.agregarVertice('Z');
        grafito.agregarVertice('K');
        grafito.agregarVertice('I');
        grafito.agregarVertice('J');

        grafito.agregarArco('A', 'B', null);
        grafito.agregarArco('A', 'C', null);
        grafito.agregarArco('A', 'E', null);
        grafito.agregarArco('A', 'D', null);
        grafito.agregarArco('B', 'F', null);
        grafito.agregarArco('C', 'W', null);
        grafito.agregarArco('C', 'G', null);
        grafito.agregarArco('C', 'X', null);
        grafito.agregarArco('E', 'Y', null);
        grafito.agregarArco('E', 'H', null);
        grafito.agregarArco('E', 'Z', null);
        grafito.agregarArco('D', 'J', null);
        grafito.agregarArco('D', 'I', null);
        grafito.agregarArco('D', 'K', null);

        algoritmo.buscarCiclo(grafito);
        System.out.println(algoritmo.tengoCiclo());

        busquePorCapas.bfs(grafito);
    }
}