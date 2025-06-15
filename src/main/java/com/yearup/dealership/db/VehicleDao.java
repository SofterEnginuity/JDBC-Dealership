package com.yearup.dealership.db;

import com.mysql.cj.protocol.Resultset;
import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// private Vehicle vehicle;
public class VehicleDao {
    private DataSource dataSource;



    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {

        // TODO: Implement the logic to add a vehicle
    }

    public void removeVehicle(String VIN) {
        // TODO: Implement the logic to remove a vehicle
    }


    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM vehicles WHERE price >= ? AND price <= ?")) {

            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                System.out.printf("Vehicle: make=%s, model=%s, price=%.2f\n", make, model, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }


    public List<Vehicle> searchByMakeModel(String make, String model) {
        // TODO: Implement the logic to search vehicles by make and model
        return new ArrayList<>();
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM vehicles WHERE year >= ? AND year <= ?")) {

            preparedStatement.setDouble(1, minYear);
            preparedStatement.setDouble(2, maxYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                int year = resultSet.getInt("year");

                System.out.printf("Vehicle: make=%s, model=%s, price=%.2f\n", make, model, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM vehicles WHERE color LIKE = ?")) {

            preparedStatement.setString(1, color);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                int year = resultSet.getInt("year");

                System.out.printf("Vehicle: make=%s, model=%s, price=%.2f\n", make, model, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        // TODO: Implement the logic to search vehicles by mileage range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByType(String type) {
        // TODO: Implement the logic to search vehicles by type
        return new ArrayList<>();
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
