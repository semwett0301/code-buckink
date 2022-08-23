package com.example.code.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;
@Entity
@Data
public class Booking extends BaseEntity{
    private Date checkIn;
    private Date checkOut;
    private String email;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private UserInfo user;
}
