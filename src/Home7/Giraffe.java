package Home7;

public class Giraffe extends WildAnimal {
    public Giraffe(int age, int weigh, String color, boolean isPredator) {
        super(age, weigh, color, isPredator);
    }

    @Override
    String voice() {
        return super.voice() + "Giraffe";
    }
}
