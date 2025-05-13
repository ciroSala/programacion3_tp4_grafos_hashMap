
import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    private Map<Integer,Vertice> vertices;

    public GrafoDirigido(){
        this.vertices = new HashMap<>(20);
    }


    @Override
    public void agregarVertice(int verticeId) {
        // TODO Auto-generated method stub
        Vertice vertice = new Vertice(verticeId);
        vertices.put(vertice.getKey(), vertice);
    }

    @Override
    public void borrarVertice(int verticeId) {
        // TODO Auto-generated method stub
        this.vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        // TODO Auto-generated method stub
        Vertice vertice1 = this.vertices.get(verticeId1);
        Vertice vertice2 = this.vertices.get(verticeId2);
        //verificar que existan los dos vertices
        if(vertice1 != null && vertice2 !=null){
            // Crear y agregar arco en vertice 1 (HashSet se encarga de gestionar de no
            // agregar repetidos, gracias al HashCode y equals)
            Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
            vertice1.addArco(arco);
        }else{
            System.out.println("No se puede agregar el arco");
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        // Buscar el vertice de origen
        Vertice vertice1 = this.vertices.get(verticeId1);
        if(vertice1!=null){
            //   Crear un arco con los mismos valores del arco que se quiere eliminar,
            //  borrar el arco igual al nuevo, en el vertice de origen
            Arco arco = new Arco(verticeId1,verticeId2);
            vertice1.deleteArco(arco);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        // TODO Auto-generated method stub
        //verificar si mi hashMap contiene el vertice
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        // Buscar el vertice de origen
        Vertice vertice = this.vertices.get(verticeId1);
        if(vertice!=null){
            Arco arco = new Arco<>(verticeId1,verticeId2);
            vertice.deleteArco(arco);
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        // Buscar el vertice de origen
        Vertice vertice = this.vertices.get(verticeId1);
        if(vertice!=null){
            Arco arco = new Arco<>(verticeId1,verticeId2);
            return vertice.getArco(arco);
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        // TODO Auto-generated method stub
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int resultado = 0;
        // Obtener conjunto de las claves
        Set<Integer> vertices = this.vertices.keySet();
        // Creo un iterador para obtener cada clave
        Iterator iterator = vertices.iterator();
        while(iterator.hasNext()){
            // Agarro cada vertice con la clave y le pido la cantidad de arcos
            resultado += this.vertices.get(iterator.next()).cantArcos();
        }
        return resultado;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // TODO Auto-generated method stub
        Set<Integer> vertices = this.vertices.keySet();
        return vertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        // TODO Auto-generated method stub
        // Vertices adyacentes son los que yo puedo alcanzar
        Vertice vertice = this.vertices.get(verticeId);
        if(vertice!=null){
            // Agarro los arcos del vertice
            Set<Arco> arcos = vertice.getArcos();
            // Creo un iterator para recorrer los arcos
            Iterator<Arco> iterator = arcos.iterator();
            // Creo una lista vinculada para obtener los adyacentes (Los vertices destino de mis arcos)
            LinkedList<Integer> adyacentes = new LinkedList<>();
            while(iterator.hasNext()){
                adyacentes.add(iterator.next().getVerticeDestino());
            }
            return adyacentes.iterator();
        }
        return null;
    }
//
//    @Override
//    public Iterator<Arco<T>> obtenerArcos() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
//        // TODO Auto-generated method stub
//        return null;
//    }

//
//    @Override
//    public String toString() {
//    }
}

