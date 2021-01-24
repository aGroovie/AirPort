package airfield.ukraine.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Trip {

    private Long tripId;

    private AirPort airPortFrom;

    private AirPort airPortTo;

    private String timeOut;

    private String timeIn;

    private Long planeId;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public AirPort getAirPortFrom() {
        return airPortFrom;
    }

    public void setAirPortFrom(AirPort airPortFrom) {
        this.airPortFrom = airPortFrom;
    }

    public AirPort getAirPortTo() {
        return airPortTo;
    }

    public void setAirPortTo(AirPort airPortTo) {
        this.airPortTo = airPortTo;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;
        Trip trip = (Trip) o;
        return Objects.equals(tripId, trip.tripId) &&
                Objects.equals(airPortFrom, trip.airPortFrom) &&
                Objects.equals(airPortTo, trip.airPortTo) &&
                Objects.equals(timeOut, trip.timeOut) &&
                Objects.equals(timeIn, trip.timeIn) &&
                Objects.equals(planeId, trip.planeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, airPortFrom, airPortTo, timeOut, timeIn, planeId);
    }
}
