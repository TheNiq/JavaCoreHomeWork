package Home11;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements List {
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
        MyIterator myIterator = new MyIterator(first);
        return myIterator;
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
    public boolean addAll(int index, Collection c) {
        if(index <= size){
            for(Object element : c ){
                add(index,element);
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public Object get(int index) {
        if(index <= size){
            int count = 0;
            for(Node x = first; x != null ; x = x.getNext()){
                if(count == index){
                    return x.getData();
                }
                count++;
            }
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        Object oldVal = null;
        if(index <= size){
            int count =0;
            for(Node x = first;x != null; x = x.getNext()){
                if(count == index){
                    oldVal = x.getData();
                    remove(index);
                    add(index,element);
                }
                count++;
            }
        }
        return oldVal;

    }

    @Override
    public void add(int index, Object element) {
        Node node = new Node(element,null,null);
        int count = 0;
        if(index  <= size){
            if(index == 0){
                node.setNext(first);
                first.setPrev(node);
                first = node;
                size++;
            }

            else if(index == size){
                node.setPrev(last);
                last.setNext(node);
                last = node;
                size++;
            }
            else if(index < size && index > 0){
                for(Node x = first;x != null; x = x.getNext()){
                    if(count ==  index){
                        Node prev;
                        prev = x.getPrev();
                        prev.setNext(node);
                        node.setPrev(prev);
                        node.setNext(x);
                        x.setPrev(node);
                        size++;
                        return;
                    }
                    count++;
                }

            }

        }
    }

    @Override
    public Object remove(int index) {
        Object removeItem = null;
        if(index <= size){
            int count =0;
            for(Node x = first;x != null ;x = x.getNext()){
                if(count == index){
                    removeItem = x.getData();
                    remove(x.getData());
                }
                count++;

            }
        }
        return removeItem;
    }

    @Override
    public int indexOf(Object o) {
        int count = 0;
        for(Node x = first; x != null;x = x.getNext()){
            if(o.equals(x.getData())){
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int count = 0;
        for(Node x = first; x != null;x = x.getNext()){
            if(o.equals(x.getData())){
                lastIndex= count;
            }
            count++;
        }
        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        //Я не понял что должен делать этот метод
        return new MyIterator(first);
    }

    @Override
    public ListIterator listIterator(int index) {
        //Я не понял что должен делать этот метод
        int count =0;
        for(Node x = first;x != null;x = x.getNext()){
            if(count == index){
                return new MyIterator(x);
            }
        }
        return new MyIterator(first);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if(fromIndex <= size && toIndex <= size){
            List sublist = new MyLinkedList();
            int count = 0;
            for(Node x = first ; x != null ; x = x.getNext()){
                if(count <= toIndex && count >= fromIndex){
                    sublist.add(x.getData());
                }
                count++;
            }
            return sublist;

        }else {
            return null;
        }

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
    public Object[] toArray(Object[] a) {
        return new Object[0];
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

    @Override
    public String toString() {
        String result = "[";
        for(Node x = first; x != null;x = x.getNext()){
            result += x.getData() + ", ";
        }
        return result +  "]";
    }
    public Object getLast(){
        return last;
    }
    public Object getFirst(){
        return first;
    }
}
