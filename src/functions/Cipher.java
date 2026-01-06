package functions;

/*
Crea dos métodos, uno para encriptar encrypt() y otro para desencriptar decrypt() una cadena de caracteres.
Estos métodos reciben un String y devuelven ese String ya encriptado o desencriptado.
Para encriptar un String, cada letra se cambia por la que está dos posiciones
adelante (la a se cambia por c), teniendo en cuenta que el cambio es circular,
es decir, la z se cambiará por b. El proceso de desencriptado es el opuesto.
Los caracteres no alfabéticos no sufrirán ningún cambio.
 */

public class Cipher {

    public static void main(String[] args) {
        String word = "zapato";

        System.out.println("The encrypted string is: " + encrypt(word));
        System.out.println("The decrypted string is: " + decrypt(encrypt(word)));
    }

    static String encrypt(String text) {
        char letter;
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            letter = text.charAt(i);

            if (Character.isLetter(letter)) {
                if (Character.isLowerCase(letter)) {
                    if (letter == 'y') {
                        letter = 'a';
                    } else if (letter == 'z') {
                        letter = 'b';
                    } else {
                        letter = (char) (letter + 2);
                    }
                } else {
                    if (letter == 'Y') {
                        letter = 'A';
                    } else if (letter == 'Z') {
                        letter = 'B';
                    } else {
                        letter = (char) (letter + 2);
                    }
                }
            }
            encryptedText.append(letter);
        }
        return encryptedText.toString();
    }

    static String decrypt(String text) {
        char letter;
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            letter = text.charAt(i);

            if (Character.isLetter(letter)) {
                if (Character.isLowerCase(letter)) {
                    if (letter == 'a') {
                        letter = 'y';
                    } else if (letter == 'b') {
                        letter = 'z';
                    } else {
                        letter = (char) (letter - 2);
                    }
                } else {
                    if (letter == 'A') {
                        letter = 'Y';
                    } else if (letter == 'B') {
                        letter = 'Z';
                    } else {
                        letter = (char) (letter - 2);
                    }
                }
            }
            decryptedText.append(letter);
        }
        return decryptedText.toString();
    }
}