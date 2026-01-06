package lambda;

/*
Crea una lista de objetos Concierto, donde cada uno tenga atributos como nombre, ciudad, y precioEntrada.

Usa una expresión lambda para filtrar solo los conciertos que se celebran en Madrid.

Luego, usa otra expresión lambda para obtener el concierto con el precio más bajo.

Finalmente, imprime el nombre y ciudad de los conciertos con entrada inferior a 30 €.
 */

import java.util.ArrayList;

public class Concert {
    private String name;
    private String city;
    private double ticketPrice;

    public Concert(String name, String city, double ticketPrice) {
        this.name = name;
        this.city = city;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public static void main(String[] args) {
        ArrayList<Concert> concertList = new ArrayList<>();

        concertList.add(new Concert("viña rock", "Caceres", 60.78));
        concertList.add(new Concert("summer fest", "Gandia", 25.54));
        concertList.add(new Concert("techno", "Madrid", 250.23));

        System.out.println("Conciertos en Madrid:");
        concertList.stream()
                .filter(c -> c.getCity().equals("Madrid"))
                .forEach(c -> System.out.println(c.getCity() + " " + c.getName()));

        Concert cheapest = concertList.stream()
                .min((c1, c2) -> Double.compare(c1.getTicketPrice(), c2.getTicketPrice()))
                .orElse(null);

        if (cheapest != null) {
            System.out.println("Concierto más barato:");
            System.out.println(cheapest.getName() + " " + cheapest.getTicketPrice() + "€");
        }

        System.out.println("Conciertos con entrada < 30€:");
        concertList.stream()
                .filter(c -> c.getTicketPrice() < 30)
                .forEach(c -> System.out.println(c.getName() + " " + c.getCity()));
    }
}
