import java.util.Objects;

public class Nodo<T>{
    T value;
    Nodo<T> next;
    Nodo<T> previous;

    public Nodo(T valor){
        this.value = valor;
        this.next = null;
        this.previous = null;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Nodo<T> next){
        this.next = next;
    }

    public void setPrevious(Nodo<T> previous) {
        this.previous = previous;
    }

    public Nodo<T> getPrevious() {
        return previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo<?> nodo = (Nodo<?>) o;
        return Objects.equals(value, nodo.value) && Objects.equals(next, nodo.next) && Objects.equals(previous, nodo.previous);
    }

}
