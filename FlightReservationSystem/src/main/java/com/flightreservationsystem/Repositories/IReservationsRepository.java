package com.flightreservationsystem.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.flightreservationsystem.Models.Reservations;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

//Repositories that extends CrudRepository
public interface IReservationsRepository extends CrudRepository<Reservations, Integer>
{
    // Method to retrieve reservations of a logged in user
    List<Reservations> findByUsername(String username);

    // Method to retrieve  all records of reservations table
    List<Reservations> findAll();

    // Method to get the bookingID of the latest booking of the logged in user
    Optional<Reservations> findByUsernameAndBookingDate(String username, Date bookingDate);
}
