package lesson_06;

//public class Wolf implements WildAnimal{
//    private int id;
//    private int age;
//    private double weight;
//    private String color;
//    private boolean predator;
//
//    public Wolf(int id) {
//        this.setId(id);
//        this.setPredator(true);
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    @Override
//    public boolean isPredator() {
//        return this.predator;
//    }
//
//    @Override
//    public void setPredator(boolean predator) {
//        this.predator = predator;
//    }
//
//    @Override
//    public String toString() {
//        return " I am a wild animal and I am angry.";
//    }
//}

public class Wolf extends AbsWildAnimal implements Animal {
    public Wolf(int id) {
        this.setId(id);
        this.setPredator(true);
    }
    @Override
    protected String getDefaultName() {
        return " I am wolf.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}