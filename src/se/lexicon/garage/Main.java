package se.lexicon.garage;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage();

        for(int i=0; i<5; i++) {
            garage.park(new Car("Volvo"));
        }

        System.out.println(garage.find(0));

        System.out.println(garage);

        garage.unpark(0);

        UserInterface ui = new UserInterface(garage);
    }
}
