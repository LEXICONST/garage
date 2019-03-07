package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MySQLConnectionTest {

    @Test
    void getVehiclesDB() throws SQLException{

        Map<Integer, Vehicle> vehicles = MySQLConnection.getVehiclesDB();

        Car car = (Car)vehicles.get(8);
        assertEquals("VolksWagen", car.getMake());
        assertEquals(160, car.getTopSpeed());
    }

    @Test
    void saveVehicleDB() throws SQLException {
        Car testCar1 = new Car("Mickebitzu", 250);
        MySQLConnection.saveVehicleDB(testCar1);
        Map<Integer, Vehicle> testVehicles = MySQLConnection.getVehiclesDB();
        assertEquals(testCar1.getMake(), testVehicles.get(testVehicles.size()-1).getMake());
    }

}