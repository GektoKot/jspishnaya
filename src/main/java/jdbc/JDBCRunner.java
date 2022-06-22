package jdbc;

import org.postgresql.Driver;

import java.sql.*;

public class JDBCRunner {

    public static void main(String[] args){
        Class<Driver> driverClass = Driver.class;

        try (Connection connection = ConnectionManager.connect()) {

            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
