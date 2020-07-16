package lesson_06;

public class AbsPet extends AbsAnimal{
    private String name;
    private boolean vaccinated;

    public void setName(String name) {
        this.name = name;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVaccinated() {
        return this.vaccinated;
    }

    @Override
    public String toString() {
        return (this.name != "") ? " my name is " + this.getName() + "." : " I'm " + this.getDefaultName() + ".";
    }
}
