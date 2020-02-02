package Home14;


import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Comparator myComparator = new MyComparator();
        Comparator comparator = new ComporatorFromJob();
        Job job = new Job("dev");
        Job job2 = new Job("doctor");
        Job job3 = new Job("dentist");
        Job job4 = new Job("Senior dev");
        Job job5 = new Job("Middle  dev");



        MySet2 mySet = new MySet2();
//        mySet.add(32);
//        mySet.add(1);
//        mySet.add(45);
//        mySet.add(12);
//        mySet.add(17);
//        mySet.add(132);
//        mySet.add("string5");
//        mySet.add("string3");
//        mySet.add("string2");
//        mySet.add("string1");
//        mySet.add("string7");
//        mySet.add("string5");
        mySet.add(job3);
        mySet.add(job);
        mySet.add(job4);
        mySet.add(job2);


        System.out.println(mySet);
        for(Object o: mySet){
            System.out.println(o);
        }
        System.out.println(mySet.contains(job4));

    }
}
