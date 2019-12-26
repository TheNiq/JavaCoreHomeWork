package Home7;

public class GuideDog extends Dog {
    private boolean isTrained;


    public GuideDog(int age, int weigh, String color, String name, boolean isVaccinated, boolean isTrained) {
        super(age, weigh, color, name, isVaccinated);
        this.isTrained = isTrained;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public String goToHome(){
        if(isTrained){
            return "\n go to home";
        }else {
            return null;
        }
    }
    @Override
    String voice() {
        return super.voice();
    }
}
