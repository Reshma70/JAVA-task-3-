import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int rounds = 3;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\nYou have " + rounds + " rounds. Try to guess the number between 1 and 100.");

        for (int i = 1; i <= rounds; i++) {
            int numberToGuess = new Random().nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Round " + i + " - Attempt " + (attempts + 1) + ": Enter your guess (1-100):");

                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled.");
                    return;
                }

                try {
                    int guess = Integer.parseInt(input);
                    attempts++;

                    if (guess == numberToGuess) {
                        int roundScore = 100 - (attempts - 1) * 20;
                        score += roundScore;
                        JOptionPane.showMessageDialog(null, "Correct! You guessed it in " + attempts + " attempt(s).\nYou earned " + roundScore + " points.");
                        guessedCorrectly = true;
                        break;
                    } else if (guess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Too low! Try again.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Too high! Try again.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "You've used all attempts! The number was: " + numberToGuess);
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your final score is: " + score);
    }
}
