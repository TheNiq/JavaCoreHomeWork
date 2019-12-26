package Home7;

public class Crocodile extends WildAnimal {
    public Crocodile(int age, int weigh, String color, boolean isPredator) {
        super(age, weigh, color, isPredator);
    }

    @Override
    String voice() {
        return super.voice() + " Crocodile";
    }
}
