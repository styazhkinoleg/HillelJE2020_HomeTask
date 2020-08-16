package lesson_05;

public class Animal {
    private int id;
    private int age;
    private double weight;
    private String color;
    public Animal() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String saySomething(){
        return "Hello," + this.toString();
    }
    @Override
    public String toString() {
        return "";
    }
}
