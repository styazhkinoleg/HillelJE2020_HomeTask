package lesson_06;

public interface Pet extends Animal{
    String getName();
    void setName(String name);
    boolean isVaccinated();
    void setVaccinated(boolean vaccinated);
}
