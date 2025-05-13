import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Vertice{
    private int key;
    private Set<Arco> arcos;

    Vertice(int key){
        this.key = key;
        this.arcos = new HashSet<>();
    }

    public int getKey() {
        return this.key;
    }

    public void setValue(int value) {
        this.key = value;
    }

    public Set<Arco> getArcos() {
        return this.arcos;
    }

    public void setArcos(HashSet<Arco> arcos) {
        this.arcos = arcos;
    }

    public void addArco(Arco arco){
        this.arcos.add(arco);
    }

    public void deleteArco(Arco arco) {
        this.arcos.remove(arco);
    }

    public boolean contieneArco(Arco arco){
        return this.arcos.contains(arco);
    }

    public Arco getArco(Arco arco){
        Arco arcoEncontrado = null;
        if(this.arcos.contains(arco)){
            for (Arco elem : this.arcos) {
                if(elem.equals(arco)){
                    arcoEncontrado = elem;
                }
            }
        }
        return arcoEncontrado;
    }

    public int cantArcos(){
        return this.arcos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return key == vertice.key;
    }

    @Override
    public int hashCode() {
        return this.key;
    }
}
