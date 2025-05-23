import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Character> grafito = new GrafoDirigido<>();
        AlgoritmoVerticesConCaminoDestinoV<Character> verticesConCaminoDestinoV = new AlgoritmoVerticesConCaminoDestinoV<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice('B');
        grafito.agregarVertice('A');
        grafito.agregarVertice('C');
        grafito.agregarVertice('D');
        grafito.agregarVertice('E');
        grafito.agregarVertice('F');
        grafito.agregarVertice('G');


        grafito.agregarArco('A', 'E', null);
        grafito.agregarArco('E', 'A', null);
        grafito.agregarArco('E', 'F', null);
        grafito.agregarArco('B', 'A', null);
        grafito.agregarArco('F', 'G', null);
        grafito.agregarArco('F', 'B', null);
        grafito.agregarArco('C', 'B', null);
        grafito.agregarArco('D', 'C', null);

        HashSet<Character> vertices = verticesConCaminoDestinoV.obtenerVerticesConCaminosDestinoV(grafito, 'D');
        System.out.println(vertices);
    }
}