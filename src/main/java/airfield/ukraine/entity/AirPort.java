package airfield.ukraine.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component

public class AirPort {

    private Long airportId;

    private String country;

    private String city;


    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirPort)) return false;
        AirPort airPort = (AirPort) o;
        return Objects.equals(airportId, airPort.airportId) &&
                Objects.equals(country, airPort.country) &&
                Objects.equals(city, airPort.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, country, city);
    }
}
