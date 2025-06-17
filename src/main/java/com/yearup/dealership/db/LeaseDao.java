package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;
import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO lease_contracts (contract_id, VIN, lease_start, lease_end, monthly_payment) VALUES (?, ?, ?, ?, ?)")
        ) {
            preparedStatement.setInt(1, leaseContract.getContractId());
            preparedStatement.setString(2, leaseContract.getVin());
            preparedStatement.setDate(3, java.sql.Date.valueOf(leaseContract.getLeaseStart()));
            preparedStatement.setDate(4, java.sql.Date.valueOf(leaseContract.getLeaseEnd()));
            preparedStatement.setDouble(5, leaseContract.getMonthlyPayment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





    }

