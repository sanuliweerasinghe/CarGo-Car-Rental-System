package com.flightreservationsystem.Services;

import java.util.ArrayList;
import java.util.List;

import com.flightreservationsystem.Models.Registration;
import com.flightreservationsystem.Repositories.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//defining the business logic
@Service
public class RegistrationService {
    @Autowired
    IRegistrationRepository iRegistrationRepository;

    //getting all records by using the method findAll() of CrudRepository
    public List<Registration> getAllRegistrations() {
        List<Registration> registration = new ArrayList<Registration>();
        iRegistrationRepository.findAll().forEach(registration1 -> registration.add(registration1));

        return registration;
    }

    // Method to get account details of the logged in user
    public List<Registration> getAccountByUsername(String username)
    {
        List<Registration> myAccountDetails = iRegistrationRepository.findAccountByUsername(username);
        return myAccountDetails;
    }
}
