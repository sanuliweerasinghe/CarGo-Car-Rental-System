package com.flightreservationsystem.Services;

import java.util.List;
import com.example.Models.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightreservationsystem.Repositories.IReservationsRepository;

//defining the business logic
@Service
public class ReservationsService
{
    @Autowired
    IReservationsRepository iReservationsRepository;


}
