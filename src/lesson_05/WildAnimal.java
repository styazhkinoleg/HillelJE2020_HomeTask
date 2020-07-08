package lesson_05;

public class WildAnimal extends Animal{
    private boolean predator;
    public WildAnimal(){
    }
    public WildAnimal(int id, boolean predator){
        this.setId(id);
        this.setPredator(predator);
    }
    public boolean isPredator() {
        return predator;
    }
    public void setPredator(boolean predator) {
        this.predator = predator;
    }
    @Override
    public String toString() {
        return " I am a wild animal" + (this.isPredator() ? " and I am angry." : ".");
    }
}
