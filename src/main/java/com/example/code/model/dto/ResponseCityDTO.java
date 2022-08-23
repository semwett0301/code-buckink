package com.example.code.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseCityDTO {
    private UUID id;
    private String name;
    private long popularity;
    private String country;
}
