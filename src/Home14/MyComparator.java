package Home14;

import java.util.Comparator;

public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Integer && o2 instanceof Integer){
            Integer data1 = (Integer) o1;
            Integer data2 = (Integer) o2;
            return Integer.compare(data1,data2);
        }
        return 0;
    }
}
