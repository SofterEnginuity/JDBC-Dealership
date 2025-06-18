package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;
import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO lease_contracts (VIN, lease_start, lease_end, monthly_payment) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, leaseContract.getVin());
            preparedStatement.setDate(2, java.sql.Date.valueOf(leaseContract.getLeaseStart()));
            preparedStatement.setDate(3, java.sql.Date.valueOf(leaseContract.getLeaseEnd()));
            preparedStatement.setDouble(4, leaseContract.getMonthlyPayment());
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    }

