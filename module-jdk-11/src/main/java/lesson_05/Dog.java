package lesson_05;

public class Dog extends Pet{
    public Dog() {
    }
    public Dog(int id, String name) {
        super(id, name);
    }
    private String voice(){
        return "Woof!";
    }
    @Override
    public String toString() {
        return super.toString() + " " + this.voice();
    }
}
