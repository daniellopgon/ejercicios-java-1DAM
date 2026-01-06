package arrays.hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
Juego del ahorcado completo con su lógica de juego.
El jugador debe adivinar una palabra letra por letra antes de quedarse sin intentos.
 */
public class HangmanGame {

    private static final String[] WORDS = {"goat", "cow", "pig", "chicken", "hen", "horse", "sheep", "duck"};
    private static final char HIDDEN_CHAR = '_';
    private static final int MAX_WRONG_GUESSES = 6;

    private final String secretWord;
    private final char[] progress;
    private final Set<Character> usedLetters;
    private int wrongGuesses;

    public HangmanGame() {
        Random random = new Random();
        secretWord = WORDS[random.nextInt(WORDS.length)];
        progress = new char[secretWord.length()];
        usedLetters = new HashSet<>();
        wrongGuesses = 0;

        initializeProgress();
    }

    private void initializeProgress() {
        for (int i = 0; i < progress.length; i++) {
            progress[i] = HIDDEN_CHAR;
        }
    }

    public boolean isLetterUsed(char letter) {
        return usedLetters.contains(Character.toLowerCase(letter));
    }

    public boolean guessLetter(char letter) {
        letter = Character.toLowerCase(letter);

        if (isLetterUsed(letter)) {
            return false;
        }

        usedLetters.add(letter);
        boolean isCorrect = false;

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                progress[i] = letter;
                isCorrect = true;
            }
        }

        if (!isCorrect) {
            wrongGuesses++;
        }

        return isCorrect;
    }

    public boolean isWordComplete() {
        for (char c : progress) {
            if (c == HIDDEN_CHAR) return false;
        }
        return true;
    }

    public boolean isGameOver() {
        return wrongGuesses >= MAX_WRONG_GUESSES || isWordComplete();
    }

    public boolean hasWon() {
        return isWordComplete() && wrongGuesses < MAX_WRONG_GUESSES;
    }

    public void displayGameState() {
        System.out.print("Word: ");
        for (char c : progress) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Used letters: ");
        for (char letter : usedLetters) {
            System.out.print(letter + " ");
        }
        System.out.println();

        System.out.println("Wrong guesses: " + wrongGuesses + "/" + MAX_WRONG_GUESSES);
        displayHangman();
    }

    private void displayHangman() {
        String[] hangmanParts = {
                "  +---+",
                "  |   |",
                wrongGuesses > 0 ? "  O   |" : "      |",
                wrongGuesses > 1 ? " /|\\  |" : wrongGuesses > 1 ? " /|   |" : "      |",
                wrongGuesses > 3 ? " / \\  |" : wrongGuesses > 2 ? " /    |" : "      |",
                "      |",
                "========="
        };

        for (String part : hangmanParts) {
            System.out.println(part);
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word letter by letter.");

        while (!game.isGameOver()) {
            game.displayGameState();
            System.out.print("Enter a letter: ");

            String input = scanner.nextLine().trim();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (game.isLetterUsed(guess)) {
                System.out.println("You already used that letter!");
                continue;
            }

            boolean correct = game.guessLetter(guess);
            System.out.println(correct ? "Good guess!" : "Wrong letter!");
        }

        game.displayGameState();

        if (game.hasWon()) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Game Over! The word was: " + game.getSecretWord());
        }

        scanner.close();
    }
}