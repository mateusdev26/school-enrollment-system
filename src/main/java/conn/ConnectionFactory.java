package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        final String user= "root";
        final String url = "jdbc:mysql://localhost:3306/school";
        final String password = "ASD123as";
        return DriverManager.getConnection(url,user,password);
    }



}
