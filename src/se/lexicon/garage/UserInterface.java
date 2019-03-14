package se.lexicon.garage;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private static Garage garage;

    private static Scanner scanner = new Scanner(System.in);

    public UserInterface(Garage garage) {
        this.garage = garage;
    }

    public static void runMenu() throws SQLException {

        String input = "";
        int intInput = 0;
        System.out.println("Hello World! Welcome to Glade Grannens Garage!");

        do {
            System.out.println("Vad vill du göra?\n" +
                    "1: Parkera ett fordon\n" +
                    "2: Hämta ett fordon\n" +
                    "3: Visa alla parkerade fordon\n" +
                    "4: Avsluta");

            //Övning i att kasta till int
            input = scanner.nextLine();
            try{
                intInput = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Du måste ange ett heltal!");
            }

        }while(true);

    }

    public void parkVehicle() throws SQLException {
        System.out.println("What type of vehicle is it?: ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("car")) {
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

        MySQLConnection.saveVehicleDB(car);
    }

    public void findVehicle() {

    }

    public void unparkVehicle() {

    }

    public void showAllVehiclesInGarage() {

    }

}
