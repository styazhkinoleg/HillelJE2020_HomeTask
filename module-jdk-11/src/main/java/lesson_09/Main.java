package lesson_09;

public class Main {
    public static void main(String[] args) {
        // This is my home task № 9"

        DoubleLinkCollection list = new DoubleLinkCollection();

        DoubleLinkCollection listTest = new DoubleLinkCollection();
        listTest.addAll("home task № 9".split(" "));

        list.add("this");
        list.add("is");
        list.add("my");
        list.add(null);
        list.addAll(listTest);

        printList(list, "list");
        printList(listTest, "listTest");

        System.out.println("list     contains 'is' = " + list.contains("is"));
        System.out.println("listTest contains 'is' = " + listTest.contains("is"));

        System.out.println("list compare listTest = " + list.compare(listTest));

        list.delete("my");
        printList(list, "list");
        list.delete(1);
        printList(list, "list");

        list.trim();
        printList(list, "list");

        list.delete("this");
        printList(list, "list");
        printList(listTest, "listTest");
        System.out.println("list compare listTest = " + list.compare(listTest));

        list.clear();
        printList(list, "list");
    }

    public static void printList(DoubleLinkCollection list, String title){
        System.out.printf("%-10s = ", title);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
