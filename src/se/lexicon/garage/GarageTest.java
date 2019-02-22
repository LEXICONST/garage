package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    @Test
    void unpark(){
        Garage testGarage = new Garage();

        Car testCar0 = new Car("testZero");
        Car testCar1 = new Car("testOne");
        Car testCar2 = new Car("testTwo");
        Car testCar3 = new Car("testThree");

        int ticket0 = testGarage.park(testCar0);
        int ticket1 = testGarage.park(testCar1);
        int ticket2 = testGarage.park(testCar2);
        int ticket3 = testGarage.park(testCar3);

        testGarage.unpark(ticket1);
        assertEquals(testGarage.find(ticket2), testCar2);
    }

    @Test
    void park() {
        Garage testGarage = new Garage();
        Car testCar = new Car("Mäscha");
        assertEquals(72, testGarage.getVehicles().size());
        testGarage.park(testCar);
        assertEquals(72, testGarage.getVehicles().size());
    }

    @Test
    void find(){
        Garage testGarage = new Garage();

        Car testCar0 = new Car("testZero");
        Car testCar1 = new Car("testOne");
        Car testCar2 = new Car("testTwo");
        Car testCar3 = new Car("testThree");

        int ticket0 = testGarage.park(testCar0);
        int ticket1 = testGarage.park(testCar1);
        int ticket2 = testGarage.park(testCar2);
        int ticket3 = testGarage.park(testCar3);

        testGarage.unpark(ticket1);

        Vehicle find3 = testGarage.find(ticket3);

        assertEquals(find3, testCar3);

    }



}