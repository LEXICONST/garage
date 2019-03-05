package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void setParkingLot() {
        Car testCar1 = new Car("Olivette", 380);
        testCar1.setParkingLot(30);
        assertEquals(30, testCar1.getParkingLot());
    }
}