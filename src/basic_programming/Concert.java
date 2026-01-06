package basic_programming;

/*
Crea un programa que dada la duración de un concierto en segundos, calcule cuántas horas, minutos y segundos son.

Por ejemplo:

¿Cuántos segundos dura el concierto? 8479

Es equivalente a: 2:21:19
 */

import java.util.Scanner;

public class Concert {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de segundos: ");
        int seconds = sc.nextInt();

        int hours = seconds / 3600;
        int minutes = seconds % 3600 / 60;
        int realSeconds = seconds % 3600 % 60;

        System.out.println(hours + ":" + minutes + ":" + realSeconds);

        sc.close();

    }
}
