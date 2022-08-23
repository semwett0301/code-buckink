package com.example.code.model.dto;

import com.example.code.model.modelUtils.UserRole;
import lombok.Data;

import java.util.UUID;

@Data
public class ResponseUserInfoDTO {
    private UUID id;
    private UserRole userRole;
}
