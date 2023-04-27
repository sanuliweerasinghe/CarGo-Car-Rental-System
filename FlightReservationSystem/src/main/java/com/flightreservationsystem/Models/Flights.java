package com.flightreservationsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

// Marking class as an Entity
@Entity

// Defining class name as Table name //flight_id
@Table(name = "flights")
public class Flights
{
    //Defining FlightID column as the primary key
    @Id
    @Column(name = "flight_id")
    private int flightID;

    @Column(name = "flight_name")
    private String flightName;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "to_city")
    private String toCity;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "departure_time")
    private BigDecimal departureTime;

    @Column(name = "duration")
    private String duration;

    @Column(name = "economy_price")
    private BigDecimal economyPrice;

    @Column(name = "premium_economy_price")
    private BigDecimal premiumEconomyPrice;

    @Column(name = "business_price")
    private BigDecimal businessPrice;

    @Column(name = "first_price")
    private BigDecimal firstPrice;

    //Getter for FlightID
    public int getFlightID()
    {
        return flightID;
    }

    //Setter for flightID
    public void setFlightID(int flightID)
    {
        this.flightID = flightID;
    }

    //Getter for FlightName
    public String getFlightName()
    {
        return flightName;
    }

    //Setter for flightName
    public void setFlightName(String flightName)
    {
        this.flightName = flightName;
    }

    //Getter for FromCity
    public String getFromCity()
    {
        return fromCity;
    }

    //Setter for fromCity
    public void setFromCity(String fromCity)
    {
        this.fromCity = fromCity;
    }

    //Getter for ToCity
    public String getToCity()
    {
        return toCity;
    }

    //Setter for toCity
    public void setToCity(String toCity)
    {
    this.toCity = toCity;
    }

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

    //Getter for DepartureTime
    public BigDecimal getDepartureTime()
    {
        return departureTime;
    }

    //Setter for departureTime
    public void setDepartureDate(BigDecimal departureTime)
    {
        this.departureTime = departureTime;
    }

    //Getter for Duration
    public String getDuration()
    {
        return duration;
    }

    //Setter for duration
    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    //Getter for EconomyPrice
    public BigDecimal getEconomyPrice()
    {
        return economyPrice;
    }

    //Setter for economyPrice
    public void setEconomyPrice(BigDecimal economyPrice)
    {
        this.economyPrice = economyPrice;
    }

    //Getter for PremiumEconomyPrice
    public BigDecimal getPremiumEconomyPrice()
    {
        return premiumEconomyPrice;
    }

    //Setter for premiumEconomyPrice
    public void setPremiumEconomyPrice(BigDecimal premiumEconomyPrice) {this.premiumEconomyPrice = premiumEconomyPrice;}

    //Getter for BusinessPrice
    public BigDecimal getBusinessPrice()
    {
        return businessPrice;
    }

    //Setter for businessPrice
    public void setBusinessPrice(BigDecimal businessPrice)
    {
        this.businessPrice = businessPrice;
    }

    //Getter for FirstPrice
    public BigDecimal getFirstPrice()
    {
        return firstPrice;
    }

    //Setter for firstPrice
    public void setFirstPrice(BigDecimal firstPrice)
    {
        this.firstPrice = firstPrice;
    }
}