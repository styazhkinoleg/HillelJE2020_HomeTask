package lesson_16;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RockScissorsPaperGame {
    private PlayerClass player1;
    private PlayerClass player2;
    private int scoreToWin;
    final private String nameLogFile = "log.txt";

    public RockScissorsPaperGame() {
        initialization();
    }

    public void start() {
        initialization();
        inputScoreToWin();
        makePlayersMove();
        writeLogFile();
    }

    private void initialization() {
        player1 = new PlayerClass(new Human());
        player2 = new PlayerClass(new Computer());
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
    }
    private void makePlayersMove() {
        while (player1.score != scoreToWin && player2.score != scoreToWin) {
            try {
                player1.nextMove();
                player2.nextMove();
            } catch (PlayerClass.GameAbort t) {
                System.out.printf("Game abort. Score %d:%d\n", player1.score, player2.score);
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
        }
    }
    private void writeLogFile(){
        String currentDirectory = null;
        try {
            currentDirectory = this.getClass().getResource(".").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File log = new File(currentDirectory + nameLogFile);
        boolean ifExist = log.exists();
        try {
            FileOutputStream outStreamFile = new FileOutputStream(log, ifExist);
            if(ifExist)
                outStreamFile.write("\n".getBytes());
            outStreamFile.write(String.format("%s. Result %d : %d. %s", new Date().toString(),
                    player1.score, player2.score,
                    (player1.score > player2.score ? "Congratulations, you win!" :
                            (player1.score < player2.score ? "Try again." : ""))).getBytes());
            outStreamFile.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
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

}