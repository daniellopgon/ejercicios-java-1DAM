package functions;

/*
Realiza un método redondear() al que se le pasa como parámetro un numero
float y los decimales que deben quedar después de redondear, y retorna el numero redondeado.
Ejemplo: redondear( 234.49234 , 3 )
Da como resultado : 234.492
 */

public class Rounder {

    public static void main(String[] args) {

        float number = 234.49234f;
        int decimals = 3;

        System.out.println("El resultado es: " + round(number, decimals));

    }

    static double round(float number, int decimals) {

        double power = Math.pow(10, decimals);

        return Math.round(number * power) / power;
    }
}
