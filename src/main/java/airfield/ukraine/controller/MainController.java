package airfield.ukraine.controller;

import airfield.ukraine.dao.MemoryDaoImpl;
import airfield.ukraine.entity.Company;
import airfield.ukraine.entity.Passenger;
import airfield.ukraine.entity.Quantity;
import airfield.ukraine.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

//main menu
//Model View Controller
@Controller
@SessionAttributes({"tickets", "companiesFiltered","tripQuantity"})
public class MainController {


    MemoryDaoImpl memoryDaoImpl;

    @Autowired
    public void setMemoryDao(MemoryDaoImpl memoryDaoImpl) {
        this.memoryDaoImpl = memoryDaoImpl;
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }


    @GetMapping(value = "passenger-list")
    public String showPassengers(Model model) {
        Collection<Passenger> passengers = memoryDaoImpl.getPassengers();
        model.addAttribute("passengers", passengers);
        return "passenger-list";
    }

    @GetMapping(value = "ticket-list")
    public String showTickets(Model model) {
        model.getAttribute("tickets");
        return "ticket-list";
    }

    @PostMapping(value = "filterByNames")
    public String filterTickets(Model model, @RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName) {

        List<Ticket> tickets = memoryDaoImpl.findTicketInfoByName(firstName, lastName);
        model.addAttribute("tickets", tickets);

        return "redirect:/ticket-list";
    }


    @GetMapping(value = "companies-rating")
    public String showCompanies(Model model) {
        List<Company> companies = memoryDaoImpl.getCompaniesByRating();
        model.addAttribute("companies", companies);
        return "companies-rating";
    }

    @GetMapping(value = "company-list")
    public String showCompaniesFiltered(Model model) {
        model.getAttribute("companiesFiltered");
        return "company-list";
    }

    @PostMapping(value = "filterByCountry")
    public String filterByCountry(Model model, @RequestParam(value = "countryName", required = false) String country) {
        List<Company> companiesFiltered = memoryDaoImpl.getCompaniesByCountryName(country);
        model.addAttribute("companiesFiltered", companiesFiltered);

        return "redirect:company-list";
    }

    @GetMapping(value = "trip-list")
    public String tripList(Model model) {
        model.getAttribute("tripQuantity");
        return "trip-list";
    }

    @PostMapping(value = "filterByDate")
    public String filterByDate(Model model, @RequestParam(value = "dateFrom") String dateFrom,
                               @RequestParam(value = "dateTo") String dateTo, @RequestParam(value = "countryName") String countryName) {
        List<Quantity> tripQuantity = memoryDaoImpl.getQuantityOfTrips(dateFrom, dateTo, countryName);
        model.addAttribute("tripQuantity", tripQuantity);
        return "redirect:/trip-list";
    }
}
