package airfield.ukraine.dao;

import airfield.ukraine.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


//Saving /retrieving  data into DB

@Repository
public class MemoryDaoImpl implements MemoryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Collection<Passenger> getPassengers() {

        return jdbcTemplate.query("SELECT * FROM airport.passenger", (resultSet, i) -> {
            Passenger passenger = new Passenger();
            passenger.setPassengerId(resultSet.getLong(1));
            passenger.setFirstName(resultSet.getString(2));
            passenger.setLastName(resultSet.getString(3));
            return passenger;

        });
    }

    public List<Ticket> findTicketInfoByName(String firstName, String lastName) {


        String SELECT_BY_NAMES = "SELECT  ticket_id,  passenger_fname, passenger_sname, ticket_gate, t2.airport_country AS coutry_from,\n" +
                " t2.airport_city AS city_from , t3.airport_country AS country_to, t3.airport_city AS city_to, trip_time_out, company_name,\n" +
                " seat_num, seat_raw, seat_class FROM ticket\n" +
                "INNER JOIN passenger\n" +
                "ON ticket_passenger = passenger_id\n" +
                "\n" +
                "INNER JOIN trip t1\n" +
                "ON ticket_trip_id = trip_id\n" +
                "\n" +
                "INNER JOIN airport t2 \n" +
                "ON trip_from = t2.airport_id\n" +
                "\n" +
                "INNER JOIN airport t3\n" +
                "ON trip_to = t3.airport_id\n" +
                "\n" +
                "INNER JOIN company \n" +
                "ON ticket_company = company_id\n" +
                "\n" +
                "INNER JOIN seat\n" +
                "ON seat_num =  ticket_seat_num\n" +
                "\n" +
                "WHERE passenger_fname = '" + firstName + "' AND\n" +

                "passenger_sname = '" + lastName + "'";

        return jdbcTemplate.query(SELECT_BY_NAMES, (resultSet, i) -> {
            Ticket ticket = new Ticket();
            Passenger passenger = new Passenger();
            Trip trip = new Trip();
            Company company = new Company();
            AirPort airPortTo = new AirPort();
            AirPort airportFrom = new AirPort();
            Seat seat = new Seat();

            ticket.setTicketId(resultSet.getLong(1));
            passenger.setFirstName(resultSet.getString(2));
            passenger.setLastName(resultSet.getString(3));
            ticket.setGate(resultSet.getInt(4));
            airportFrom.setCountry(resultSet.getString(5));
            airportFrom.setCity(resultSet.getString(6));
            airPortTo.setCountry(resultSet.getString(7));
            airPortTo.setCity(resultSet.getString(8));
            trip.setTimeOut(resultSet.getString(9));
            company.setName(resultSet.getString(10));
            seat.setSeatId(resultSet.getLong(11));
            seat.setRaw(resultSet.getString(12));
            seat.setSeatClass(resultSet.getString(13));

            trip.setAirPortTo(airPortTo);
            trip.setAirPortFrom(airportFrom);
            ticket.setPassenger(passenger);
            ticket.setTrip(trip);
            ticket.setSeat(seat);
            ticket.setCompany(company);

            return ticket;
        });
    }

    public List<Company> getCompaniesByRating() {

        String SELECT_BY_RATING = "SELECT company_name, COUNT(ticket_id) AS sold_tickets FROM airport.ticket\n" +
                "INNER JOIN company\n" +
                "ON ticket_company = company_id\n" +
                "GROUP BY company_id";


        return jdbcTemplate.query(SELECT_BY_RATING, (resultSet, i) -> {
            Company company = new Company();
            company.setName(resultSet.getString(1));
            company.setTicketsSold(resultSet.getInt(2));
            return company;

        });
    }

    public List<Company> getCompaniesByCountryName(String countryName) {
        String SELECT_BY_COUNTRY = "SELECT DISTINCT company_id, company_name FROM ticket\n" +
                "INNER JOIN trip \n" +
                "ON ticket_trip_id = trip_id\n" +
                "INNER JOIN company\n" +
                "ON ticket_company = company_id\n" +
                "INNER JOIN airport \n" +
                "ON\n" +
                "trip_to = airport_id\n" +
                "WHERE airport_country = '" + countryName + "'";

        return jdbcTemplate.query(SELECT_BY_COUNTRY, (resultSet, i) -> {
            Company company = new Company();
            company.setCompanyId(resultSet.getLong(1));
            company.setName(resultSet.getString(2));
            return company;
        });
    }

    @Override
    public List<Quantity> getQuantityOfTrips(String dateFrom, String dateTo, String countryName) {
        String SELECT_COUNT = "SELECT count(trip_id)\n" +
                "FROM trip\n" +
                "INNER JOIN airport \n" +
                "ON trip_from = airport_id\n" +
                "WHERE ( trip_time_out BETWEEN " + "'" + dateFrom + "'" + "AND" + "'" + dateTo + "')" +
                "AND  airport_country = " + "'" + countryName + "'";

        return jdbcTemplate.query(SELECT_COUNT, (resultSet, i) -> {
            Quantity quantity = new Quantity();
            quantity.setQuantity(resultSet.getInt(1));

            return quantity;
        });
    }

}


