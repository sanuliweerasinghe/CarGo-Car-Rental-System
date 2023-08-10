package com.flightreservationsystem.Controllers;

import java.sql.Date;
import java.util.Optional;

import com.flightreservationsystem.Models.Payments;
import com.flightreservationsystem.Models.Reservations;
import com.flightreservationsystem.Repositories.IPaymentsRepository;
import com.flightreservationsystem.Repositories.IReservationsRepository;
import com.flightreservationsystem.Services.PaymentsService;
import com.flightreservationsystem.Services.ReservationsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//Marking class as Controller
@Controller
public class PaymentsController
{
    //autowire the PaymentsRepository
    @Autowired
    IPaymentsRepository iPaymentsRepository;

    //autowire the PaymentsService class
    @Autowired
    PaymentsService paymentsService;

    //autowire the ReservationsRepository
    @Autowired
    IReservationsRepository iReservationsRepository;

    //autowire the ReservationsService class
    @Autowired
    ReservationsService reservationsService;

    // --------------------------------- Methods for Adding Payment ---------------------------------------

    // Method to get the form inputs to be entered into payments table
    @GetMapping("/Payment")
    public String getPaymentData(Model model, HttpSession session)
    {
        // Creating an object and passing it as a thymeleaf object
        Payments payment = new Payments();
        model.addAttribute("payment", payment);

        // Getting the username and bookingDate
        String username = (String) session.getAttribute("username");
        Date bookingDate = new Date(System.currentTimeMillis());

        // Method to get the booking recorded for the logged in user for the current date
        Optional<Reservations> getBooking = reservationsService.getBookingByUsernameAndBookingDate(username, bookingDate);

        // If the booking record is created
        if (getBooking.isPresent())
        {
            // Add the bookingID as a model attribute
            model.addAttribute("bookingID", getBooking.get().getBookingID());

            // Using the thymeleaf object to access the user inputs
            model.addAttribute("PayerName", payment);
            model.addAttribute("PaymentType", payment);
            model.addAttribute("PayAmount", payment);

            // Passing the current date as the pay date
            model.addAttribute("payDate", new java.sql.Date(System.currentTimeMillis()));
        }
            return "Payment";
    }

    // Method to add records to payments table
    @PostMapping("/Payment")
    public String payment(@ModelAttribute Payments addPayment, Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Payments payment = new Payments();
        model.addAttribute("payment", payment);

        // use the object to interact with database to save the new payment record
        iPaymentsRepository.save(addPayment);

        return "redirect:ViewReservations";
    }

    /*
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
    } */
}
