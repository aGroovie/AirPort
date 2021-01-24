package airfield.ukraine.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Company {

    private Long companyId;

    private String name;

    private int ticketsSold;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return ticketsSold == company.ticketsSold &&
                Objects.equals(companyId, company.companyId) &&
                Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, name, ticketsSold);
    }
}
