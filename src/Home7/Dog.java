package Home7;

public class Dog extends HomeAnimal {
    public Dog(int age, int weigh, String color, String name, boolean isVaccinated) {
        super(age, weigh, color, name, isVaccinated);
    }

    public Dog(int age, int weigh, String color, boolean isVaccinated) {
        super(age, weigh, color, isVaccinated);
    }

    public Dog(int age, int weigh, String color) {
        super(age, weigh, color);
    }

    @Override
    String voice() {
        return super.voice() + "WOOF";
    }


}
