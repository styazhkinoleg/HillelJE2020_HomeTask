package lesson_11;

public class Main {
    public static void main(String[] args) {
        HomeTask [] homeTasks = new HomeTask[3];
        for (int i = 0; i < homeTasks.length; i++) {
            homeTasks[i] = new HomeTask(i+1, getTopic(i+1));
        }
        for (HomeTask ht: homeTasks) {
            System.out.println("Task " + ht.id());
            System.out.println(ht.name());
        }
    }
    public static String getTopic(int i){
        return switch (i){
            case 1 -> """
                    1. JDK, JVM
                    2. Установка JDK, Git, IDE
                    3. Запуск первого приложения HelloWorld
                    """;
            case 2 -> """
                    1. Структура класса Java                                        
                    2. Комментарии                                        
                    3. Класс vs. Файл                                        
                    4. Примитивные типы данных                                        
                    5. String
                    """;
            case 3 -> """
                    1. Модификаторы доступа                                       
                    2. Привидение типов                                        
                    3. Java control structure                                        
                    4. Одномарные массивы                                        
                    5. Многомерные массивы
                    """;
            default -> "";
        };
    }
}

record HomeTask(int id, String name){}
