import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(3);
        grafito.agregarVertice(2);
        grafito.agregarVertice(4);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(4, 3, 3F);
        grafito.agregarArco(4, 2, 3F);
        grafito.agregarArco(4, 1, 3F);
        grafito.agregarArco(2, 3, 3F);

        Iterator<Integer> adyacentes = grafito.obtenerAdyacentes(2);
        while (adyacentes.hasNext()){
            System.out.println(adyacentes.next());
        }

        Iterator<Integer> adyacentes2 = grafito.obtenerAdyacentes(4);
        while (adyacentes2.hasNext()){
            System.out.println(adyacentes2.next());
        }

    }
}