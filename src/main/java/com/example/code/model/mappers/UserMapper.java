package com.example.code.model.mappers;

import com.example.code.model.dto.ResponseUserDTO;
import com.example.code.model.entities.UserInfo;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ResponseUserDTO toResponseDTO(UserInfo userInfo);
}
