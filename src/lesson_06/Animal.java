package lesson_06;

public interface Animal {
    default String saySomething(){
        return "Hello," + this.toString();
    }
    default String voice(){
        return "";
    }
}