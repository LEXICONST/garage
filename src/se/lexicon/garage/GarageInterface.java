package se.lexicon.garage;

import java.sql.SQLException;

public interface GarageInterface<V> {

    int park(V vehicle) throws SQLException;

    V find(int parkingLot);

    V unpark(int parkingLot);

    @Override
    String toString();

}
