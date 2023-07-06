package com.flightreservationsystem.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.flightreservationsystem.Models.Payments;
import com.flightreservationsystem.Repositories.IFlightsRepository;
import com.flightreservationsystem.Services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.flightreservationsystem.Models.Flights;

import javax.servlet.http.HttpSession;

//Marking class as Controller
@Controller
public class PaymentsController
{
    //autowire the FlightsRepository
    @Autowired
    IFlightsRepository iPaymentsRepository;

    //autowire the FlightsService class
    @Autowired
    FlightsService paymentsService;

    // --------------------------------- Methods for Adding Payment ---------------------------------------

    // Method to get the form inputs to be entered into payments table
    @GetMapping("/Payment")
    public String getPaymentData(Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Payments payment = new Payments();
        model.addAttribute("payment", payment);

        // Using the thymeleaf object to access the user inputs

        model.addAttribute("PayerName", payment);
        model.addAttribute("PaymentType", payment);
        model.addAttribute("PayAmount", payment);


        // Passing the current date as the pay date
        model.addAttribute("payDate", new java.sql.Date(System.currentTimeMillis()));

        return "Payment";
    }

    // Method to add records to payments table
    @PostMapping("/Payment")
    public String payment(@ModelAttribute Payments payment, Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Payments payment = new Payments();
        model.addAttribute("payment", payment);

        // use the object to interact with database to save the new payment record
        iPaymentsRepository.save(payment);

        return "ViewFlightsAdmin";
    }

    @GetMapping("/Payment")
    public String bookFlight(@RequestParam("bookingID") int bookingID,
                             Model model, HttpSession session)
    {
        // Creating an Optional object to hold the details of the payment confirmed by the user
        Optional<Payments> getPayment = paymentsService.getFlightByFlightIdAndDepartureDate(bookingID);

        // If a record is present in the flights table related to the booked flight.
        if (getPayment.isPresent()) {
            // Passing the flight object to the view
            model.addAttribute("confirmedPayment", getPayment.get());

            // Returning the name of the HTML file containing the form
            return "Payment";
        }
        return null;
    }
}
