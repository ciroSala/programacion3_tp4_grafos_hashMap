import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Vertice<T>{
    private final T key;
    private Set<Arco<T>> arcos;
    private String color;

    Vertice(T key){
        this.key = key;
        this.arcos = new HashSet<>();
        this.color = "blanco";
    }

    public T getKey() {
        return this.key;
    }

    public Set<Arco<T>> getArcos() {
        return this.arcos;
    }

    public void setArcos(HashSet<Arco<T>> arcos) {
        this.arcos = arcos;
    }

    public void addArco(Arco<T> arco){
        this.arcos.add(arco);
    }

    public void deleteArco(Arco<T> arco) {
        this.arcos.remove(arco);
    }

    public boolean contieneArco(Arco<T> arco){
        return this.arcos.contains(arco);
    }

    public Arco<T> getArco(Arco<T> arco){
        if(this.arcos.contains(arco)){
            for (Arco<T> elem : this.arcos) {
                if(elem.equals(arco)){
                    return elem;
                }
            }
        }
        return null;
    }

    public int cantArcos(){
        return this.arcos.size();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice<?> vertice = (Vertice<?>) o;
        return key == vertice.getKey();
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }
}
