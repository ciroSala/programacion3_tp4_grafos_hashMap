public class Cola<T> {
    private Nodo<T> first;
    private Nodo<T> last;

    public Cola(){
        this.first = null;
        this.last = null;
    }

    public void addCola(T valor){
        Nodo<T> nodo = new Nodo<>(valor);
        if(this.first!=null){
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.first = nodo;
        }else{
            this.first = nodo;
            this.last = nodo;
        }
    }

    public T getCola(){
        if(this.last!=null){
            T valueLast = this.last.getValue();
            if(!this.first.equals(this.last)){
                Nodo<T> nodoPrevious = this.last.getPrevious();
                nodoPrevious.setNext(null);
                this.last = nodoPrevious;
            }else{
                this.first = null;
                this.last = null;
            }
            return valueLast;
        }
        return null;
    }

    public boolean isEmpty(){
        return this.first==null;
    }
}
