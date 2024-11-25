package com.laraconchego.dao;

import com.laraconchego.config.ConnectionPoolConfig;
import com.laraconchego.model.Lar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.h2.util.ParserUtil.FROM;

public class LarDao {
    public void createLar(Lar lar) {
        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();;

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, lar.getName());
            preparedStatement.execute();

            System.out.println("success in insert user");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }
    public List<Lar> findAllCars() {

        String SQL = "SELECT * FROM LARACONCHEGO";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Lar> lars = new ArrayList<>();

            while (resultSet.next()) {

                String larId = resultSet.getString("id");
                String larName = resultSet.getString("name");

                Lar lar = new Lar(larId, larName);

                lars.add(lar);

            }


            System.out.println("success in select * car");

            connection.close();

            return lars;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }
    public void deleteLarById(String larId) {

        String SQL = "DELETE LAR WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, larId);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + larId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }
    public void updateLar(Lar lar) {

        String SQL = "UPDATE CAR SET NAME = ? WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, lar.getName());
            preparedStatement.setString(2, lar.getId());
            preparedStatement.execute();

            System.out.println("success in update car");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }

    }

}
