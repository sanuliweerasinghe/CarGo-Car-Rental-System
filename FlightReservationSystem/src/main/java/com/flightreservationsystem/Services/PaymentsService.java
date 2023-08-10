package com.flightreservationsystem.Services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.flightreservationsystem.Models.Flights;
import com.flightreservationsystem.Models.Payments;
import com.flightreservationsystem.Repositories.IPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class PaymentsService
{
    @Autowired
    IPaymentsRepository iPaymentsRepository;

    //getting all payments record by using the method findAll() of CrudRepository
    public List<Payments> getAllFlights()
    {
        List<Payments> payments = new ArrayList<Payments>();
        iPaymentsRepository.findAll().forEach(payments1 -> payments.add(payments1));

        return payments;
    }
}
