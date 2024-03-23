import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMariaDB {

    static Connection getConnection() throws SQLException {
         String url = "jdbc:mariadb://127.0.0.1/carpinteria";
        String username = "root";
        String password = "1111";

        return DriverManager.getConnection(url, username, password);
    }
}

    

