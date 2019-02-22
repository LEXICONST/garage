package se.lexicon.garage;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.park(new Car("Volvo"));
        System.out.println(garage.find(0));
        System.out.println(garage.toString());
        garage.unpark(0);
        UserInterface ui = new UserInterface(garage);
    }
}
