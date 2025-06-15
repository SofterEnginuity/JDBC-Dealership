package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // TODO: Implement the logic to add a vehicle to the inventory


            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement(
                                 "insert into country (country) values (?);");
            ) {
// set the parameter
                preparedStatement.setString(1, "Eritrea");
// execute the query
                int rows = preparedStatement.executeUpdate();
                System.out.printf("Rows updated %d\n", rows);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory
    }
}
