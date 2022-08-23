package com.example.code.services.UserService;

import com.example.code.model.dto.RequestUserInfoDTO;
import com.example.code.model.dto.ResponseUserDTO;
import com.example.code.model.dto.ResponseUserInfoDTO;

import java.util.Optional;
import java.util.UUID;

public interface UserInfoService {
    void register(RequestUserInfoDTO requestUserInfoDTO);

    Optional<ResponseUserInfoDTO> login(RequestUserInfoDTO requestUserInfoDTO);

    ResponseUserDTO getUserByID(UUID id);
}
