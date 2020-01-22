package Home10;
import java.util.Iterator;

public class MyIterator implements Iterator {
    private Node nodes;

    public MyIterator(Node nodes) {
        this.nodes = nodes;
    }


    @Override
    public boolean hasNext() {
        return nodes != null;
    }

    @Override
    public Node next() {
        Node data;
        if(hasNext()){
            data = nodes;
            nodes = nodes.getNext();
            return data;

        }else {
            System.out.println("ERROR ");
            return null;
        }


    }
}