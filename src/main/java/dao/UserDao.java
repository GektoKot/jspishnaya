package dao;

import entity.Hobby;
import entity.Pet;
import entity.User;
import jdbc.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements UserDaoIF{

    @Override
    public Optional<User> findById(String id) throws SQLException {
        String sql = """
                select * from app_user where user_id = ?;
                """;

        int user_id = 0;
        String name = "";
        String surname = "";
        List<Pet> pets = new ArrayList<>();
        List<Hobby> groups = new ArrayList<>();

        try (Connection connection = ConnectionManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user_id = resultSet.getInt("user_id");
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");

            }
        }
        return Optional.of(new User(user_id, name, surname));
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = """
                select * from app_user;
                """;
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");


                User user = new User(user_id, name, surname);
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public boolean save(User user) throws SQLException {
        String sql = """
                insert into app_user (name, surname, age) values (?,?) ;
                """;
        boolean saved;

        try (Connection connection = ConnectionManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            saved = statement.executeUpdate() > 0;
        }
        return saved;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = """
                update users_table set name = ?, surname = ? where user_id = ?;
                """;
        boolean updated;

        try (Connection connection = ConnectionManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(4, user.getId());
            updated = statement.executeUpdate() > 0;
        }
        return updated;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = """
                delete from app_user where user_id = ?;
                """;
        boolean deleted;

        try (Connection connection = ConnectionManager.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getId());
            deleted = statement.executeUpdate() > 0;
        }
        return deleted;
    }
}
