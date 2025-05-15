import java.util.Objects;

public class Arco<T> {
    private final int verticeDestino;
    private T etiqueta;

    public Arco(int verticeDestino) {
        this.verticeDestino = verticeDestino;
        this.etiqueta = null;
    }

    public Arco(int verticeDestino, T etiqueta) {
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    public T getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arco<?> arco = (Arco<?>) o;
        return verticeDestino == arco.verticeDestino;
    }

    @Override
    public int hashCode() {
        return this.verticeDestino;
    }
}

