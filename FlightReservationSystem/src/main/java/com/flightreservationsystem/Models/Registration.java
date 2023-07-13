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
    private int mobile ;

    @Column(name = "username")
    private String username ;

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
    public int getMobile()
    {
        return mobile;
    }

    //Setter for mobile
    public void setMobile(int mobileNo)
    {
        this.mobile= mobileNo;
    }

    //Getter for Username
    public String getUsername() {return username; }

    //Setter for Username
    public void setUsername(String username)
    {
        this.username = username;
    }

}
