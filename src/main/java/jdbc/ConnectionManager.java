package jdbc;

import utils.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    public static final String URL = "db.url";
    public static final String USER = "db.username";
    public static final String PASSWORD = "db.password";

    private ConnectionManager (){
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL),
                    PropertiesUtil.get(USER),
                    PropertiesUtil.get(PASSWORD));
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
