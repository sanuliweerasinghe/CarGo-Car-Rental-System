package com.flightreservationsystem.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.flightreservationsystem.Services.ReservationsService;
import com.flightreservationsystem.Services.FlightsService;
import com.flightreservationsystem.Models.Flights;
import com.flightreservationsystem.Models.Reservations;
import com.flightreservationsystem.Repositories.IFlightsRepository;
import com.flightreservationsystem.Repositories.IReservationsRepository;


//Marking class as Controller
@Controller

public class ReservationsController
{
    //autowire the IReservationRepository
    @Autowired
    IReservationsRepository iReservationsRepository;

    //autowire the ReservationsService class
    @Autowired
    ReservationsService reservationsService;

    //autowire the IFlightsRepository
    @Autowired
    IFlightsRepository iFlightsRepository;

    //autowire the FlightsService class
    @Autowired
    FlightsService flightsService;

    // ----------------------------------- Methods to Book flight ------------------------------------------

    @GetMapping("/BookFlight")
    public String bookFlight(@RequestParam("flightID") int flightID,
                             @RequestParam("departureDate") Date departureDate,
                             Model model, HttpSession session)
    {
        // Creating an Optional object to hold the details of the flight booked by the user
        Optional<Flights> getFlight = flightsService.getFlightByFlightIdAndDepartureDate(flightID, departureDate);

        // If a record is present in the flights table related to the booked flight.
        if (getFlight.isPresent())
        {
            // Passing the flight object to the view
            model.addAttribute("bookedFlight", getFlight.get());

            // Passing the current date as the booking date
            model.addAttribute("bookingDate", new java.sql.Date(System.currentTimeMillis()));

            // Getting the username of the logged in user through the session object
            String username = (String) session.getAttribute("username");

            // Passing the username
            model.addAttribute("username", username);

            // Returning the name of the HTML file containing the form
            return "BookFlight";
        }

        // If there's no record returned from the flights table
        else
        {
            return "redirect:/ViewFlightsUser";
        }
    }

    @PostMapping("/BookFlight")
    public String confirmBooking(@ModelAttribute Reservations reservation, Model model,
                                 @RequestParam("cabinClass") String cabinClass,
                                 @RequestParam("noOfPassengers") int noOfPassengers,
                                 @RequestParam("economyPrice") float economyPrice,
                                 @RequestParam("premiumEconomyPrice") float premiumEconomyPrice,
                                 @RequestParam("businessPrice") float businessPrice,
                                 @RequestParam("firstPrice") float firstPrice)
    {
        // Using the repository object to interact with database
        iReservationsRepository.save(reservation);

        // Creating a float variable to get the calculated payment price
        float price;

        // If the cabin class selected by the user is "First" class
        if(cabinClass.equals("First"))
        {
            // Calculating the payment of the booking
            price = noOfPassengers * firstPrice;
        }
        // If the cabin class selected by the user is "Business" class
        else if (cabinClass.equals("Business"))
        {
            // Calculating the payment of the booking
            price = noOfPassengers * businessPrice;
        }
        // If the cabin class selected by the user is "Economy" class
        else if (cabinClass.equals("Economy"))
        {
            // Calculating the payment of the booking
            price = noOfPassengers * economyPrice;
        }
        // If the cabin class selected by the user is "Premium Economy" class
        else
        {
            // Calculating the payment of the booking
            price = noOfPassengers * premiumEconomyPrice;
        }

        // Passing the calculated price value to the Payment.html
        model.addAttribute("price", price);

        return "Payment";
    }
}
