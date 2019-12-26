package Home7;

public class Hamster extends HomeAnimal {
    public Hamster(int age, int weigh, String color, String name, boolean isVaccinated) {
        super(age, weigh, color, name, isVaccinated);
    }

    public Hamster(int age, int weigh, String color, boolean isVaccinated) {
        super(age, weigh, color, isVaccinated);
    }


    @Override
    String voice() {
        return super.voice() + "I am Hamster";
    }
}
