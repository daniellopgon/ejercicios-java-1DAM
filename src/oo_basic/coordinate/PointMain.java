package oo_basic.coordinate;

public class PointMain {
    public static void main(String[] args) {

        Point point = new Point(100, 200);

        System.out.println(" La distancia es: " + point.distance(new Point(400, 800)));
    }
}
