package com.flightreservationsystem.Repositories;

import com.flightreservationsystem.Models.Registration;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface IRegistrationRepository extends CrudRepository<Registration, String> {
    // Method to retrieve all records of registration table
    List<Registration> findAll();

}
