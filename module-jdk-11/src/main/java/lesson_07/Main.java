package lesson_07;

public class Main {
    public static void main(String[] args) {
        StringCollection stringCollection = new StringCollection();
        stringCollection.add("This");
        stringCollection.add("home");
        stringCollection.add("task");
        stringCollection.add("№");
        stringCollection.add("7");
        stringCollection.print();

        stringCollection.add(1, "is");
        stringCollection.add(2, "my");
        stringCollection.print();

        stringCollection.delete(2);
        stringCollection.print();

        stringCollection.delete("is");
        stringCollection.print();
    }
}
