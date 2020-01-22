package Home8;


import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        //Collection collection = new ArrayList();
        Collection collection1 = new ArrayList();
        collection1.add(3);
        collection1.add(5);
        collection1.add(7);
        collection1.add(28);
        collection1.add(34);
        collection1.add(2);
        collection1.add(3);
        collection1.add(4);
        collection.add(5);
        collection.add(6);
        collection.add(7);
        collection.add(8);
//        System.out.println(collection.size());
//        System.out.println(collection.isEmpty());
//        System.out.println(collection);
       // collection.remove(2);
        //collection.remove(4);
        collection.remove(8);
        System.out.println("collection   " + collection);
        System.out.println("collection 1 "+ collection1);
        collection.retainAll(collection1);
        //collection.removeAll(collection1);

        System.out.println(collection);


    }
}
