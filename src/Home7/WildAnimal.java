package Home7;
public class WildAnimal extends Animals{
    private boolean isPredator;

    public WildAnimal(int age, int weigh, String color, boolean isPredator) {
        super(age, weigh, color);
        this.isPredator = isPredator;
    }

    public WildAnimal(int age, int weigh, String color) {
        super(age, weigh, color);
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    String voice() {
        if(isPredator){
            return "Hello I am a wild animal and i'm angry";
        }else {
            return "Hello I am a wild animal";
        }

    }
}
