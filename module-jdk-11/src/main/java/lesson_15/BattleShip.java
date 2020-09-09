package lesson_15;

import java.util.*;

public class BattleShip {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game{
    private final int shipNumber = 4;
    private final int x = 4;
    private final int y = 4;
    private int fires;
    private int survivedShips;
    private long startAt;
    private Set<Coordinates> fireCoordinates = new HashSet<>();
    Coordinates [] ships = new Coordinates[shipNumber];

    public void start() {
        createShips();
        initialize();
        while (survivedShips > 0 && fires > 0){
            showMenu(false);
            makeFire();
        }
        showMenu(true);
    }
    private void createShips() {
        List<Coordinates> emptyElements = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j < y; j++) {
                emptyElements.add(new Coordinates(i, j));
            }
        }
        for (int i = 0; i < shipNumber; i++) {
            int index = (int)(Math.random() * 10) % emptyElements.size();
            Coordinates newShip = emptyElements.get(index);
            ships[i] = newShip;
            emptyElements.remove(newShip);
            emptyElements.remove(new Coordinates(Math.max(1,newShip.getX() - 1), newShip.getY()));
            emptyElements.remove(new Coordinates(Math.min(x,newShip.getX() + 1), newShip.getY()));
            emptyElements.remove(new Coordinates(newShip.getX(), Math.max(1,newShip.getY() - 1)));
            emptyElements.remove(new Coordinates(newShip.getX(), Math.min(y,newShip.getY() + 1)));
        }
    }
    private void initialize() {
        survivedShips = shipNumber;
        fireCoordinates.clear();
        fires = x * y - shipNumber;
        startAt = System.currentTimeMillis();
    }
    private void showMenu(boolean end) {
        System.out.println("=========================================================");
        System.out.println("====================== BATTLE SHIP ======================");
        System.out.printf("Ships left: %5d. Fire left: %5d\n", survivedShips, fires);
        System.out.print("   ");
        for (int i = 1; i <= y; i++) {
            System.out.printf(" %2d ", i);
        }
        System.out.println();
        for (int i = 0; i < x; i++) {
            System.out.println("   -----------------");
            System.out.printf(" %2d", i+1);
            for (int j = 0; j < y; j++) {
                String mark = " ";
                Coordinates test = new Coordinates(i+1,j+1);
                if (fireCoordinates.contains(test)){
                    if (contain(ships, test)){
                        mark = "╳";
                    } else
                        mark = "*";
                } else if(end) {
                    if (contain(ships, test)) {
                        mark = "╬";
                    }
                }
                System.out.printf("| %s ", mark);
            }
            System.out.print("|\n");
        }
        System.out.println("   -----------------");
        if (end) {
            System.out.println();
            if (fires == 0 && survivedShips > 0){
                System.out.println("GAME OVER!");
            }else {
                System.out.println(getResult());
            }

        }
    }
    private void makeFire(){
        System.out.print("Make fire like \"X Y\": ");
        Scanner scanner = new Scanner(System.in);
        String [] ar = scanner.nextLine().trim().split(" ");
        if (ar.length == 2){
            int x = 0, y = 0;
            try {
                x = Integer.valueOf(ar[0]);
                y = Integer.valueOf(ar[1]);
            }
            catch (Exception e) {
                System.out.println("Wrong coordinates") ;
                return;
            };
            if ((x < 0 && x > this.x) || (y < 0 && y > this.y)){
                System.out.println("Wrong coordinates") ;
                return;
            }
            Coordinates fire = new Coordinates(x, y);
            if (!fireCoordinates.contains(fire)) {
                fireCoordinates.add(fire);
                if(contain(ships, fire)) {
                    -- survivedShips;
                    fireCoordinates.add(new Coordinates(Math.max(1,fire.getX() - 1), fire.getY()));
                    fireCoordinates.add(new Coordinates(Math.min(this.x,fire.getX() + 1), fire.getY()));
                    fireCoordinates.add(new Coordinates(fire.getX(), Math.max(1,fire.getY() - 1)));
                    fireCoordinates.add(new Coordinates(fire.getX(), Math.min(this.y,fire.getY() + 1)));
                }
            }
            -- fires;
        }else
            System.out.println("Wrong coordinates") ;
    }
    private String getResult() {
        long gameTime = System.currentTimeMillis() - startAt;
        // осталось до 2х минут игры
        int leftByTwoMinutes = (int) Math.max(0, 120_000 - (gameTime));
        int finalScore = 1000 * fires + leftByTwoMinutes * 10;
        int minutesGame = (int) (gameTime / 60_000);
        int secondsGame = (int) ((gameTime - minutesGame * 60_000) / 1_000);
        int millisecondsGame = (int) (gameTime - minutesGame * 60_000 - secondsGame * 1_000);
        return String.format("TOTAL SCARE = %d. Time = %dm %ds %dms",
                finalScore, minutesGame, secondsGame, millisecondsGame);
    }
    private boolean contain(Coordinates [] arr, Coordinates val){
        return  Arrays.stream(arr).anyMatch(x -> val.equals(x));
    }
}

class Coordinates {
    private int x;
    private int y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}