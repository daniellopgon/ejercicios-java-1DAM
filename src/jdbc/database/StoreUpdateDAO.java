package jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreUpdateDAO {
    private final String URL = "jdbc:mariadb://localhost:3306/Tienda";
    private final String USER = "dani";
    private final String PASSWD = "";

    public void updateStock(int stock, Long videoGameId) {
        String updateStockQuery = """
                update Videojuegos
                set stock = stock - ?
                where idVideojuego = ?
                """;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD)) {

            PreparedStatement ps = connection.prepareStatement(updateStockQuery);

            ps.setInt(1, stock);
            ps.setLong(2, videoGameId);

            int affectedRows = ps.executeUpdate();

            System.out.println("Filas afectadas en venta: " + affectedRows);

        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock" + e.getMessage());
        }

    }
}
