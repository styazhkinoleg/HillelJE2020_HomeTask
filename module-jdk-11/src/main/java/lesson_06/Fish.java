package lesson_06;

public class Fish extends AbsPet implements Animal {
    public Fish(int id) {
        this.setId(id);
    }
    @Override
    public String saySomething() {
        return "....";
    }
}