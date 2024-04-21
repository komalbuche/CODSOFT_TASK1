package Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10; // Maximum attempts allowed per round
    private static final int MIN_NUMBER = 1; // Minimum range for random number
    private static final int MAX_NUMBER = 100; // Maximum range for random number

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0; // User's score based on rounds won
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        // Game loop for multiple rounds
        while (playAgain) {
            // Generate a random number within the specified range
            int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;

            // Initialize attempt counter
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nA new round has started!");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            // Round loop for a single game
            while (attempts < MAX_ATTEMPTS) {
                // Prompt the user to enter their guess
                System.out.print("\nEnter your guess (between " + MIN_NUMBER + " and " + MAX_NUMBER + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                // Compare the user's guess with the target number and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                // Check if the user has exceeded the maximum number of attempts
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("You've used all your attempts. The correct number was: " + targetNumber);
                }
            }

            // Display the user's score
            System.out.println("\nRound over. Your score: " + score);

            // Ask the user if they want to play another round
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }
}
