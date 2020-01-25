package Home10;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        Collection collection = new ArrayList();
        LinkedList linkedList  = new LinkedList();
        collection.add(10);
        collection.add(11);

        collection.add(78);
        collection.add(3);
        collection.add(10);


        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(34);
        linkedList.add(10);

        linkedList.add(79);
        linkedList.add(90);




        myLinkedList.add(10);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(34);
        myLinkedList.add(10);

        myLinkedList.add(79);
        myLinkedList.add(90);
        myLinkedList.removeAll(collection);
        linkedList.removeAll(collection);
        System.out.println(Arrays.toString(linkedList.toArray()));

        System.out.println(myLinkedList.containsAll(linkedList));
        System.out.println("mylinkedlist " + myLinkedList);
        System.out.println(Arrays.toString(myLinkedList.toArray()));
        System.out.println(myLinkedList.getLast());
        System.out.println("linkedlist " + linkedList);
        for(Object o:myLinkedList){
            System.out.println(o);
        }

    }
}

