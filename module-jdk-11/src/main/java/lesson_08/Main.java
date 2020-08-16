package lesson_08;

public class Main {
    public static void main(String[] args) {
        ObjectCollection objectCollection = new ObjectCollection();
        objectCollection.add("This");
        objectCollection.add("home");
        objectCollection.add("task");
        objectCollection.add("№");
        objectCollection.add("7");
        objectCollection.print();

        objectCollection.add(1, "is");
        objectCollection.add(2, "my");
        objectCollection.print();

        objectCollection.delete("my");
        objectCollection.print();

        System.out.println(objectCollection.contain("home"));
        System.out.println(objectCollection.contain("my"));

        ObjectCollection oc1 = new ObjectCollection();
        oc1.add("home");
        oc1.add("task");

        System.out.println(objectCollection.equals(oc1));

        ObjectCollection oc2 = new ObjectCollection();
        oc2.add("my");
        oc2.add("task");

        System.out.println(objectCollection.equals(oc2));
    }
}
