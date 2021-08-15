package repository;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public User getById(int id){
        String sql = "SELECT * FROM users WHERE user_id = " + id;
        User user = new User();
        try (Connection connection = Util.getConnection();
             PreparedStatement statementUser = connection.prepareStatement(sql)) {

            ResultSet resultSet = statementUser.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }


    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = Util.getConnection();
             PreparedStatement statementUser = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            ResultSet resultSet = statementUser.executeQuery();
            if (resultSet == null) {
                return null;
            } else {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setAge(resultSet.getInt("age"));
                    users.add(user);

                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement ERROR");
        }
        return users;
    }

    public void save(User user) {
        String sql = "INSERT INTO users(first_name, last_name, age) VALUES ('"
                + user.getFirstName() + "' , '" + user.getLastName() + "' , " + user.getAge() + ")";
        try (Connection connection = Util.getConnection();
             PreparedStatement statementUser = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            statementUser.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement ERROR");
        }
    }

    public void update(User user){
        String sql = "UPDATE users SET first_name = '" + user.getFirstName() + "' , last_name = '" +
                user.getLastName() + "', age = " + user.getAge() +  " WHERE user_id = " + user.getId();
        try (Connection connection = Util.getConnection();
             PreparedStatement statementUser = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            statementUser.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement ERROR");
        }
    }

    public void deleteById(int id){
        String sql = "DELETE FROM users WHERE user_id = " + id;
        try (Connection connection = Util.getConnection();
             PreparedStatement statementUser = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            statementUser.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement ERROR");
        }
    }
}
