package se.lexicon.garage;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Garage garage = new Garage();

 //       for (int i = 0; i < 5; i++) {
 //           garage.park(new Car("Volvo"));
 //       }

//        System.out.println(garage.find(0));

        System.out.println(garage);

//        garage.unpark(0);

        UserInterface ui = new UserInterface(garage);
    }
}
