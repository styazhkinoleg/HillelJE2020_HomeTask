package lesson_06;

public class Crocodile extends AbsWildAnimal implements Animal {
    public Crocodile(int id) {
        this.setId(id);
        this.setPredator(true);
    }

    @Override
    protected String getDefaultName() {
        return " I am crocodile.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}