package arrays.hangman;

import java.util.Scanner;

/*
Clase principal para ejecutar el juego del ahorcado.
 */
public class HangmanMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        Scanner scanner = new Scanner(System.in);

        int attempts = 6;

        System.out.println("Welcome to Hangman!");

        while (attempts > 0) {
            game.displayGameState();

            System.out.print("Enter a letter: ");
            char letter = scanner.next().toLowerCase().charAt(0);

            if (game.isLetterUsed(letter)) {
                System.out.println("You already used that letter.");
                continue;
            }

            boolean correct = game.guessLetter(letter);

            if (!correct) {
                attempts--;
                System.out.println("Wrong letter! Attempts remaining: " + attempts);
            } else {
                System.out.println("Correct letter!");
            }

            if (game.isWordComplete()) {
                game.displayGameState();
                System.out.println("Congratulations! You guessed the word!");
                scanner.close();
                return;
            }
        }

        System.out.println("Game over! You ran out of attempts!");
        scanner.close();
    }
}