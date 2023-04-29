package com.flightreservationsystem.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.flightreservationsystem.Repositories.IFlightsRepository;
import com.flightreservationsystem.Services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.flightreservationsystem.Models.Flights;

//Marking class as Controller
@Controller
public class FlightsController
{
    //autowire the FlightsRepository
    @Autowired
    IFlightsRepository iFlightsRepository;

    //autowire the FlightsService class
    @Autowired
    FlightsService flightsService;

    // --------------------------------- Methods for Adding new Flight ---------------------------------------

    // Method to get the form inputs to be entered into flights table
    @GetMapping("/AddFlight")
    public String getNewFlightData(Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Flights addFlight = new Flights();
        model.addAttribute("addFlight", addFlight);

        // Using the thymeleaf object to access the user inputs
        model.addAttribute("FlightID", addFlight);
        model.addAttribute("FlightName", addFlight);
        model.addAttribute("FromCity", addFlight);
        model.addAttribute("ToCity", addFlight);
        model.addAttribute("DepartureDate", addFlight);
        model.addAttribute("DepartureTime", addFlight);
        model.addAttribute("Duration", addFlight);
        model.addAttribute("EconomyPrice", addFlight);
        model.addAttribute("PremiumEconomyPrice", addFlight);
        model.addAttribute("BusinessPrice", addFlight);
        model.addAttribute("FirstPrice", addFlight);

        return "AddFlight";
    }

    // Method to add records to flights table
    @PostMapping("/AddFlight")
    public String addFlight(@ModelAttribute Flights flight, Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Flights addFlight = new Flights();
        model.addAttribute("addFlight", addFlight);

        // use the object to interact with database to save the new flight record
        iFlightsRepository.save(flight);

        return "ViewFlightsAdmin";
    }

    // -------------------------------- Methods for Viewing all Flights ---------------------------------------

    // Method to view records of flights table by Admin user
    @GetMapping("/ViewFlightsAdmin")
    public String viewFlightsForAdmin(Model model)
    {
        List<Flights> flights = iFlightsRepository.findAll();
        model.addAttribute("flights", flights);

        return "ViewFlightsAdmin";
    }

    // Method to view records of flights table by users
    @GetMapping("/ViewFlightsUser")
    public String viewFlightsForUsers(Model model)
    {
        List<Flights> flights = iFlightsRepository.findAll();
        model.addAttribute("flights", flights);

        return "/ViewFlightsUser";
    }

    // Method to view records of flights table in Home page
    @GetMapping("/ViewFlights")
    public String viewFlights(Model model)
    {
        List<Flights> flights = iFlightsRepository.findAll();
        model.addAttribute("flights", flights);

        return "ViewFlights";
    }

    // -------------------------- Methods for Searching flights by FlightID -------------------------------

    // Method to get the flightID entered by user to search
    @GetMapping("/SearchFlight")
    public String getFlightID(Model model)
    {
        // Creating an object of the Flights model class
        Flights search = new Flights();

        // Passing the model class object as a thymeleaf object
        model.addAttribute("search", search);

        // Adding the 'search' value to the model as the attribute 'flightID'
        model.addAttribute("flightID", search);

        return "SearchFlight";
    }

    // Method for displaying the search results
    @PostMapping("/SearchFlight")
    public String searchFlightById(@RequestParam("flightID") int flightID, Model model)
    {
        // Creating an Optional container to hold flight records if returned
        Optional<Flights> searchFlights = iFlightsRepository.findById(flightID);

        // If there are flights which matches the searching criteria
        if (searchFlights.isPresent())
        {
            // Retrieving the Flight object from the Optional using get() method and assigning it to a variable
            Flights search = searchFlights.get();

            // Passing the above object as a thymeleaf object to be accessed by ViewSearchResults.html
            model.addAttribute("search", search);

            return "ViewSearchResults";
        }
        // If there's no flights which matches the searching criteria
        else
        {
            return "../static/NoSearchResults";
        }
    }

    // ----------------------- Methods for Filtering flights by departureDate and toCity ---------------------

    // Method to get the departureDate and toCity entered by user to filter
    @GetMapping("/FiltreFlight")
    public String filterFlights(Model model)
    {
        // Creating an object of the Flights model class
        Flights search = new Flights();

        // Passing the model class object as a thymeleaf object
        model.addAttribute("search", search);

        // Setting attributes for Departure Date and To city
        model.addAttribute("departureDate", search);
        model.addAttribute("toCity", search);

        return "SearchFlight";
    }

    // Method for displaying the filter results
    @PostMapping("/FiltreFlight")
    public String filterFlightByDateAndDestination(@RequestParam("departureDate") Date departureDate,
                                                   @RequestParam("toCity") String toCity,
                                                   Model model)
    {
        // Creating a list to store the returned flight records from the flights table
        List<Flights> filterFlights = flightsService.getFlightsByDepartureDateAndToCity(departureDate, toCity);

        // If any flights are available for the filtering criteria
        if (filterFlights.isEmpty())
        {
            // Directing to the NoFiltreResults.html page
            return "../static/NoFiltreResults";
        }
        else
        {
            // Passing the list as a thymeleaf object to ViewFiltreResults.html
            model.addAttribute("filterFlights", filterFlights);

            return "ViewFiltreResults";
        }
    }
}
