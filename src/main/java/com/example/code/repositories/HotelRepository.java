package com.example.code.repositories;

import com.example.code.model.entities.City;
import com.example.code.model.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    List<Hotel> findAllByCity(City city);
}
