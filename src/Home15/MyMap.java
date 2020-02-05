package Home15;
import java.util.*;

public class MyMap {

    private Entry [] table = new Entry[capacity];
    private static int capacity = 16;
    private int size = 0;
    private float loadFactor = 0.75f;
    private float  threshold = table.length * loadFactor;;

    public int length(){
        return table.length;
    }


    public void put(Object key, Object value){

        //collision test
        //int hash = 104125;
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        if(table[index] != null ){
            if(table[index].hash == hash && table[index].key == key || key.equals(table[index].key)){
                size--;

            }
            else {
                addIfHasCollision(hash,value,index,key);
                size++;
                return;
            }

        }

        addEntry(hash,value,index,key);
        if(size >= threshold){
            resize();
        }

    }
    private void resize(){
        int newCapacity = capacity * 2;
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        threshold =  newCapacity * loadFactor;
        System.out.println();
    }
    private void transfer(Entry[] newTable){
        size = 0;
        Entry[] oldTable = table;
        table = newTable;
        for(int i =0;i < oldTable.length;i++){
            Entry x =  oldTable[i];
            if( x != null){
                Object key = x.key;
                Object value = x.value;
                int hash = x.hash;
                int index = indexFor(hash, newTable.length);
                addEntry(hash,value,index,key);
                if(x.next != null){
                    while (x.next != null){
                        x = x.next;
                        Object key2 = x.key;
                        Object value2 = x.value;
                        int hash2 = x.hash;
                        int index2 = indexFor(hash2, newTable.length);
                        if(table[index2] != null){
                            addIfHasCollision(hash2,value2,index2,key2);
                        }else {
                            addEntry(hash2,value2,index2,key2);
                        }
                    }

                }
            }

        }
    }
    public void addEntry(int hash, Object value, int index,Object key){
        Entry entry = new Entry(hash,key,value,null);
        table[index] = entry;
        size++;
    }
    public void addIfHasCollision(int hash, Object value, int index,Object key){
        table[index].next = new Entry(hash,key,value,null);


    }
    public Object get(Object key){
        // Сollision test
        //int index = 13;
        int index = indexFor(hash(key.hashCode()), table.length);
        if(table[index].next != null){
            Entry current = table[index];
            while (current != null){
                if(current.key.equals(key)){
                    return current.value;
                }
                current = current.next;
            }
        }
        return table[index].value;

    }
    static int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    static int indexFor(int h, int length){
        return h & (length-1);

    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String result = "MyMAP [ ";
        for(int i = 0;i < table.length;i++){
            if(table[i] != null){
                result += table[i].value + ",  ";
                if(table[i].next != null){
                    result += table[i].next.value+ ",  ";
                }
            }
        }
        return result + " ] ";

    }

    public static class Entry {
        int hash ;
        Object key;
        Object value;
        Entry next;

        public Entry(int hash,Object key, Object value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return hash == entry.hash &&
                    Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value) &&
                    Objects.equals(next, entry.next);
        }

        @Override
        public String toString() {
            return "Entry{"+ value + '}';
        }
    }


}
