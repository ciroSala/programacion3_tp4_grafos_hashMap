
import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    private Map<Integer,Vertice<T>> vertices;

    public GrafoDirigido(){
        this.vertices = new HashMap<>(20);
    }


    @Override
    public void agregarVertice(int verticeId) {
        // TODO Auto-generated method stub
        Vertice<T> vertice = new Vertice(verticeId);
        vertices.put(vertice.getKey(), vertice);
    }

    @Override
    public void borrarVertice(int verticeId) {
        // Borro el vertice de mi map
        this.vertices.remove(verticeId);
        // Busco los vertices que lo tengan como adyacente
        Collection<Vertice<T>> collection = this.vertices.values();
        // En cada vertice borro el arco con el destino del vertice borrado si es que lo tienen
        for(Vertice elem : collection){
            Arco<T> arco = new Arco<>(elem.getKey(),verticeId);
            elem.deleteArco(arco);
        }
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
            Arco<T> arco = new Arco(verticeId1,verticeId2);
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
            return vertice.contieneArco(arco);
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
        // Obtener conjunto de valores (vertices)
        Collection<Vertice<T>> vertices = this.vertices.values();

        // Creo un iterador recorrer los vertices
        Iterator<Vertice<T>> iterator = vertices.iterator();

        // Sumo los arcos de cada vertice
        while(iterator.hasNext()){
            // Agarro cada vertice con la clave y le pido la cantidad de arcos
            resultado += iterator.next().cantArcos();
        }
        return resultado;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // Puedo agarrar el conjunto de keys (VerticesKey/id)
        Set<Integer> vertices = this.vertices.keySet();
        return vertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        // TODO Auto-generated method stub
        // Vertices adyacentes son los que yo puedo alcanzar
        Vertice<T> vertice = this.vertices.get(verticeId);
        if(vertice!=null){
            // Agarro los arcos del vertice
            Set<Arco<T>> arcos = vertice.getArcos();
            // Creo un iterator para recorrer los arcos
            Iterator<Arco<T>> iterator = arcos.iterator();
            // Creo una lista vinculada para obtener los adyacentes (Los vertices destino de mis arcos)
            LinkedList<Integer> adyacentes = new LinkedList<>();
            while(iterator.hasNext()){
                adyacentes.add(iterator.next().getVerticeDestino());
            }
            return adyacentes.iterator();
        }
        return null;
    }

    public Iterator<Arco<T>> obtenerArcos() {
        // Creo una lista vinculada de arcos donde voy a guardar cada arco
        LinkedList<Arco<T>> arcosTotales = new LinkedList<>();
        // Recorro todos mis vertices y le pido los arcos a cada uno
        // Obtener conjunto de valores (vertices)
        Collection<Vertice<T>> vertices = this.vertices.values();
        // Creo un iterador para recorrer los vertices
        Iterator<Vertice<T>> iterator = vertices.iterator();
        // Por cada vertice obtengo sus arcos y los itero arco por arco, cada arco lo agrego a la lista vinculada
        while(iterator.hasNext()){
            // Agarro cada vertice con la clave y le pido la cantidad de arcos
            Set<Arco<T>> arcosVertice = iterator.next().getArcos();
            Iterator<Arco<T>> iterator2 = arcosVertice.iterator();
            while(iterator2.hasNext()){
                arcosTotales.add(iterator2.next());
            }
        }
        return arcosTotales.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        // Agarro el vertice y si existe obtengo sus arcos
        Vertice<T> vertice = this.vertices.get(verticeId);
        if(vertice!=null){
            Set<Arco<T>> arcos = vertice.getArcos();
            Iterator<Arco<T>> iterator = arcos.iterator();
            return iterator;
        }
        return null;
    }

//
//    @Override
//    public String toString() {
//    }
}

