package Home7;

public class Cat extends HomeAnimal{

    public Cat(int age, int weigh, String color, String name, boolean isVaccinated) {
        super(age, weigh, color, name, isVaccinated);
    }

    public Cat(int age, int weigh, String color, boolean isVaccinated) {
        super(age, weigh, color, isVaccinated);
    }

    @Override
    String voice() {
        return super.voice() + " Meow";
    }
}
