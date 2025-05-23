import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class Tree<T> {
    private TreeNode<T> root;

    public Tree(){
        this.root = null;
    }

    // Buscar rama hacia el valor
    public ArrayList<T> getBranch(T value){
        ArrayList<T> branch = new ArrayList<>();
        if(this.root!=null){
            TreeNode<T> nodo = new TreeNode(value);
            // Agarro rama desde la raiz
            branch = this.getBranch(nodo, value);
        }
    }

    private ArrayList<T> getBranch(TreeNode<T> nodo, T value){
        ArrayList<T> branch = new ArrayList<>();

        // Busco recursivamente por todos mis hijos hasta que llegue al valor
        if(nodo.getValue().equals(value)){
            branch.add(nodo.getValue());
            return branch;
        }

        Iterator<T> iteratorHijos = nodo.getHijos();
        while(iteratorHijos.hashNext()){
            TreeNode<T> hijo = iteratorHijos.next();
            branch = this.getBranch(hijo);
            if(!branch.isEmpty()){
                return branch;
            }
        }
    }
}
