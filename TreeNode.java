import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

public class TreeNode<T>{
    private T value;
    private LinkedList<TreeNode<T>> hijos;


    public TreeNode(T value){
        this.value = value;
        this.hijos = new LinkedList<>();
    }

    public Iterator<TreeNode<T>> getHijos(){
        return this.hijos.iterator();
    }

    public void addTreeNode(TreeNode<T> nodo){
        this.hijos.add(nodo);
    }

    public void removeTreeNode(TreeNode<T> nodo){
        this.hijos.remove(nodo);
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isLeaf() {
        return this.hijos.isEmpty();
    }
}
