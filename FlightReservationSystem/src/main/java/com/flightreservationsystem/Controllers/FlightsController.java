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
}
