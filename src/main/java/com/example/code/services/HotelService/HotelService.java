package com.example.code.services.HotelService;

import com.example.code.model.dto.RequestHotelDTO;
import com.example.code.model.dto.ResponseHotelDTO;

import java.util.List;

public interface HotelService {
    List<ResponseHotelDTO> getHotels(RequestHotelDTO requestHotelDTO);
}
