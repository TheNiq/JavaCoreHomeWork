package Home7;
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog(2,6,"Black","BOB",true);
        GuideDog guideDog = new  GuideDog(3,10,"Black","Bobic",true,false);
        Fish fish = new Fish(1,2,"blue","Nemo");
        Cat cat = new Cat(2,6,"White","Bars",true);
        Hamster hamster = new Hamster(1,1,"Black","Hamster",true);
        Wolf wolf = new Wolf(3,4,"Yellow",false);
        Lion lion =new Lion(7,10,"Yellow",true);
        Giraffe giraffe = new Giraffe(2,100,"Yello-Black",false);
        Crocodile crocodile = new Crocodile(3,70,"Green",true);
        Animals[] animals = new Animals[9];
        animals[0] = dog;
        animals[1] = guideDog;
        animals[2] = fish;
        animals[3] = cat;
        animals[4] = hamster;
        animals[5] = wolf;
        animals[6] = lion;
        animals[7] = giraffe;
        animals[8] = crocodile;
        for (Animals animal:animals){
            System.out.println(animal.voice());
        }

        
        System.out.println(dog.voice());
        System.out.println(cat.voice());
        System.out.println(fish.voice());
        System.out.println(guideDog.voice());
        System.out.println(wolf.voice());


    }
}
