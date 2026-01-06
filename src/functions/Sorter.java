package functions;

/*
Haz programa que ordene alfabéticamente las letras de una frase.
El programa debe pedir por teclado una frase y escribirla con las letras ordenadas.
Ejemplo: Tecleando la palabra "hola"
Escribirá "ahlo"
El trabajo de ordenar la frase lo realizará un método llamado ordenar()
al que se le pasará la frase y la retornará ordenada. Este método realizará
el trabajo de la siguiente manera:
Repetir tantas veces como letras tenga la frase
{
Obtener la letra menor
Añadir esa letra al resultado
Eliminar la letra de la frase original
}
El proceso de obtener la letra menor lo realizará un método llamado
obtenerLetraMenor() al que se le pasa la frase y nos da la letra mas pequeña.
Asimismo el trabajo de eliminar la letra de la frase original lo realizará
otro método llamado eliminarLetra() al que se le pasa la frase y la letra a
eliminar y nos da como resultado la frase modificada.
 */

import java.util.Scanner;

public class Sorter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase:");
        String phrase = sc.nextLine();

        String result = sort(phrase);
        System.out.println("Frase ordenada: " + result);

        sc.close();
    }

    static String sort(String phrase) {
        String result = "";

        while (!phrase.isEmpty()) {

            char smallestLetter = getSmallestLetter(phrase);

            result += smallestLetter;

            phrase = removeLetter(phrase, smallestLetter);
        }

        return result;
    }

    static char getSmallestLetter(String phrase) {
        char smallest = phrase.charAt(0);

        for (int i = 1; i < phrase.length(); i++) {
            if (phrase.charAt(i) < smallest) {
                smallest = phrase.charAt(i);
            }
        }

        return smallest;
    }

    static String removeLetter(String phrase, char letter) {
        StringBuilder sb = new StringBuilder();
        boolean letterRemoved = false;

        for (int i = 0; i < phrase.length(); i++) {
            if (!letterRemoved && phrase.charAt(i) == letter) {

                letterRemoved = true;
            } else {
                sb.append(phrase.charAt(i));
            }
        }

        return sb.toString();
    }
}
