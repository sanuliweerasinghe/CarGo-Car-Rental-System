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
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    //Getter for Email
    public String getEmail() {return email; }

    //Setter for email
    public void setEmail(String email)
    {
        this.email = email;
    }

    //Getter for Firstname
    public String getFirstname()
    {
        return firstname;
    }

    //Setter for Firstname
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    //Getter for Lastname
    public String getLastname()
    {
        return lastname;
    }

    //Setter for Lastname
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    //Getter for Mobile
    public int getMobile()
    {
        return mobile;
    }

    //Setter for mobile
    public void setMobile(int mobile)
    {
        this.mobile= mobile;
    }

}
