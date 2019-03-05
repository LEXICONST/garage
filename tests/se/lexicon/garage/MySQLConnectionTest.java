package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MySQLConnectionTest {

    @Test
    void getVehiclesDB() {
    }

    @Test
    void saveVehicleDB() throws SQLException {
        Car testCar1 = new Car("Mickebitzu", 250);
        MySQLConnection.saveVehicleDB(testCar1);
        ArrayList<Vehicle> testVehicles = MySQLConnection.getVehiclesDB();
        assertEquals(testCar1.getMake(), testVehicles.get(testVehicles.size()-1).getMake());

    }
}