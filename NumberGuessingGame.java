import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        boolean playAgain;

        do {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 5;
            int score = 0;
            boolean hasWon = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + min + " and " + max + ".");

            while (attempts > 0) {
                System.out.println("Enter your guess (Attempts left: " + attempts + "): ");
                int guess = scanner.nextInt();
                attempts--;

                if (guess < min || guess > max) {
                    System.out.println("Please enter a valid number within the range.");
                    continue;
                }

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (attempts + 1);
                    hasWon = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your score: " + score);

            System.out.println("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}