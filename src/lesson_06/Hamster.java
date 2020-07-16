package lesson_06;

public class Hamster extends AbsPet implements Animal {
    public Hamster(int id, String name, boolean vaccinated) {
        this.setId(id);
        this.setName(name);
        this.setVaccinated(vaccinated);
    }
    @Override
    protected String getDefaultName() {
        return "a hamster";
    }
}