package com.flightreservationsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

// Marking class as an entity
@Entity

// Defining class name as Table name
@Table(name = "payments")
public class Payments
{
    //Defining PaymentID column as the primary key
    @Id
    @Column(name = "payment_id")
    private int paymentID;

    @Column(name = "payer_name")
    private String payerName;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "pay_amount")
    private float payAmount;

    @Column(name = "booking_id")
    private String bookingID;

    @Column(name = "pay_date")
    private String payDate;


    //Getter for PaymentID
    public int getPaymentID()
    {
        return paymentID;
    }

    //Setter for paymentID
    public void setPaymentID(int paymentID)
    {
        this.paymentID = paymentID;
    }

    //Getter for PayerName
    public String getPayerName()
    {
        return payerName;
    }

    //Setter for payerName
    public void setPayerName(String payerName)
    {
        this.payerName = payerName;
    }

    //Getter for PaymentType
    public String getPaymentType()
    {
        return paymentType;
    }

    //Setter for paymentType
    public void setPaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    //Getter for PayAmount
    public float getPayAmount()
    {
        return payAmount;
    }

    //Setter for payAmount
    public void setPayAmount(float payAmount)
    {
        this.payAmount = payAmount;
    }

    //Getter for BookingID
    public String getBookingID()
    {
        return bookingID;
    }

    //Setter for bookingID
    public void setBookingID(String bookingID)
    {
        this.bookingID = bookingID;
    }

    //Getter for PayDate
    public String getPayDate()
    {
        return payDate;
    }

    //Setter for payDate
    public void setPayDate(String payDate)
    {
        this.payDate = payDate;
    }


}
