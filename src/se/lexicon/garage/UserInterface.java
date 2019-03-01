package se.lexicon.garage;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Garage garage;

    private Scanner scanner = new Scanner(System.in);

    public UserInterface(Garage garage){
        this.garage = garage;

    }

    public void runMenu(){
        System.out.println("Hello World! Welcome to Glade Grannens Garage!");
    }

    public void parkVehicle() throws SQLException{
        System.out.println("What type of vehicle is it?: ");
        String type = scanner.nextLine();
        if(type.equalsIgnoreCase("car")){
            parkCar();
        }
    }

    public void parkCar() throws SQLException {
        System.out.print("Maker please: ");
        String maker = scanner.nextLine();
        System.out.print("Top speed please: ");
        int topSpeed = scanner.nextInt();
        Car car = new Car(maker, topSpeed);
        garage.park(car);
        System.out.println("Car parked in garage!");

        MySQLConnection.addVehicle(car);
    }

    public void findVehicle(){

    }

    public void unparkVehicle(){

    }

    public void showAllVehiclesInGarage(){

    }

}
