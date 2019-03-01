package se.lexicon.garage;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnection {

    public static ArrayList<Vehicle> getVehiclesDB() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "caSandRa2!");
            System.out.println("Connected to sakila database!");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery("SELECT * FROM vehicle");


            while (rs.next()) {
                if (rs.getString("type").equals("car")) {
//                    System.out.println(rs.getString("maker"));
                    Car temp = new Car(rs.getString("maker"));
                    vehicles.add(temp);
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
    }//

    public static void addVehicle(Vehicle vehicle) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        String maker = vehicle.getBrand();
        int topSpeed = 0;
        String type = "";

        if(vehicle instanceof Car){
            Car temp = (Car)vehicle;
            topSpeed = temp.getTopSpeed();
            type = "car";
        }

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "caSandRa2!");

            pstmt = conn.prepareStatement("INSERT INTO vehicle (maker, top_speed, type) VALUES(?, ?, ?)");

            pstmt.setString(1, maker);
            pstmt.setInt(2, topSpeed);
            pstmt.setString(3, type);
            pstmt.executeUpdate();

        }catch (SQLException e){

        }
        finally{
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    /*
    public static void addVehicle(Vehicle vehicle) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean setEmpty = false;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "caSandRa2!");
            System.out.println("Connected to sakila database!");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery("SELECT * FROM vehicle");

            if (vehicle instanceof Car) {
                Car tempCar = (Car) vehicle;
                rs.afterLast();
                stmt.executeUpdate("Insert Into vehicle(maker, top_speed, type) values(\'" + tempCar.getBrand() + "\', \'"
                        + tempCar.getTopSpeed() + "\', \'car\')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

    }
*/
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "caSandRa2!");
            System.out.println("Connected to sakila database!");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM sakila.city LIMIT 10");

            while (rs.next()) {
                System.out.println(rs.getString("city"));
            }
            System.out.println("***********************************");
            rs.beforeFirst();

            while (rs.next()) {
                if (rs.getString("city").equals("Acua")) {
                    rs.updateString("city", "Aqua");
                    rs.updateRow();
                    System.out.println(rs.getString("city"));
                } else {
                    System.out.println(rs.getString("city"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

    }

}










