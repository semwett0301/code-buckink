package com.example.code.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Country extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "country")
    List<City> cities;
}
