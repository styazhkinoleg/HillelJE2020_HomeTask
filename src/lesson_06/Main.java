package lesson_06;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat(1,"Murzik", true);
        Crocodile crocodile = new Crocodile(2);
        Dog dog = new Dog(3, "Polkan", false);
        Fish fish = new Fish(4);
        Giraffe giraffe = new Giraffe(5);
        GuideDog guideDog = new GuideDog(6, "Beethoven", true, true);
        Hamster hamster = new Hamster(7, "", false);
        Lion lion = new Lion(8);
        Wolf wolf = new Wolf(9);

        System.out.println(cat.saySomething());
        System.out.println(crocodile.saySomething());
        System.out.println(dog.saySomething());
        System.out.println(fish.saySomething());
        System.out.println(giraffe.saySomething());
        System.out.println(guideDog.saySomething());
        System.out.println(hamster.saySomething());
        System.out.println(lion.saySomething());
        System.out.println(wolf.saySomething());

    }
}
