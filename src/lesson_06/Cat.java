package lesson_06;

public class Cat implements Pet{

    private int id;
    private int age;
    private double weight;
    private String color;
    private String name = "";
    private boolean vaccinated;

    public Cat(int id, String name, boolean vaccinated) {
        this.setId(id);
        this.setName(name);
        this.setVaccinated(vaccinated);
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
        return this.vaccinated;
    }

    @Override
    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return ((this.name != "") ? " my name is " + this.getName() + "." : " I'm a cat.") + this.voice();
    }
}

