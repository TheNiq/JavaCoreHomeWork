package Home11;
import java.lang.reflect.Array;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        Collection collection = new ArrayList();
        LinkedList linkedList  = new LinkedList();



        collection.add(1230);
        collection.add(12);
        collection.add(45);


        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(3);



        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
//        myLinkedList.add(34);
//        myLinkedList.add(10);
//
//        myLinkedList.add(79);
//        myLinkedList.add(90);
        //myLinkedList.removeAll(collection);
        //linkedList.removeAll(collection);


        System.out.println(myLinkedList.containsAll(linkedList));
        System.out.println("mylinkedlist " + myLinkedList);
        System.out.println("collection " + collection);
        myLinkedList.add(3,56);
        //myLinkedList.add(4,67);
        myLinkedList.add(2,78);
        myLinkedList.add(3,55);
        System.out.println(myLinkedList);
        //System.out.println(myLinkedList.remove(1));
        myLinkedList.listIterator();
        System.out.println(myLinkedList);
        System.out.println(linkedList.listIterator());
    }
}