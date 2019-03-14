package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a garage. The users can park different types of vehicles. E.g. cars and boats.
 * The garage utilizes MySQL for data storage.
 * @author Systemtestarna 2019
 * @version 0.1
 */

public class Garage implements GarageInterface<Vehicle> {

    /**
     * This field sets the maximum capacity for the garage
     */
    public static final int MAX_PARKING_LOT_NUMBER = 72;

    /**
     * Initialization of the HashMap holding the vehicles.
     */
    private Map<Integer, Vehicle> vehicles = new HashMap<>(MAX_PARKING_LOT_NUMBER);
    //initieringsblock
    {
        for(int i=0; i<72; i++){
            vehicles.put(i+1, new EmptyVehicle());
        }
    }

    /**
     * When a new Garage is instantiated without arguments the vehicles in the garage from the last session will be loaded from the MySQL database.
     * @throws SQLException will be thrown if database connection fails.
     */
    public Garage() throws SQLException {
        setVehicles();
    }

    /**
     * Parks a vehicle in the garage. The method parks the vehicle at the first encountered empty lot.
     * @param vehicle The vehicle to be parked in the garage.
     * @return the lotnumber of the parked vehicle.
     * @throws SQLException if the program fails to make a connection to the MySQL database.
     */
    public int park(Vehicle vehicle) throws SQLException{
        int lotNumber = -1;

        for(int i = 1; i<=72; i++){
            /*
            if(vehicles.get(i) instanceof EmptyVehicle){
                vehicles.put(i, vehicle);
                vehicle.setParkingLot(i);
                MySQLConnection.saveVehicleDB(vehicle);
                return i;
            }
            */
            if(vehicles.get(i) == null){
                vehicles.put(i, vehicle);
                vehicle.setParkingLot(i);
                MySQLConnection.saveVehicleDB(vehicle);
                return i;
            }
        }
        return lotNumber;
    }

    /**
     * Returns the vehicle parked at the parking lot given as argument.
     * @param parkingLot The parking lot number.
     * @return a reference to the Vehicle parked at the given parking lot.
     * @throws NullPointerException if there is no vehicle parked at the given parking lot.
     */
    public Vehicle find(int parkingLot) throws NullPointerException{
        if(vehicles.get(parkingLot) != null)
            return vehicles.get(parkingLot);
        else{
            throw new NullPointerException("There is no vehicle parked at lot nr "+parkingLot);
        }
    }


    public Vehicle unpark(int parkingLot){
        Vehicle temp = vehicles.get(parkingLot);
        vehicles.put(parkingLot, new EmptyVehicle());
        return temp;
    }

    public void setVehicles() throws SQLException{
        vehicles = MySQLConnection.getVehiclesDB();
    }

    public Map<Integer, Vehicle> getVehicles(){
        return vehicles;
    }

    public String toString() {
        String output = "";

        for(int i=1; i<=72; i++){
            output += "Lot nr "+i + " : " + vehicles.get(i)+"\n";
        }
        return output;
    }
}
