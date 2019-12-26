package Home7;

public class Wolf extends WildAnimal {
    public Wolf(int age, int weigh, String color, boolean isPredator) {
        super(age, weigh, color, isPredator);
    }

    @Override
    String voice() {
        return super.voice() + "Wolf";
    }
}
