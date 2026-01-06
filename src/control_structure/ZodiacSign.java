package control_structure;

/*
Crea un programa que imprima tu signo del zodiaco según tu fecha de nacimiento.
 */

import java.util.Scanner;

public class ZodiacSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu día de nacimiento: ");
        int day = sc.nextInt();

        System.out.print("Introduce tu mes de nacimiento (1-12): ");
        int month = sc.nextInt();

        String sign;

        switch (month) {
            case 1:
                sign = (day < 20) ? "Capricornio" : "Acuario";
                break;
            case 2:
                sign = (day < 19) ? "Acuario" : "Piscis";
                break;
            case 3:
                sign = (day < 21) ? "Piscis" : "Aries";
                break;
            case 4:
                sign = (day < 20) ? "Aries" : "Tauro";
                break;
            case 5:
                sign = (day < 21) ? "Tauro" : "Géminis";
                break;
            case 6:
                sign = (day < 21) ? "Géminis" : "Cáncer";
                break;
            case 7:
                sign = (day < 23) ? "Cáncer" : "Leo";
                break;
            case 8:
                sign = (day < 23) ? "Leo" : "Virgo";
                break;
            case 9:
                sign = (day < 23) ? "Virgo" : "Libra";
                break;
            case 10:
                sign = (day < 23) ? "Libra" : "Escorpio";
                break;
            case 11:
                sign = (day < 22) ? "Escorpio" : "Sagitario";
                break;
            case 12:
                sign = (day < 22) ? "Sagitario" : "Capricornio";
                break;
            default:
                sign = "Introduce una fecha correcta";
        }

        System.out.println("Tu signo del zodiaco es: " + sign);
    }

}
