package com.flightreservationsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Marking class as an Entity
@Entity

// Defining class name as Table name
@Table(name = "registration")
public class Registration
{
    //Defining email column as the primary key
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private int mobileNo ;

    //Getter for Email
    public String getEmail() {return email; }

    //Setter for email
    public void setEmail(String email)
    {
        this.email = email;
    }

    //Getter for Firstname
    public String getFirstName()
    {
        return firstName;
    }

    //Setter for Firstname
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    //Getter for Lastname
    public String getLastName()
    {
        return lastName;
    }

    //Setter for Lastname
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    //Getter for Mobile
    public int getMobileNo()
    {
        return mobileNo;
    }

    //Setter for mobile
    public void setMobileNo(int mobileNo)
    {
        this.mobileNo= mobileNo;
    }

}
