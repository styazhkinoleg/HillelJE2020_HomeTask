package lesson_05;

public class Fish extends Pet{
    public Fish() {
    }
    public Fish(int id) {
        super(id, "");
    }
    @Override
    public String saySomething() {
        return "....";
    }
}
