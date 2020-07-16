package lesson_06;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat(1,"Murzik", true);
        System.out.println(cat.saySomething());

        Crocodile crocodile = new Crocodile(2);
        System.out.println(crocodile.saySomething());

        Dog dog = new Dog(3, "Polkan", false);
        System.out.println(dog.saySomething());

        Fish fish = new Fish(4);
        System.out.println(fish.saySomething());

        Giraffe giraffe = new Giraffe(5);
        System.out.println(giraffe.saySomething());

        GuideDog guideDog = new GuideDog(6, "Beethoven", true, true);
        System.out.println(guideDog.saySomething());

        Hamster hamster = new Hamster(7, "", false);
        System.out.println(hamster.saySomething());

        Lion lion = new Lion(8);
        System.out.println(lion.saySomething());

        Wolf wolf = new Wolf(9);
        System.out.println(wolf.saySomething());
    }
}
