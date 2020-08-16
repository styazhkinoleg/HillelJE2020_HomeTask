package lesson_06;

public class AbsWildAnimal extends AbsAnimal{
    private boolean predator;

    public void setPredator(boolean predator) {
        this.predator = predator;
    }
    public boolean isPredator() {
        return this.predator;
    }

    @Override
    public String toString() {
        return this.getDefaultName() + " I am a wild animal" + (this.isPredator() ? " and I am angry." : ".");
    }
}
