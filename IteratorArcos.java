import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorArcos<T> implements Iterator<T>{
    private final Iterator<Arco<T>> iteratorArcos;

    public IteratorArcos(Iterator<Arco<T>> arcos){
        this.iteratorArcos = arcos;
    }

    @Override
    public boolean hasNext() {
        return this.iteratorArcos.hasNext();
    }

    @Override
    public T next() {
        return iteratorArcos.next().getVerticeDestino();
    }
}
