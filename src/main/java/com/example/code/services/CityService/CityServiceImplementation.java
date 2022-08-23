package com.example.code.services.CityService;

import com.example.code.model.dto.ResponseCityDTO;
import com.example.code.model.mappers.CityMapper;
import com.example.code.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImplementation implements CityService{
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImplementation(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<ResponseCityDTO> getTopCities(int amount) {
        return getAllCities().stream()
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseCityDTO> getCitiesByPartOfName(String part) {
        return  getAllCities().stream()
                .filter(elem -> elem.getName().toLowerCase().contains(part.toLowerCase()))
                .sorted((a, b) -> {
                    if (a.getPopularity() > b.getPopularity()) {
                        return 1;
                    } else if (a.getPopularity() < b.getPopularity()) {
                        return -1;
                    }
                    return 0;
                })
                .limit(5)
                .collect(Collectors.toList());
    }

    private List<ResponseCityDTO> getAllCities() {
        return cityRepository.findAll(Sort.by(Sort.Direction.DESC, "popularity")).stream()
                .map(elem -> CityMapper.INSTANCE.toResponseDTO(elem, elem.getCountry()))
                .collect(Collectors.toList());
    }
}
