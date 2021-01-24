package airfield.ukraine.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Seat {

    private Long seatId;

    private String seatClass;

    private String raw;

    private Plane plane;

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatId, seat.seatId) &&
                Objects.equals(seatClass, seat.seatClass) &&
                Objects.equals(raw, seat.raw) &&
                Objects.equals(plane, seat.plane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId, seatClass, raw, plane);
    }
}

