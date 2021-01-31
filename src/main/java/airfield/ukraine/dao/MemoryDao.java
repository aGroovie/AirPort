package airfield.ukraine.dao;


import airfield.ukraine.entity.Company;
import airfield.ukraine.entity.Passenger;
import airfield.ukraine.entity.Quantity;
import airfield.ukraine.entity.Ticket;

import java.util.Collection;
import java.util.List;

public interface MemoryDao {
    int savePassenger(Passenger passenger);

    Collection<Passenger> getPassengers();

    List<Ticket> findTicketInfoByName(String firstName, String lastName);

    List<Company> getCompaniesByRating();

    List<Company> getCompaniesByCountryName(String countryName);

    List<Quantity> getQuantityOfTrips(String dateFrom, String dateTo, String countryName);
}
