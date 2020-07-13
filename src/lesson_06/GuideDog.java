package lesson_06;

public class GuideDog extends Dog{

    private boolean trained;

    public GuideDog(int id, String name, boolean vaccinated, boolean trained) {
        super(id, name, vaccinated);
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
