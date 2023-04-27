package com.flightreservationsystem.Repositories;

import com.flightreservationsystem.Models.Users;
import org.springframework.data.repository.CrudRepository;

//repository that extends CrudRepository
public interface IUsersRepository extends CrudRepository<Users, String>
{
    // The method will return a Users object if a user with the given username exists in the users table
    Users findByUsername(String username);
}
