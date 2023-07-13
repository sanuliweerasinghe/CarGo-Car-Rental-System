package com.flightreservationsystem.Services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.flightreservationsystem.Models.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightreservationsystem.Repositories.IReservationsRepository;

//defining the business logic
@Service
public class ReservationsService
{
    @Autowired
    IReservationsRepository iReservationsRepository;

    // Method to get all reservations of the logged in user
    public List<Reservations> getReservationByUsername(String username)
    {
        List<Reservations> myReservations = iReservationsRepository.findByUsername(username);
        return myReservations;
    }

    // Getting the booking
    public Optional<Reservations> getBookingByUsernameAndBookingDate(String username, Date bookingDate)
    {
        Optional<Reservations> filteredBooking = iReservationsRepository.findByUsernameAndBookingDate(username, bookingDate);
        return filteredBooking;
    }

}
