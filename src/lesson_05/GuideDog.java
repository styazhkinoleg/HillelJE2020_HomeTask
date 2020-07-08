package lesson_05;

public class GuideDog extends Dog{
    private boolean trained;
    public GuideDog() {
    }
    public GuideDog(int id, String name, boolean trained) {
        super(id, name);
        this.setTrained(trained);
    }
    public boolean isTrained() {
        return trained;
    }
    public void setTrained(boolean trained) {
        this.trained = trained;
    }
    @Override
    public String toString() {
        return super.toString() + (this.isTrained() ? " I can take you home." : "");
    }
}
