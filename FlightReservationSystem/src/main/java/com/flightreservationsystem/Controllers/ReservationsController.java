package com.flightreservationsystem.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.flightreservationsystem.Services.ReservationsService;
import com.flightreservationsystem.Services.FlightsService;
import com.flightreservationsystem.Models.Flights;
import com.flightreservationsystem.Models.Reservations;
import com.flightreservationsystem.Repositories.IFlightsRepository;
import com.flightreservationsystem.Repositories.IReservationsRepository;


//Marking class as Controller
@Controller

public class ReservationsController
{
    //autowire the IReservationRepository
    @Autowired
    IReservationsRepository iReservationsRepository;

    //autowire the ReservationsService class
    @Autowired
    ReservationsService reservationsService;

    //autowire the IFlightsRepository
    @Autowired
    IFlightsRepository iFlightsRepository;

    //autowire the FlightsService class
    @Autowired
    FlightsService flightsService;


}
