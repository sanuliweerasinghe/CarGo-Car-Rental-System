package com.flightreservationsystem.Services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.flightreservationsystem.Models.Flights;
import com.flightreservationsystem.Repositories.IFlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}