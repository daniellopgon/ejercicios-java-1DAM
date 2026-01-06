package jdbc;

import jdbc.database.StoreInsertsDAO;
import jdbc.database.StoreSelectsDAO;
import jdbc.database.StoreStatsDAO;
import jdbc.database.StoreUpdateDAO;
import jdbc.business.Sale;
import jdbc.business.VideoGame;

import java.time.LocalDate;
import java.util.Scanner;

public class StoreUI {
    public static void main(String[] args) {
        StoreInsertsDAO storeInsert = new StoreInsertsDAO();
        StoreSelectsDAO storeSelect = new StoreSelectsDAO();
        StoreStatsDAO storeStats = new StoreStatsDAO();
        StoreUpdateDAO storeUpdate = new StoreUpdateDAO();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n====== MENÚ TIENDA ======");
            System.out.println("1. Añadir videojuego al inventario");
            System.out.println("2. Mostrar todo el inventario");
            System.out.println("3. Consultar un título (por código o nombre)");
            System.out.println("4. Consultar stock de un título");
            System.out.println("5. Buscar cliente (por código, nombre, apellidos o email)");
            System.out.println("6. Registrar venta (y actualizar stock)");
            System.out.println("7. Mostrar historial de ventas completo");
            System.out.println("8. Mostrar historial de ventas de una fecha");
            System.out.println("9. Estadísticas: Acumulado de ventas por plataforma");
            System.out.println("10. Estadísticas: Acumulado de ventas por género");
            System.out.println("11. Mostrar el título más vendido");
            System.out.println("12. Mostrar el mejor día de ventas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    Long num = 123L;
                    storeInsert.insertVideoGame(new VideoGame("NBA2K2025", "PS5", "Deportes", 89.99, 10, num));
                    System.out.println("Videojuego añadido correctamente.");
                    break;
                case 2:
                    System.out.println("Inventario completo:");
                    storeSelect.getInventory().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Resultado búsqueda por título:");
                    System.out.println(storeSelect.findByTitle("NBA2K2025"));
                    break;
                case 4:
                    System.out.println("Stock del título:");
                    System.out.println(storeSelect.getStockByTitle("NBA2K2025"));
                    break;
                case 5:
                    System.out.println("Resultado búsqueda de cliente:");
                    System.out.println(storeSelect.findByName("Paula".toLowerCase()));
                    break;
                case 6:
                    Sale sale = new Sale(storeSelect.findByName("Paula".toLowerCase()), LocalDate.now());
                    sale.addVideoGame(storeSelect.findByTitle("Elden Ring".toLowerCase()));
                    sale.addVideoGame(storeSelect.findByTitle("God of War Ragnarok".toLowerCase()));

                    storeInsert.insertSale(sale);
                    storeUpdate.updateStock(1, storeSelect.findByTitle("Elden Ring".toLowerCase()).getId());
                    storeUpdate.updateStock(1, storeSelect.findByTitle("God of War Ragnarok".toLowerCase()).getId());
                    System.out.println("Venta registrada correctamente.");
                    break;
                case 7:
                    System.out.println("Historial completo de ventas:");
                    storeSelect.getSalesHistory().forEach(row -> System.out.println(java.util.Arrays.toString(row)));
                    break;
                case 8:
                    System.out.println("Historial de ventas de la fecha:");
                    storeSelect.getSalesHistoryByDate(LocalDate.now())
                            .forEach(row -> System.out.println(java.util.Arrays.toString(row)));
                    break;
                case 9:
                    System.out.println("Acumulado de ventas por plataforma:");
                    storeStats.getTotalSalesByPlatform()
                            .forEach((platform, total) -> System.out.println(platform + ": " + total));
                    break;
                case 10:
                    System.out.println("Acumulado de ventas por género:");
                    storeStats.getTotalSalesByGenre()
                            .forEach((genre, total) -> System.out.println(genre + ": " + total));
                    break;
                case 11:
                    System.out.println("Título más vendido: " + storeStats.getBestSellingTitle());
                    break;
                case 12:
                    System.out.println("Mejor día de ventas: " + storeStats.getBestSalesDay());
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (option != 0);

        sc.close();
    }
}
