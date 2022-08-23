package com.example.code.model.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Review extends BaseEntity{
    @Lob
    private String content;

    private int point;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private UserInfo user;
}
