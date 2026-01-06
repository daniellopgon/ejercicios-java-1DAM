package jdbc.database;

import jdbc.business.Customer;
import jdbc.business.VideoGame;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StoreSelectsDAO {
    private final static String URL = "jdbc:mariadb://localhost:3306/Tienda";
    private final static String USER = "dani";
    private final static String PASSWD = "";

    public int getStockByTitle(String title) {
        String query = """
                select v.stock
                from Videojuegos v
                where lower(v.titulo) like ?
                """;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + title.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int stock = rs.getInt("stock");
                return stock;
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar el stock: " + e.getMessage());
        }
        return 0;
    }

    public VideoGame findByTitle(String title) {
        String query = """
                select *
                from Videojuegos v
                where lower(v.titulo) like ?
                """;

        VideoGame videoGame = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + title.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                videoGame = new VideoGame(
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getLong("idVideojuego"));
                return videoGame;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el videojuego: " + e.getMessage());
        }
        return videoGame;
    }

    public VideoGame findById(int videoGameId) {
        String query = """
                select *
                from Videojuegos v
                where v.idVideojuego = ?
                """;

        VideoGame videoGame = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, videoGameId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                videoGame = new VideoGame(
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getLong("idVideojuego"));
                return videoGame;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el videojuego: " + e.getMessage());
        }
        return videoGame;
    }

    public Customer findByName(String name) {
        String query = """
                select *
                from Clientes c
                where lower(c.nombre) like ?
                """;

        Customer customer = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + name.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("direccion"),
                        rs.getString("mail"),
                        rs.getLong("idCliente"));
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el inventario: " + e.getMessage());
        }
        return customer;
    }

    public Customer findBySurname(String surname) {
        String query = """
                select *
                from Clientes c
                where lower(c.apellidos) like ?
                """;

        Customer customer = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + surname.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("direccion"),
                        rs.getString("mail"),
                        rs.getLong("idCliente"));
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el cliente: " + e.getMessage());
        }
        return customer;
    }

    public Customer findByEmail(String email) {
        String query = """
                select *
                from Clientes c
                where lower(c.mail) like ?
                """;

        Customer customer = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + email.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("direccion"),
                        rs.getString("mail"),
                        rs.getLong("idCliente"));
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el cliente: " + e.getMessage());
        }
        return customer;
    }

    public ArrayList<VideoGame> getInventory() {
        String query = "SELECT * FROM Videojuegos";
        ArrayList<VideoGame> inventory = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement psInventory = connection.prepareStatement(query);
                ResultSet rs = psInventory.executeQuery()) {

            while (rs.next()) {
                VideoGame videoGame = new VideoGame(
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getLong("idVideojuego"));
                inventory.add(videoGame);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el inventario: " + e.getMessage());
        }

        return inventory;
    }

    public ArrayList<Object[]> getSalesHistory() {
        String query = """
                    SELECT ve.fecha, c.nombre, de.cantidad, v.titulo
                    FROM
                        DetalleVenta de
                        JOIN Ventas ve ON de.codVenta = ve.idVenta
                        JOIN Clientes c ON c.idCliente = ve.codCliente
                        JOIN Videojuegos v ON v.idVideojuego = de.codVideojuego
                """;

        ArrayList<Object[]> history = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] row = {
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("nombre"),
                        rs.getInt("cantidad"),
                        rs.getString("titulo")
                };
                history.add(row);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener historial de ventas: " + e.getMessage());
        }

        return history;
    }

    public ArrayList<Object[]> getSalesHistoryByDate(LocalDate date) {
        String query = """
                    SELECT ve.fecha, c.nombre, de.cantidad, v.titulo
                    FROM
                        DetalleVenta de
                        JOIN Ventas ve ON de.codVenta = ve.idVenta
                        JOIN Clientes c ON c.idCliente = ve.codCliente
                        JOIN Videojuegos v ON v.idVideojuego = de.codVideojuego
                    WHERE ve.fecha = ?
                """;

        ArrayList<Object[]> history = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDate(1, Date.valueOf(date));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                            rs.getDate("fecha").toLocalDate(),
                            rs.getString("nombre"),
                            rs.getInt("cantidad"),
                            rs.getString("titulo")
                    };
                    history.add(row);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener historial de ventas: " + e.getMessage());
        }

        return history;
    }

}
