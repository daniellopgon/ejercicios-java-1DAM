package functions;

/*
Haz un método llamado esVocal(), al que se le pasa como parámetro un carácter
y retorna un valor true en caso de que el carácter sea una vocal, y un valor false en caso contrario.
 */

public class Vowel {

    public static void main(String[] args) {

        char test = 'a';

        if (isVowel(test)) {
            System.out.println("Es una vocal");
        } else {
            System.out.println("No es una vocal");
        }

    }

    static boolean isVowel(char character) {

        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' ||
                character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
