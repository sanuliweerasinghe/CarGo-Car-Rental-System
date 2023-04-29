package com.flightreservationsystem.Services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.flightreservationsystem.Models.Flights;
import com.flightreservationsystem.Repositories.IFlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


//defining the business logic
@Service
public class FlightsService
{
    @Autowired
    IFlightsRepository iFlightsRepository;

    //getting all flights record by using the method findAll() of CrudRepository
    public List<Flights> getAllFlights()
    {
        List<Flights> flights = new ArrayList<Flights>();
        iFlightsRepository.findAll().forEach(flights1 -> flights.add(flights1));

        return flights;
    }

    // Getting the records returned for the filtering criteria entered by the user using the method declared in IFlightsRepository
    public List<Flights> getFlightsByDepartureDateAndToCity(Date departureDate, String toCity)
    {
        // Creating a list to fetch flight records from repository based on departureDate and tocity
        List<Flights> filteredResult = iFlightsRepository.findByDepartureDateAndToCity(departureDate, toCity);

        return filteredResult;
    }

    // Method to delete the flight
    @Transactional
    public void deleteFlightById(int flightID, Date departureDate)
    {
        // Deleting the record in flights table by the flightID and departureDate
        iFlightsRepository.deleteByFlightIDAndDepartureDate(flightID, departureDate);
    }

}