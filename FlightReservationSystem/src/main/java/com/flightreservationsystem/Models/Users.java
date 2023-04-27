package com.flightreservationsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Marking class as an Entity
@Entity

// Defining class name as Table name
@Table(name = "users")
public class Users
{
    //Defining username column as the primary key
    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;


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

    //Getter for password
    public String getPassword()
    {
        return password;
    }

    //Setter for password
    public void setPassword(String password)
    {
        this.password = password;
    }
}
