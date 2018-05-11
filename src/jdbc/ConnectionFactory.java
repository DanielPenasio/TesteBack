package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel Penasio
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/ValeMobi", "root", "12345");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
