package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;
import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO sales_contracts (VIN,sale_date,price) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)
        ) {

            preparedStatement.setString(1, salesContract.getVin());
            preparedStatement.setDate(2, java.sql.Date.valueOf(salesContract.getSaleDate()));
            preparedStatement.setDouble(3, salesContract.getPrice());
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
