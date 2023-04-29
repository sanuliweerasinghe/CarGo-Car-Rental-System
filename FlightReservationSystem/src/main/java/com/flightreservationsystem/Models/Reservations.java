package com.flightreservationsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

// Marking class as an Entity
@Entity

// Defining class name as Table name
@Table(name = "reservations")
public class Reservations
{
    //Defining BookingID column as the primary key
    @Id
    @Column(name = "booking_id")
    private int bookingID;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_no")
    private int mobile;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "no_of_passengers")
    private int noOfPassengers;

    @Column(name = "cabin_class")
    private String cabinClass;

    @Column(name = "flight_id")
    private int flightID;

    @Column(name = "departure_date")
    private Date departureDate;


    //Getter for BookingID
    public int getBookingID()
    {
        return bookingID;
    }

    //Setter for bookingID
    public void setBookingID(int bookingID)
    {
        this.bookingID = bookingID;
    }

    //Getter for username
    public String getUsername()
    {
        return username;
    }

    //Setter for username
    public void setUsername(String username)
    {
        this.username = username;
    }

    //Getter for Mobile
    public int getMobile()
    {
        return mobile;
    }

    //Setter for mobile
    public void setMobile(int mobile)
    {
        this.mobile = mobile;
    }

    //Getter for BookingDate
    public Date getBookingDate()
    {
        return bookingDate;
    }

    //Setter for bookingDate
    public void setBookingDate(Date bookingDate)
    {
        this.bookingDate = bookingDate;
    }

    //Getter for NoOfPassengers
    public int getNoOfPassengers()
    {
        return noOfPassengers;
    }

    //Setter for noOfPassengers
    public void setNoOfPassengers(int noOfPassengers)
    {
        this.noOfPassengers = noOfPassengers;
    }

    //Getter for CabinClass
    public String getCabinClass()
    {
        return cabinClass;
    }

    //Setter for cabinClass
    public void setCabinClass(String cabinClass)
    {
        this.cabinClass = cabinClass;
    }

    //Getter for flightID
    public int getFlightID()
    {
        return flightID;
    }

    //Setter for flightID
    public void setFlightID(int flightID) { this.flightID = flightID;}

    //Getter for DepartureDate
    public Date getDepartureDate()
    {
        return departureDate;
    }

    //Setter for departureDate
    public void setDepartureDate(Date departureDate)
    {
        this.departureDate = departureDate;
    }

}
