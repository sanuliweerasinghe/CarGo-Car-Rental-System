package com.flightreservationsystem.Controllers;

import com.flightreservationsystem.Models.Registration;
import com.flightreservationsystem.Models.Users;
import com.flightreservationsystem.Repositories.IRegistrationRepository;
import com.flightreservationsystem.Repositories.IUsersRepository;
import com.flightreservationsystem.Services.RegistrationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Marking class as Controller
@Controller
public class RegistrationController {

    //Autowiring the IRegistrationRepository
    @Autowired
    IRegistrationRepository iRegistrationRepository;

    //Autowiring the ReservationsService class
    @Autowired
    RegistrationService registrationService;

    //Autowiring the IUsersRepository
    @Autowired
    IUsersRepository iUsersRepository;

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
        model.addAttribute("username", registration);

        // Creating an object of User model and passing it as a thymeleaf object
        Users login = new Users();
        model.addAttribute("login", login);

        // Using the thymeleaf object to access the user inputs to pass to users table
        model.addAttribute("username", login);
        model.addAttribute("password", login);

        return "RegistrationForm";
    }

    // Method to add records to registration table
    @PostMapping("/RegistrationForm")
    public String registration(@ModelAttribute Registration register, Users user, Model model)
    {
        // Creating an object and passing it as a thymeleaf object
        Registration registration = new Registration();
        model.addAttribute("registration", registration);

        // Passing the firstName, lastName, mobile, email and username to registration table
        registration.setFirstName(registration.getFirstName());
        registration.setLastName(registration.getLastName());
        registration.setMobile(registration.getMobile());
        registration.setEmail(registration.getEmail());
        registration.setUsername(registration.getUsername());

        // Using the object to interact with database to save the new registration record
        iRegistrationRepository.save(registration);

        // Creating an object of User model and passing it as a thymeleaf object
        Users login = new Users();
        model.addAttribute("login", login);

        // Passing the username and password to users table
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());

        // Using the object to interact with database to save the new record in users table
        iUsersRepository.save(user);

        return "redirect:/LoginForm";
    }

    // Method to view records of registration table
    @GetMapping("/ViewAccount")
    public String viewAccount(Model model, HttpSession session)
    {
        // Getting the username of the logged in user through the session object
        String username = (String) session.getAttribute("username");

        List<Registration> getAccountDetails = registrationService.getAccountByUsername(username);
        model.addAttribute("getAccountDetails", getAccountDetails);

        return "MyAccount";
    }
}

