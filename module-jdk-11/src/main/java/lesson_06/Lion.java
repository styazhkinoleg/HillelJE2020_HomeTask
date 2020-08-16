package lesson_06;

public class Lion extends AbsWildAnimal implements Animal {
    public Lion(int id) {
        this.setId(id);
        this.setPredator(true);
    }
    @Override
    protected String getDefaultName() {
        return " I am lion.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}