package Home10;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList implements Collection {
    private int size;
    private Node first;
    private Node last;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Node x = first;x != null;x =x.getNext()){
            if(x.getData() == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
       return new MyIterator(first);
    }

    @Override
    public Object[] toArray() {
        Object [] objects = new Object[size];
        int count = 0;
        for(Node x = first;x != null ;x= x.getNext()){
            objects[count] = x.getData();
            count++;
        }

        return objects;
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o,null,null);
        if (size == 0) {
            first = node;
            size++;
            return true;
        }
        else if(size == 1) {
            Node current = node;
            first.setNext(current);
            current.setPrev(first);
            last = current;
            size++;
        }
        else if(size > 1){
            Node current = first;
            while (current.getNext() != null){
                current = current.getNext();
            }
            last = node;
            current.setNext(last);
            last.setPrev(current);
            size++;

        }

        return false;

    }

    @Override
    public boolean remove(Object o) {
      if(o == null){
          for(Node x = first; x != null; x = x.getNext()){
              if(x.getData() == null){
                unlink(x);
                return true;
              }
          }
      }else {
          for(Node x = first;x != null; x = x.getNext()){
              if(o.equals(x.getData())){
                  unlink(x);
                  return true;
              }
          }
      }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for(Object o: c){
            add(o);
            size++;
        }
        return true;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean retainAll(Collection c) {
        for(Node x = first;x != null;x = x.getNext()){
            if(!c.contains(x.getData())){
                Node next = x.getNext();
                remove(x.getData());
                x = next;
            }

        }
        if(!c.contains(last)){
            remove(last.getData());
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for(Object o : c){
            for(Node x = first;x != null;x = x.getNext()){
                if(o.equals(x.getData())){
                    remove(x.getData());

                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Node x = first;x != null;x = x.getNext()){
            if(!c.contains(x.getData())){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) { // ????????????????
        Object [] objects = new Object[size];
        int count = 0;
        for(Node x = first;x != null ;x= x.getNext()){
            objects[count] = x.getData();
            count++;
        }

        return objects;
    }

    @Override
    public String toString() {
        String result = "[";
        for(Node x = first; x != null;x = x.getNext()){
            result += x.getData() + ", ";
        }
        return result +  "]";
    }
    Object unlink (Node x ){
        Object data = x.getData();
        Node next = x.getNext();
        Node prev = x.getPrev();
        if (prev == null){
            first = next;
        }else {
            prev.setNext(next);
            x.setPrev(null);
        }

        if(next == null){
            last = prev;
        }else {
            next.setPrev(prev);
            x.setNext(null);
        }

        x.setData(null);
        size--;
        return data;
    }

    public Node getFirst(){
        return first;
    }
    public Node getLast(){
        return last;
    }

}
