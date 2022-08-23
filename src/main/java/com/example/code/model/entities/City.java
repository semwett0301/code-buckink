package com.example.code.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class City extends BaseEntity{
    private String name;

    private long popularity;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotelList;

    @ManyToOne
    private Country country;
}
