package com.example.code.services.HotelService;

import com.example.code.model.dto.RequestHotelDTO;
import com.example.code.model.dto.ResponseHotelDTO;
import com.example.code.model.entities.City;
import com.example.code.model.mappers.HotelMapper;
import com.example.code.repositories.CityRepository;
import com.example.code.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImplementation implements HotelService{
    private final CityRepository cityRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImplementation(CityRepository cityRepository, HotelRepository hotelRepository) {
        this.cityRepository = cityRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<ResponseHotelDTO> getHotels(RequestHotelDTO requestHotelDTO) {
        City requestCity = cityRepository.getReferenceById(requestHotelDTO.getCityId());
        return hotelRepository.findAllByCity(requestCity).stream()
                .map(HotelMapper.INSTANCE::toResponseDTO)
                .collect(Collectors.toList());
    }
}
