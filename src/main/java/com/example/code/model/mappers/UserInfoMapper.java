package com.example.code.model.mappers;

import com.example.code.model.dto.RequestUserInfoDTO;
import com.example.code.model.dto.ResponseUserInfoDTO;
import com.example.code.model.entities.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {
    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    ResponseUserInfoDTO toResponseDTO(UserInfo userInfo);

    @Mappings({
            @Mapping(source = "requestUserInfoDTO.username", target = "username"),
            @Mapping(source = "requestUserInfoDTO.password", target = "password"),
            @Mapping(source = "requestUserInfoDTO.email", target = "email"),
    })
    UserInfo toEntity(RequestUserInfoDTO requestUserInfoDTO);
}
