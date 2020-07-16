package lesson_06;

public class Cat extends AbsPet implements Animal {

    public Cat(int id, String name, boolean vaccinated) {
        this.setId(id);
        this.setName(name);
        this.setVaccinated(vaccinated);
    }
    @Override
    public String voice() {
        return " Meow!";
    }

    @Override
    protected String getDefaultName() {
        return "a cat";
    }

    @Override
    public String toString() {
        return super.toString() + this.voice();
    }
}

