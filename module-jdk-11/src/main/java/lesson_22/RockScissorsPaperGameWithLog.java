package lesson_22;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RockScissorsPaperGameWithLog {
    private PlayerClass player1;
    private PlayerClass player2;
    private int scoreToWin;
    private LoggerExample logger;
    private Thread loggerThread;

    public RockScissorsPaperGameWithLog() {
        logger = new LoggerExample();
    }
    public RockScissorsPaperGameWithLog(String logFilePath) {
        logger = new LoggerExample(logFilePath);
    }

    public void start() {
        initialization();
        inputScoreToWin();
        makePlayersMove();
        logger.write("Game result. Score = " + scoreToWin + ". Player vs Computer = " + player1.score + ":"
                + player2.score + ".");
        loggerThread.interrupt();
    }

    private void initialization() {
        player1 = new PlayerClass(new Human());
        player2 = new PlayerClass(new Computer());
        loggerThread = new Thread(logger);
        loggerThread.start();
        logger.write("Game run.");
    }
    private void inputScoreToWin(){
        Scanner scanner = new Scanner(System.in);
        while (scoreToWin == 0){
            System.out.print("Input score to win game: ");
            try {
                scoreToWin = scanner.nextInt();
                if (scoreToWin < 1 ){
                    scoreToWin = 0;
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Input positive integer. ");
            }
        }
        logger.write("Start game with " + scoreToWin + " points to win.");
    }
    private void makePlayersMove() {
        int steps = 0;
        while (player1.score != scoreToWin && player2.score != scoreToWin) {
            try {
                player1.nextMove();
                player2.nextMove();
            } catch (PlayerClass.GameAbort t) {
                System.out.printf("Game abort. Score %d:%d\n", player1.score, player2.score);
                logger.write("Game stopped by user.");
                return;
            }
            System.out.println("You: " + player1.move + ". Your opponent: " + player2.move);
            if (player1.move.equals(player2.move))
                System.out.println("It's draw!");
            else if (player1.isWin(player2)) {
                ++player1.score;
                System.out.printf("You win! Score %d:%d\n", player1.score, player2.score);
            } else {
                ++player2.score;
                System.out.printf("You lose! Score %d:%d\n", player1.score, player2.score);
            }
            logger.write("Step " + ++steps + ". Player: " + player1.move + ". Computer: " + player2.move + ".");
        }
    }

    private class PlayerClass{
        private Player player;
        private Choices move;
        private int score;

        public PlayerClass(Player player) {
            this.player = player;
        }

        public void nextMove() throws GameAbort{
            move = player.nextMove();
            if (move == null) {
                throw new GameAbort();
            }
        }
        public boolean isWin(PlayerClass player) {
            Choices choicesToWin = null;
            switch (player.move) {
                case ROCK: {
                    choicesToWin = Choices.PAPER;
                    break;
                }
                case SCISSORS: {
                    choicesToWin = Choices.ROCK;
                    break;
                }
                case PAPER: {
                    choicesToWin = Choices.SCISSORS;
                    break;
                }
            }
            return move.equals(choicesToWin);
       }

        private class GameAbort extends Exception {
        }
    }

    private interface Player {
        public Choices nextMove();
    }

    private class Human implements Player {
        @Override
        public Choices nextMove() {
            Scanner scanner = new Scanner(System.in);
            var choices = Arrays.stream(Choices.values()).collect(Collectors.toList());
            int choice = 0;
            while (choice == 0) {
                System.out.println("Choice menu:");
                choices.stream().forEach((x) -> System.out.printf("%d - %s\n", choices.indexOf(x) + 1, x));
                System.out.println("0 - Exit game");
                System.out.print("Make your choice: ");
                try {
                    choice = scanner.nextInt();
                    if (choice == 0)
                        return null;
                    else if (choice < 1 || choice > choices.size()){
                        choice = 0;
                        throw new InputMismatchException();                }

                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Wrong value. Please repeat!");
                }
            }
            return choices.get(choice - 1);
        }
    }

    private class Computer implements Player {
        @Override
        public Choices nextMove() {
            Choices [] objects = Choices.values();
            Random random = new Random();
            return objects[random.nextInt(objects.length - 1)];
        }
    }

    private enum Choices {
        ROCK,
        SCISSORS,
        PAPER
    }
}