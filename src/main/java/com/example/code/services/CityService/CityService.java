package com.example.code.services.CityService;

import com.example.code.model.dto.ResponseCityDTO;

import java.util.List;

public interface CityService {
    List<ResponseCityDTO> getTopCities(int amount);

    List<ResponseCityDTO> getCitiesByPartOfName(String part);
}
