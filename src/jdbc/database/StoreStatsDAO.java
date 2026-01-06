package jdbc.database;

/*
DAO para estadísticas de ventas de la tienda.
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;

public class StoreStatsDAO {
    private final static String URL = "jdbc:mariadb://localhost:3306/Tienda";
    private final static String USER = "dani";
    private final static String PASSWD = "";

    public String getBestSellingTitle() {
        String sql = """
                    SELECT v.titulo
                    FROM Videojuegos v
                    JOIN DetalleVenta de ON v.idVideojuego = de.codVideojuego
                    JOIN Ventas ve ON ve.idVenta = de.codVenta
                    GROUP BY v.idVideojuego
                    HAVING SUM(de.cantidad) = (
                        SELECT MAX(total)
                        FROM (
                            SELECT SUM(de2.cantidad) total
                            FROM DetalleVenta de2
                            JOIN Ventas ve2 ON ve2.idVenta = de2.codVenta
                            GROUP BY de2.codVideojuego
                        ) AS subQuery
                    )
                """;
        String title = "";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                title = rs.getString("titulo");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el título más vendido: " + e.getMessage());
        }

        return title;
    }

    public LocalDate getBestSalesDay() {
        String sql = """
                    SELECT v.fecha
                    FROM DetalleVenta de
                    JOIN Ventas v ON v.idVenta = de.codVenta
                    GROUP BY v.fecha
                    HAVING SUM(de.cantidad) = (
                        SELECT MAX(total)
                        FROM (
                            SELECT SUM(de2.cantidad) total
                            FROM DetalleVenta de2
                            JOIN Ventas v2 ON v2.idVenta = de2.codVenta
                            GROUP BY v2.fecha
                        ) AS subQuery
                    )
                """;
        LocalDate localDate = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                localDate = rs.getDate("fecha").toLocalDate();
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el mejor día de ventas: " + e.getMessage());
        }

        return localDate;
    }

    public HashMap<String, Integer> getTotalSalesByGenre() {
        String query = """
                select sum(de.cantidad) sales, v.genero
                from
                    DetalleVenta de
                    join Ventas ve on de.codVenta = ve.idVenta
                    join Videojuegos v on de.codVideojuego = v.idVideojuego
                group by
                    v.genero
                """;
        HashMap<String, Integer> salesByGenre = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String genre = rs.getString("genero");
                int sales = rs.getInt("sales");
                salesByGenre.put(genre, sales);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las ventas por género: " + e.getMessage());
        }
        return salesByGenre;
    }

    public HashMap<String, Integer> getTotalSalesByPlatform() {
        String query = """
                select sum(de.cantidad) sales, v.plataforma
                from
                    DetalleVenta de
                    join Ventas ve on de.codVenta = ve.idVenta
                    join Videojuegos v on de.codVideojuego = v.idVideojuego
                group by
                    v.genero
                """;
        HashMap<String, Integer> salesByPlatform = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String platform = rs.getString("plataforma");
                int sales = rs.getInt("sales");
                salesByPlatform.put(platform, sales);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las ventas por plataforma: " + e.getMessage());
        }
        return salesByPlatform;
    }

}
