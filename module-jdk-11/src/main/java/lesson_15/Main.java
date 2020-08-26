package lesson_15;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Ошибка передачи параметра 1");
        } else {
            int i = 0;
            try {
                i = Integer.valueOf(args[0]);
            }
            catch (Exception e){
                System.out.println("Параметр должен быть целочисленным числом");
                return;
            }
            if(i < 0) {
                System.out.println("Параметр должен быть положительным целочисленным числом");
                return;
            } else if (i > 0) {
                PseudoGraphics pg = new PseudoGraphics(args[0]);
                pg.show();
            }
        }
    }
}
