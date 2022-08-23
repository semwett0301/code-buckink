package com.example.code.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
public class RequestHotelDTO {
    private UUID cityId;
//    private Date checkIn;
//    private Date checkOut;
}
