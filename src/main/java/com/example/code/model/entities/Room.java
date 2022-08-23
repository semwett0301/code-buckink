package com.example.code.model.entities;


import com.example.code.model.modelUtils.RoomType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Room{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roomId;

    private RoomType roomType;
    private String name;
    private int numberOfPeople;
    private double price;

    @Lob
    private String description;

    @ManyToMany
    @JoinTable(
            name = "room_room_condition_like",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "room_condition_id"))
    private Set<RoomCondition> roomConditions;

    @ManyToOne
    private Hotel hotel;
}
