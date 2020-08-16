package lesson_06;

public class Dog extends AbsPet implements Animal {
    public Dog(int id, String name, boolean vaccinated) {
        this.setId(id);
        this.setName(name);
        this.setVaccinated(vaccinated);
    }
    @Override
    public String voice() {
        return " Woof!";
    }
    @Override
    protected String getDefaultName() {
        return "a dog";
    }
    @Override
    public String toString() {
        return super.toString() + this.voice();
    }
}
