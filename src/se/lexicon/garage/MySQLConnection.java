package se.lexicon.garage;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySQLConnection {

    public static void main(String[] args){

    }

    public static Map<Integer, Vehicle> getVehiclesDB() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Map<Integer, Vehicle> vehicles = new HashMap<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "caSandRa2!");
            System.out.println("Connected to sakila database!");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery("SELECT * FROM vehicle");

            while (rs.next()) {
                if (rs.getString("type").equals("car")) {
//                    System.out.println(rs.getString("maker"));
                    Car temp = new Car(rs.getString("make"), rs.getInt("top_speed"), rs.getInt("parking_lot"));
                    vehicles.put(rs.getInt("parking_lot"), temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return vehicles;
    }

    public static void saveVehicleDB(Vehicle vehicle) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String maker = vehicle.getMake();
        int topSpeed = 0;
        String type = "";
        int parkingLot = vehicle.getParkingLot();

        if (vehicle instanceof Car) {
            Car temp = (Car) vehicle;
            topSpeed = temp.getTopSpeed();
            type = "car";
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "caSandRa2!");

            pstmt = conn.prepareStatement("INSERT INTO vehicle (maker, top_speed, type, parking_lot) VALUES(?, ?, ?, ?)");

            pstmt.setString(1, maker);
            pstmt.setInt(2, topSpeed);
            pstmt.setString(3, type);
            pstmt.setInt(4, parkingLot);
            pstmt.executeUpdate();

        } catch (SQLException e) {

        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
}










