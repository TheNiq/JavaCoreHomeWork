package Home14;

import java.util.Comparator;

public class ComporatorFromJob implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Job data1 = null;
        Job data2 = null;
        if(o1 instanceof Job && o2 instanceof Job){
            data1 = (Job) o1;
            data2 = (Job) o2;
        }
        return Integer.compare(data1.getId(),data2.getId());

    }
}
