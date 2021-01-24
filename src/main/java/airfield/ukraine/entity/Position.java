package airfield.ukraine.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Position {

    private Long positionId;

    private String positionName;

    private float salary;

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Float.compare(position.salary, salary) == 0 &&
                Objects.equals(positionId, position.positionId) &&
                Objects.equals(positionName, position.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionId, positionName, salary);
    }
}
