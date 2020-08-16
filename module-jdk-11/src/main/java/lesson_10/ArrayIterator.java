package lesson_10;

import java.util.Iterator;

public class ArrayIterator {
    public static void main(String[] args) {
        int n = 10;
        Integer [] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        Iter itr = new Iter(arr);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

class Iter implements Iterator {
    private Object[] elementData;
    private Object current;
    private int i = 0;
    public Iter(Object[] objects){
        elementData = objects;
    }
    @Override
    public boolean hasNext() {
        return i != elementData.length;
    }
    @Override
    public Object next() {
        current = elementData[i++];
        return current;
    }
}
