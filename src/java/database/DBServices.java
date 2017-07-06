package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBServices {
    public static Connection getConnection() throws SQLException {

        Connection con = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "postgres");
        connectionProps.put("password", "123qwe");
        
        String url = "jdbc:postgresql://localhost:5432/marketcat";

        con = DriverManager.getConnection(url, connectionProps);
        System.out.println("Connected to database");
        return con;
    }
}
