package com.example.code.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class RoomCondition{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roomConditionId;

    private String name;
    @ManyToMany(mappedBy = "roomConditions")
    private Set<Room> rooms;

}
