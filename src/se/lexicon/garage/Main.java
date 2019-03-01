package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserInterface ui = new UserInterface(new Garage());
        ui.parkVehicle();

/*
        ArrayList<Vehicle> vehicles = MySQLConnection.getVehiclesDB();

        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getBrand());
        }

        MySQLConnection.addVehicle(new Car("VolksWagen", 160));

        vehicles = MySQLConnection.getVehiclesDB();
        System.out.println();

        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getBrand());
        }
*/
//        Garage garage = new Garage();
 //       for (int i = 0; i < 5; i++) {
 //           garage.park(new Car("Volvo"));
 //       }
//        System.out.println(garage.find(0));
//        System.out.println(garage);
//        garage.unpark(0);
//        UserInterface ui = new UserInterface(garage);
    }
}
