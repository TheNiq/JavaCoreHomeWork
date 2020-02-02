package Home14;

public class Job implements Comparable {
    private static int count = 0;
    private String name;
    private int id;

    public Job(String name) {
        this.name = name;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        Job oData = null;
        if(o instanceof Job) {
            oData = (Job) o;
        }
        return Integer.compare(id, oData.getId());

    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
