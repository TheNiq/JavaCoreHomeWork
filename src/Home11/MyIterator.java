package Home11;
import com.sun.tools.javac.util.List;

import java.util.Iterator;
import java.util.ListIterator;

public class MyIterator implements  ListIterator {
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

    @Override
    public boolean hasPrevious() {
        if(nodes.getPrev() != null){
            return true;
        }
        return false;
    }

    @Override
    public Object previous() {
        if(nodes.getPrev() != null){
            return nodes.getPrev();
        }
        return null;
    }

    @Override
    public int nextIndex() {
        int count = 0;
        for(Node node = nodes; node != null; node = node.getPrev()){
            if(node.getPrev() == null){
                count++;
                return count;
            }
            count++;

        }
        return size();
    }

    @Override
    public int previousIndex() {
        int count = 0;
        for(Node node = nodes; node != null; node = node.getPrev()){
            if(node.getPrev() == null){
                count--;
                return count;
            }
            count++;

        }
        return size();
    }

    @Override
    public void remove() {
        System.out.println("there's nothing here");
    }

    @Override
    public void set(Object o) {
        nodes.setData(o);
    }

    @Override
    public void add(Object o) {

    }
    public int size(){
        int size = 0;
        Node buff = null;
        for(Node x = nodes; x != null; x = x.getPrev()){
            if(x.getPrev() == null) {
                buff = x;
            }
        }
        for(Node x = buff;x != null;x = x.getNext()){
            size++;
        }
        return size;



    }


}