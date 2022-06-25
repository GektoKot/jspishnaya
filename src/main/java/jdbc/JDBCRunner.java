package jdbc;

import dao.UserDao;
import entity.User;
import org.postgresql.Driver;

import java.sql.*;

public class JDBCRunner {

    public static void main(String[] args){
        Class<Driver> driverClass = Driver.class;

        try (Connection connection = ConnectionManager.connect();
             Statement statement = connection.createStatement()) {
            String sql = """
                    SELECT * FROM users_table where user_id = 1;
                    """;
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                System.out.println(resultSet.getInt("user_id") + " "
                        + resultSet.getString("name") + " "
                        + resultSet.getString("surname") + " "
                        + resultSet.getInt("age"));
            }

            User user = new UserDao().findById("1").orElseThrow();

            System.out.println(user);

            System.out.println(connection.getSchema());
            System.out.println(connection.getMetaData());
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
