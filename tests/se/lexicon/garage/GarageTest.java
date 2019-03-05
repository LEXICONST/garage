package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    @Test
    void park() throws SQLException {
        Garage testGarage = new Garage();
        Car testCar1 = new Car("Magnus Motors", 237);
        int parkingTicket = testGarage.park(testCar1);
        assertEquals(testCar1, testGarage.getVehicles().get(parkingTicket));
    }

    @Test
    void find() {
    }

    @Test
    void unpark() {
    }

    @Test
    void getVehicles() {
    }

    @Test
    void getVehiclesWithLots() {
    }

    @Test
    void toStringTest() {
    }
}