import java.util.Objects;

public class Arco<T> {
    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = null;
    }

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arco<?> arco = (Arco<?>) o;
        return verticeOrigen == arco.verticeOrigen && verticeDestino == arco.verticeDestino;
    }

    @Override
    public int hashCode() {
        return Objects.hash(verticeOrigen, verticeDestino);
    }
}

