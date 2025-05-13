import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(3);
        grafito.agregarVertice(2);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(4, 3, 10);
        grafito.agregarArco(4, 2, 20);
        grafito.agregarArco(1, 4, 30);
        grafito.agregarArco(5, 1, 40);
        grafito.agregarArco(2, 3, 50);
        grafito.agregarArco(2, 5, 60);

        Iterator<Integer> adyacentes = grafito.obtenerAdyacentes(2);
        while (adyacentes.hasNext()){
            System.out.println(adyacentes.next());
        }

        Iterator<Integer> adyacentes2 = grafito.obtenerAdyacentes(4);
        while (adyacentes2.hasNext()){
            System.out.println(adyacentes2.next());
        }

        Iterator<Arco<Integer>> iterator = grafito.obtenerArcos();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getVerticeDestino());
        }
    }
}