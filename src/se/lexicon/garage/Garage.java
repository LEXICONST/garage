package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Garage implements GarageInterface<Vehicle> {

    public static final int MAX_PARKING_LOT_NUMBER = 72;
    private Map<Integer, Vehicle> vehicles = new HashMap<>(MAX_PARKING_LOT_NUMBER);
    //initieringsblock
    {
        for(int i=0; i<72; i++){
            vehicles.put(i+1, new EmptyVehicle());
        }
    }

    public Garage() throws SQLException {
        //vehicles = MySQLConnection.getVehiclesDB();
        for(int i=1; i<=72; i++){
            vehicles.put(i, new EmptyVehicle());
        }
    }

    public int park(Vehicle vehicle) throws SQLException{
        int lotNumber = -1;

        for(int i = 1; i<=72; i++){
            if(vehicles.get(i) instanceof EmptyVehicle){
                vehicles.put(i, vehicle);
                vehicle.setParkingLot(i);
                MySQLConnection.saveVehicleDB(vehicle);
                return i;
            }
        }
        return lotNumber;
    }

    public Vehicle find(int parkingLot){
        return vehicles.get(parkingLot);
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
