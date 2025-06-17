package com.yearup.dealership.db;
import com.yearup.dealership.models.Vehicle;

import com.mysql.cj.protocol.Resultset;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;



    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void addVehicle(Vehicle vehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO vehicles (vin, make, model, year, sold, color, vehicleType, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")
        ) {
            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setBoolean(5, vehicle.isSold());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setString(7, vehicle.getVehicleType());
            preparedStatement.setInt(8, vehicle.getOdometer());
            preparedStatement.setDouble(9, vehicle.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void removeVehicle(String VIN) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ("DELETE FROM vehicles WHERE vin = ?"))){
            preparedStatement.setString(1,VIN);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                Vehicle vehicle =  new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));
                vehicles.add(vehicle);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM vehicles WHERE make LIKE ? AND model LIKE ?")) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle =  new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
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
                Vehicle vehicle =  new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));
                vehicles.add(vehicle);
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
                     connection.prepareStatement("SELECT * FROM vehicles WHERE color LIKE ?")) {
            preparedStatement.setString(1, color);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle =  new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
          List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM vehicles WHERE odometer > ? AND odometer < ?")) {

            preparedStatement.setDouble(1, minMileage);
            preparedStatement.setDouble(2, maxMileage);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle =  new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
    public List<Vehicle> searchByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM vehicles WHERE vehicleType LIKE ?")) {
            preparedStatement.setString(1,type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle =  new Vehicle();
                vehicle.setVin(resultSet.getString("VIN"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setSold(resultSet.getBoolean("SOLD"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setVehicleType(resultSet.getString("vehicleType"));
                vehicle.setOdometer(resultSet.getInt("odometer"));
                vehicle.setPrice(resultSet.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
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
