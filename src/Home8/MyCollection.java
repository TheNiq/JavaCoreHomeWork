package Home8;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection implements Collection {
    private Object[] objects = new Object[0];
    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public boolean isEmpty() {
        return objects.length == 0 ;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0;i < objects.length;i++){
            if(objects[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] toArray;
        toArray = objects;
        return toArray;
    }

    @Override
    public boolean add(Object o) {
        Object [] buffer = new Object[objects.length +  1];
        for (int i = 0;i < objects.length;i++){
            buffer[i] = objects[i];
        }
        buffer[objects.length] = o;
        objects = buffer;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Object [] buffer = new Object[objects.length-1];

        int counter = 0;
        if(contains(o)){
            for(int i = 0;i < objects.length;i++){
                if(!objects[i].equals(o)){
                    buffer[counter] = objects[i];
                    counter++;

                }
            }
        }else {
            return false;
        }
        objects = buffer;
        return false;
    }


    @Override
    public boolean addAll(Collection c) {
        for(Object o: c){
            add(o);
        }
        return false;
    }

    @Override
    public void clear() {
        objects = new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        for(int i = 0;i < objects.length;i++){
            if(!c.contains(objects[i])){
                remove(objects[i]);
                i--;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (int i =0;i < objects.length;i++){
            if(c.contains(objects[i])){
                remove(objects[i]);
                i--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        int count = 0;
        for(int i =0;i < objects.length;i++){
            if(c.contains(objects[i])){
                count++;
            }
        }
        if(count == size()){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String   toString() {
        return Arrays.toString(objects);
    }
}
