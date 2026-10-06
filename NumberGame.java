import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();

            int score = 0;
            String playAgain;

            do {
                int number = random.nextInt(100) + 1;
                int attempts = 7;
                boolean guessed = false;

                System.out.println("\nGuess the number between 1 and 100.");
                System.out.println("You have " + attempts + " attempts.");

                for (int i = 1; i <= attempts; i++) {
                    int guess;
                    while (true) {
                        System.out.print("Enter your guess: ");
                        if (sc.hasNextInt()) {
                            guess = sc.nextInt();
                            if (guess >= 1 && guess <= 100) {
                                break;
                            }
                        } else {
                            sc.next();
                        }
                        System.out.println("Please enter a number between 1 and 100.");
                    }

                    if (guess == number) {
                        System.out.println("Correct! You guessed it in " + i + " attempts.");
                        score++;
                        guessed = true;
                        break;
                    } else if (guess < number) {
                        System.out.println("Too low!");
                    } else {
                        System.out.println("Too high!");
                    }

                    System.out.println("Attempts left: " + (attempts - i));
                }

                if (!guessed) {
                    System.out.println("You lost! The number was " + number);
                }

                System.out.println("Current score: " + score);

                while (true) {
                    System.out.print("Do you want to play again? (yes/no): ");
                    playAgain = sc.next();
                    if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no")) {
                        break;
                    }
                    System.out.println("Please type 'yes' or 'no'.");
                }

            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("\nGame over!");
            System.out.println("Final score: " + score);
        }
    }
}