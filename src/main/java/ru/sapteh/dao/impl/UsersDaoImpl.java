package ru.sapteh.dao.impl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements Dao <Users, Long>  {
    private final Connection connection;

    public UsersDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public Users findById(Long id) {
        String sql = "SELECT * FROM users WHERE id=?";
        Users users = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                users = new Users(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        List<Users> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                users.add(
                        new Users(
                  resultSet.getLong("id"),
                  resultSet.getString("first_name"),
                  resultSet.getString("last_name")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(Users users) {
        String sql = "INSERT INTO users (first_name, last_name) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, users.getFirstName());
            statement.setString(2, users.getLastName());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Save success" : "Save failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users users) {
        String sql = "UPDATE users SET first_name=?, last_name=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, users.getFirstName());
            statement.setString(2, users.getLastName());
            statement.setLong(3,users.getId());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Update success" : "Update failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Delete success" : "Delete failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
