import game.GuessGame;

public class App {
    public static void main(String[] args) {
        System.out.println("App works!");

        GuessGame game = new GuessGame();
        int guesses = game.playGame(1000);

        System.out.println("It took you " + guesses + " tries to guess the number!");
    }   
}
