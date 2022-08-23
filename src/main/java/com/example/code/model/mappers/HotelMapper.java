package com.example.code.model.mappers;

import com.example.code.model.dto.ResponseHotelDTO;
import com.example.code.model.entities.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    ResponseHotelDTO toResponseDTO(Hotel hotel);
}
