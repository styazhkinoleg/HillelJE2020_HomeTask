package lesson_05;

public class Pet extends Animal{
    private String name = "";
    private boolean vaccinated;
    public Pet() {
    }
    public Pet(int id, String name) {
        this.setId(id);
        this.setName(name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isVaccinated() {
        return vaccinated;
    }
    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    @Override
    public String toString() {
        return (this.name != "") ? " my name is " + this.getName() + "." : "";
    }
}
