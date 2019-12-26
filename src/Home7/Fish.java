package Home7;

public class Fish extends HomeAnimal {
    public Fish(int age, int weigh, String color, String name) {
        super(age, weigh, color, name);
    }

    @Override
    String voice() {
        return "........";
    }
}
