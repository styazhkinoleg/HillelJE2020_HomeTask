package lesson_14;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Compare {
    public static boolean isBigger(Object f, Object s) {
        BiPredicate isBigger = (x, y) -> {
            if(x instanceof Number){
                return Long.valueOf(x.toString()) > Long.valueOf(y.toString());
            }else if (x instanceof String) {
                return !x.equals(Stream.of(x,y).sorted().findFirst().get());
            } else {
                System.out.println("Not supported type");
                return false;
            }
        };
        return isBigger.test(f, s);
    }
}
