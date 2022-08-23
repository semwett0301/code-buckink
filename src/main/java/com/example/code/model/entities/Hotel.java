package com.example.code.model.entities;

import com.example.code.model.modelUtils.Payment;
import com.example.code.model.modelUtils.Refund;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Hotel extends BaseEntity{

    private String name;
    private String address;
    private String phoneNumber;

    private int numberOfReviewers;

    private double rating;

    private String description;

    private Payment payment;

    private Refund refund;

    private boolean donation;

    @OneToMany(mappedBy = "hotel")
    List<Review> reviewList;

    @OneToMany(mappedBy = "hotel")
    List<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    List<Booking> bookings;

    @ManyToOne
    private City city;
}
