package lesson_06;

public class Giraffe extends AbsWildAnimal implements Animal {
    public Giraffe(int id) {
        this.setId(id);
        this.setPredator(false);
    }
    @Override
    protected String getDefaultName() {
        return " I am giraffe.";
    }
    @Override
    public String toString() {
        return super.toString();
    }
}