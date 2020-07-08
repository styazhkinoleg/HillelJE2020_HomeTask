package lesson_05;

public class Cat extends Pet{
    public Cat() {
    }
    public Cat(int id, String name) {
        super(id, name);
    }
    private String voice(){
        return "Meow!";
    }
    @Override
    public String toString() {
        return super.toString() + " " + this.voice();
    }
}
