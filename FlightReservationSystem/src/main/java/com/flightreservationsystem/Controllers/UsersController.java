package com.flightreservationsystem.Controllers;

import com.flightreservationsystem.Models.Users;
import com.flightreservationsystem.Repositories.IUsersRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//Marking class as Controller
@Controller
public class UsersController
{
    //autowire the IUsersRepository
    @Autowired
    IUsersRepository iUsersRepository;

    @GetMapping("/LoginForm")
    public String getLoginData(Model model)
    {
        // Creating an object from Users
        Users login = new Users();

        // Passing the object as a thymeleaf object to be used in Login Form
        model.addAttribute("login", login);

        // Getting the username and password inputs through the form
        model.addAttribute("username", login);
        model.addAttribute("password", login);

        return "LoginForm";
    }

    @PostMapping("/LoginForm")
    public String login(@ModelAttribute("login") Users login, BindingResult bindingResult, Model model) {

        // Check if the user exists in the database
        Users user = iUsersRepository.findByUsername(login.getUsername());

        // If the username doesn't exist in the 'users' table
        if (user == null)
        {
            // Setting an object of the error message to be displayed in Login Form
            model.addAttribute("errorMsg", "Invalid username!!!");

            return "LoginForm";
        }

        // Checking the password if the username exists,
        else if ((user != null) && (!user.getPassword().equals(login.getPassword())))
        {
            // Setting an object of the error message to be displayed in Login Form
            model.addAttribute("errorMsg", "Invalid password!!!");

            return "LoginForm";
        }

        // When the user exists and the password is correct
        else
        {
            // For the admin login, redirects to the Admin Dashboard
            if (user.getUsername().equals("Admin"))
            {
                return "../static/AdminDashboard";
            }

            // For the user login directed to User dashboard
            else
            {
                return "../static/UserDashboard";
            }
        }
    }
}
