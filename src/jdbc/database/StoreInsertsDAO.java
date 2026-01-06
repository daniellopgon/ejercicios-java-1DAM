package jdbc.database;

import jdbc.business.Customer;
import jdbc.business.Sale;
import jdbc.business.VideoGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreInsertsDAO {
    private final static String URL = "jdbc:mariadb://localhost:3306/Tienda";
    private final static String USER = "dani";
    private final static String PASSWD = "";

    public void insertSale(Sale sale) {
        String insertSaleQuery = "INSERT INTO Ventas(idVenta, fecha, codCliente) VALUES (?, ?, ?)";
        String insertDetailQuery = "INSERT INTO DetalleVenta(codVenta, codVideojuego, cantidad) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD)) {
            connection.setAutoCommit(false);

            try (PreparedStatement psSale = connection.prepareStatement(insertSaleQuery);
                    PreparedStatement psDetail = connection.prepareStatement(insertDetailQuery)) {

                psSale.setLong(1, sale.getSaleId());
                psSale.setDate(2, java.sql.Date.valueOf(sale.getSaleDate()));
                psSale.setLong(3, sale.getCustomer().getCustomerId());
                psSale.executeUpdate();

                for (VideoGame vg : sale.getVideoGames()) {
                    psDetail.setLong(1, sale.getSaleId());
                    psDetail.setLong(2, vg.getId());
                    psDetail.setInt(3, vg.getQuantity());
                    psDetail.executeUpdate();
                }

                connection.commit();
                System.out.println("Venta insertada correctamente.");

            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Error en inserción de venta. Rollback ejecutado: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error en conexión o transacción: " + e.getMessage());
        }
    }

    public void insertVideoGame(VideoGame videoGame) {
        String insertVideoGameQuery = "INSERT INTO Videojuegos (idVideojuego,titulo,plataforma,genero,precio,stock) " +
                " VALUES(?,?,?,?,?,?) ";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWD);
            connection.setAutoCommit(false);
            System.out.println("Conexión exitosa a la base de datos");

            PreparedStatement psVideoGame = connection.prepareStatement(insertVideoGameQuery);
            psVideoGame.setLong(1, videoGame.getId());
            psVideoGame.setString(2, videoGame.getTitle());
            psVideoGame.setString(3, videoGame.getPlatform());
            psVideoGame.setString(4, videoGame.getGenre());
            psVideoGame.setDouble(5, videoGame.getPrice());
            psVideoGame.setInt(6, videoGame.getQuantity());
            int affectedRows = psVideoGame.executeUpdate();
            System.out.println("Filas afectadas" + affectedRows);

            connection.commit();
            System.out.println("Filas insertadas correctamente");
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar el videojuego " + e.getMessage());
            try {
                assert connection != null;
                connection.rollback();
                connection.close();
            } catch (SQLException rollBackException) {
                System.out.println("Error al realizar el rollBack del Videojuego");
            }

        }
    }

    public void insertCustomer(Customer customer) {
        String insertCustomerQuery = "INSERT INTO Clientes(idCliente, nombre, mail) " +
                " VALUES( ?,?,? ) ";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWD);
            connection.setAutoCommit(false);
            PreparedStatement psCustomer = connection.prepareStatement(insertCustomerQuery);

            psCustomer.setLong(1, customer.getCustomerId());
            psCustomer.setString(2, customer.getName());
            psCustomer.setString(3, customer.getEmail());
            int affectedRows = psCustomer.executeUpdate();
            System.out.println("Filas afectadas" + affectedRows);

            connection.commit();
            System.out.println("Se ha guardado correctamente");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente" + e.getMessage());
            try {
                assert connection != null;
                connection.rollback();
                connection.close();
            } catch (SQLException rollBackException) {
                System.out.println("Error en el rollback de Cliente");
            }
        }

    }
}
