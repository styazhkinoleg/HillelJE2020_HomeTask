package lesson_06;

public abstract class AbsAnimal{
    private int id;
    private int age;
    private double weight;
    private String color;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    protected String getDefaultName() {
        return "";
    }

    @Override
    public String toString() {
        return "";
    }
}
