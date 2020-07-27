package lesson_10;

import java.util.*;

public class UniqueCollection {
    public static void main(String[] args) {
        System.out.println("ArrayList");
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        System.out.println(list);
        UniqueCollection(list);
        System.out.println(list);
        System.out.println("LinkedList");
        list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        System.out.println(list);
        UniqueCollection(list);
        System.out.println(list);
    }
    public static void UniqueCollection (Collection call){
        Set set = new HashSet();
        set.addAll(call);
        call.clear();
        call.addAll(set);
    }
}
