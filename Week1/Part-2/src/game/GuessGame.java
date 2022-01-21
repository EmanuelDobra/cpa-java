package game;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public GuessGame() {
        super();
        System.out.println("Game works!");
    }

    public int playGame(int range) {
        int guess;
        int guessCount = 0;
        int correctNum = new Random(1000).nextInt(range);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess: ");
        guess = scanner.nextInt();

        while(guess != correctNum) {
            guessCount++;
            if (guess > correctNum) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            } 
            System.out.println("Guess again: ");
            guess = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Correct!, the number was " + correctNum);
        
        return guessCount;
    }
}
