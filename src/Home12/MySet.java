package Home12;
import javax.print.attribute.standard.NumberUp;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set {
    private int size;
    private Node root = null;
    private Node current;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new SetIterator(root);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Integer oData = null;
        if(o instanceof Integer){
            oData = (Integer) o;
        }
        Node node = new Node(oData,null,null,null);
        if(root == null){
            root = node;
            current = root;
            size++;
            return true;
        }
        else {
            current = root;
            while (current != null){
                if(oData > current.getData()){
                    if(current.getRight() != null){
                        current = current.getRight();

                    }else {
                        break;
                    }
                }
                else if(oData < current.getData()){
                    if(current.getLeft() != null){
                        current = current.getLeft();
                    }
                    else {
                        break;
                    }

                }
                else if(oData.equals(current.getData())){
                    return false;
                }


            }

            if( oData > current.getData()){
                current.setRight(node);
                node.setParent(current);
                size++;
            }
            else if(oData < current.getData()){
                current.setLeft(node);
                node.setParent(current);
                size++;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public String toString() {
        return toString(root);
    }
    public String toString(Node root){
        String result = "";
        if(root == null){
            return result;
        }
        else {
            result += root.getData();
            if(root.getRight() != null || root.getLeft() != null){
                result = "(" + result + ", " + toString(root.getLeft());
                result +=  ", " + toString(root.getRight() ) + ")";
            }
        }
        return result;

    }
}
