package Home7;

public class HomeAnimal extends Animals {
    String name;
    boolean isVaccinated;

    public HomeAnimal(int age, int weigh, String color, String name, boolean isVaccinated) {
        super(age, weigh, color);
        this.name = name;
        this.isVaccinated = isVaccinated;
    }

    public HomeAnimal(int age, int weigh, String color, boolean isVaccinated) {
        super(age, weigh, color);
        this.isVaccinated = isVaccinated;
    }

    public HomeAnimal(int age, int weigh, String color, String name) {
        super(age, weigh, color);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public HomeAnimal(int age, int weigh, String color) {
        super(age, weigh, color);
    }

    @Override
    String voice() {
        if(this.name != null){
            return "Hello my name " + name + " ";
        }
        else {
            return "Hello";
        }

    }

    @Override
    public String toString() {
        return "HomeAnimal{" +
                "name='" + name + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", age=" + age +
                ", weigh=" + weigh +
                ", color='" + color + '\'' +
                '}';
    }
}
