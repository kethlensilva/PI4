package com.laraconchego.dao;

import com.laraconchego.config.ConnectionPoolConfig;
import com.laraconchego.model.Login;

import java.sql.*;

public class LoginDao {

    public boolean verifyCredentials(Login login) {

        String SQL = "SELECT * FROM LOGIN WHERE USERNAME = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, login.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Success in selecting username");

            while (resultSet.next()) {

                String password = resultSet.getString("password");

                if (password.equals(login.getPassword())) {
                    return true;
                }
            }

            return false;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
