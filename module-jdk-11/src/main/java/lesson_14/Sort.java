package lesson_14;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.stream.Collectors;

public final class Sort extends Compare{
    public static List bubbleSort(Collection collection) {
        boolean repeat = true;
        Object [] objects = collection.toArray();
        while (repeat){
            repeat = false;
            for (int i = 0; i < objects.length - 1; i++) {
                if(isBigger(objects[i], objects[i+1])){
                    Object ob = objects[i+1];
                    objects[i+1] = objects[i];
                    objects[i] = ob;
                    repeat = true;
                }
            }
        }
        return Arrays.stream(objects).collect(Collectors.toList());
    }
    public static List insertSort(Collection collection){
        int left, right;
        Object [] objects = collection.toArray();
        for (right = 1; right < objects.length; right++) {
            var temp = objects[right];
            left = right;
            while (left > 0 && isBigger(objects[left-1],temp)) {
                objects[left] = objects[left-1];
                --left;
            }
            objects[left] = temp;
        }
        return Arrays.stream(objects).collect(Collectors.toList());
    }
}
