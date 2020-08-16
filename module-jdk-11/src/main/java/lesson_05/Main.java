package lesson_05;

public class Main {
    public static void main(String[] args) {
        int n = 9;
        Animal [] animals = new Animal[n];
        animals[0] = new Cat(1,"Murzik");
        animals[1] = new Crocodile(2);
        animals[2] = new Dog(3, "Polkan");
        animals[3] = new Fish(4);
        animals[4] = new Giraffe(5);
        animals[5] = new GuideDog(6, "Beethoven", true);
        animals[6] = new Hamster(7, "Foma");
        animals[7] = new Lion(8);
        animals[8] = new Wolf(9);

        for(Animal animal : animals){
            if (animal != null){
                System.out.println(animal.saySomething());
            }
        }
    }
}
