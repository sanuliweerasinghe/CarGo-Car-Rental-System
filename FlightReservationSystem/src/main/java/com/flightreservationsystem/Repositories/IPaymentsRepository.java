package com.flightreservationsystem.Repositories;

import com.flightreservationsystem.Models.Flights;
import com.flightreservationsystem.Models.Payments;
import org.springframework.data.repository.CrudRepository;
import com.flightreservationsystem.Models.Reservations;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IPaymentsRepository extends CrudRepository <Payments, Integer>
{
    // Method to retrieve all records of payments table
    List<Payments> findAll();

}
