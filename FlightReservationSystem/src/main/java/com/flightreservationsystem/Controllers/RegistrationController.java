package com.flightreservationsystem.Controllers;

import com.flightreservationsystem.Models.Registration;
import com.flightreservationsystem.Repositories.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Marking class as Controller
@Controller
public class RegistrationController {

    //autowire the IRegistrationRepository
    @Autowired
    IRegistrationRepository iRegistrationRepository;

    // --------------------------------- Methods for adding new account ---------------------------------------

    // Method to get the form inputs to be entered into registration table
    @GetMapping("/RegistrationForm")
    public String getNewRegistrationData(Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Registration registration = new Registration();
        model.addAttribute("registration", registration);

        // Using the thymeleaf object to access the user inputs
        model.addAttribute("firstName", registration);
        model.addAttribute("lastName", registration);
        model.addAttribute("mobileNo", registration);
        model.addAttribute("email", registration);


        return "RegistrationForm";
    }
    // Method to add records to registration table
    @PostMapping("/RegistrationForm")
    public String registration(@ModelAttribute Registration registration, Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Registration registration = new Registration();
        model.addAttribute("registration", registration);

        // use the object to interact with database to save the new registration record
        iRegistrationRepository.save(registration);

        return "RegistrationForm";
    }
    // Method to view records of registration table
    @GetMapping("/RegistrationForm")
    public String viewRegistration(Model model)
    {
        List<Registration> myAccount = iRegistrationRepository.findAll();
        model.addAttribute("myAccount", myAccount);



        return "RegistrationForm";
    }
}

