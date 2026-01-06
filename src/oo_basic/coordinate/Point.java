package oo_basic.coordinate;

/*
Defina una clase punto que tendrá dos atributos, de tipo real, x e y, que representarán
las coordenadas del punto dentro del plano. Defina un método que tenga como argumento otro
objeto de la clase punto y que calcule la distancia entre los dos puntos.
Para probar esta funcionalidad, escriba un método main en el que se creen dos puntos,
el primero de los cuales deberá tener las coordenadas (100, 200) y el segundo deberá
tener las coordenadas (400, 800) y calcule e imprima la distancia entre ambos.
 */

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {

        double distance;

        distance = Math.sqrt(Math.pow((point.x - x), 2) + Math.pow((point.y - y), 2));

        return distance;
    }
}
