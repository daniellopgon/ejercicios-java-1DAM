package oo_basic.coordinate;

/*
Clase principal para probar la clase Point.
 */

public class PointMain {
    public static void main(String[] args) {

        Point point = new Point(100, 200);

        System.out.println(" La distancia es: " + point.distance(new Point(400, 800)));
    }
}
