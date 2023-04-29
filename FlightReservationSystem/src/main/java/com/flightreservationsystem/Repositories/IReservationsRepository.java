package com.flightreservationsystem.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.Models.Reservations;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

//Repositories that extends CrudRepository
public interface IReservationsRepository extends CrudRepository<Reservations, Integer>
{
}
