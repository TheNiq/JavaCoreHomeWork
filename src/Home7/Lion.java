package Home7;

public class Lion extends WildAnimal {
    public Lion(int age, int weigh, String color, boolean isPredator) {
        super(age, weigh, color, isPredator);
    }

    @Override
    String voice() {
        return super.voice() + " LION";
    }
}
