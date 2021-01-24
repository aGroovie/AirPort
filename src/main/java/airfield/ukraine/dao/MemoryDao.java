package airfield.ukraine.dao;


import airfield.ukraine.entity.Passenger;

import java.util.Collection;

public interface MemoryDao {
    int savePassenger(Passenger passenger);
     Collection<Passenger> getPassengers();


}
