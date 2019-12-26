package Home7;
public abstract class Animals {
    int age ;
    int weigh;
    String color;

    public Animals(int age, int weigh, String color) {
        this.age = age;
        this.weigh = weigh;
        this.color = color;
    }

    abstract String voice();
}
