package com.flightreservationsystem.Repositories;

import com.flightreservationsystem.Models.Flights;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IFlightsRepository extends CrudRepository<Flights, Integer>
{
    // Method to retrieve all records of flights table
    List<Flights> findAll();

    // This method will return a Flights object if a record with the given DepartureDate and toCity exists in the flights table
    List<Flights> findByDepartureDateAndToCity(Date departureDate, String toCity);

    // Method to delete the flight record from the flights table using flightID and departureDate
    @Transactional
    public void deleteByFlightIDAndDepartureDate(int flightID, Date departureDate);

    // Method to get the record of the flight booked
    Optional<Flights> findByFlightIDAndDepartureDate(int flightID, Date departureDate);
}
