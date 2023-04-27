package com.flightreservationsystem.Repositories;

import com.flightreservationsystem.Models.Flights;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IFlightsRepository extends CrudRepository<Flights, Integer>
{
    // Method to retrieve all records of flights table
    List<Flights> findAll();

}
