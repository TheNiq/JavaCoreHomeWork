package Home12;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set mySet = new MySet();
        mySet.add(10);
        mySet.add(35);
        mySet.add(20);
        mySet.add(99);
        mySet.add(17);
        mySet.add(31);
        mySet.add(5);
        mySet.add(1);
        mySet.add(4);
        System.out.println(mySet);
        for(Object o: mySet){
            System.out.println(o);
        }

    }
}
