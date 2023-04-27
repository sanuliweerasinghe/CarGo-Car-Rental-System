package com.flightreservationsystem.Services;

import com.flightreservationsystem.Models.Users;
import com.flightreservationsystem.Repositories.IUsersRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class UsersService
{
    @Autowired
    IUsersRepository iUsersRepository;

    //getting all flights record by using the method findAll() of CrudRepository
    public List<Users> getAllUsers()
    {
        List<Users> users = new ArrayList<Users>();
        iUsersRepository.findAll().forEach(users1 -> users.add(users1));

        return users;
    }
}
