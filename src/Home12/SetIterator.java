package Home12;
import java.util.Iterator;

public class SetIterator implements Iterator {
    private Node node;

    public SetIterator(Node root) {
        node = root;
        if(node == null){
            return;
        }
        while (node.getLeft() != null){
            node = node.getLeft();
        }


    }


    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public Object next() {
        if(!hasNext()){
            System.out.println("Error");
        }
        Node r = node;
        if(node.getRight() != null){
            node = node.getRight();
            while (node.getLeft() != null){
                node = node.getLeft();
            }
            return r;
        }
        while (true){
            if(node.getParent() == null){
                node = null;
                return r;
            }
            if(node.getParent().getLeft() == node){
                node = node.getParent();
                return r;
            }
            node = node.getParent();
        }
    }
}
