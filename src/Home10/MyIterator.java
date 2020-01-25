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
    public Object next() {
        Object current;
        if(hasNext()){
            current = nodes.getData();
            nodes = nodes.getNext();
            return current;

        }else {
            System.out.println("ERROR ");
            return null;
        }


    }
}