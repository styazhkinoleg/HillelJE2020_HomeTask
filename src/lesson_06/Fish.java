package lesson_06;

public class Fish implements Pet{
    private int id;
    private int age;
    private double weight;
    private String color;
    private String name = "";
    private boolean vaccinated;

    public Fish(int id) {
        this.setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    private String voice(){
        return " Meow!";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isVaccinated() {
        return false;
    }

    @Override
    public void setVaccinated(boolean vaccinated) {
    }

    @Override
    public String saySomething() {
        return "....";
    }
}
