package lesson_14;

import java.util.Collection;

public final class Search extends Compare{
    public static int binarySearch(Collection collection, Object findObject){
        Object [] objects = collection.toArray();
        int left = 0;
        int right = objects.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (objects[middle].equals(findObject)) {
                return middle;
            } else if (isBigger(findObject, objects[middle])){
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return -1;
    }
    public static int interpolationSearch(Collection collection, Object findObject) {
        if (findObject instanceof Integer) {
            Object[] objects = collection.toArray();
            int left = 0;
            int right = objects.length - 1;
            while (isBigger(findObject, objects[left]) && isBigger(objects[right], findObject)) {
                int middle = left
                        + (Integer.valueOf(findObject.toString()) - Integer.valueOf(objects[left].toString()))
                        * (right - left)
                        / (Integer.valueOf(objects[right].toString()) - Integer.valueOf(objects[left].toString()));
                if (Compare.isBigger(findObject, objects[middle])) {
                    left = middle + 1;
                } else if (Compare.isBigger(objects[middle], findObject)) {
                    right = middle - 1;
                } else {
                    return middle;
                }
                if (objects[left].equals(findObject)) {
                    return left;
                } else if (objects[right].equals(findObject)) {
                    return right;
                } else {
                    return -1;
                }
            }
        }
        else
            System.out.printf("Method support only Integer");
        return -1;
    }
}
