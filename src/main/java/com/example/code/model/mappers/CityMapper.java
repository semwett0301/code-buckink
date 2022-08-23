package com.example.code.model.mappers;

import com.example.code.model.dto.ResponseCityDTO;
import com.example.code.model.entities.City;
import com.example.code.model.entities.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mappings({
            @Mapping(source = "city.id", target = "id"),
            @Mapping(source = "city.name", target = "name"),
            @Mapping(source = "country.name", target = "country")
    })
    ResponseCityDTO toResponseDTO(City city, Country country);
}
