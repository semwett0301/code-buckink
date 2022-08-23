package com.example.code.model.dto;

import com.example.code.model.modelUtils.UserRole;
import lombok.Data;

@Data
public class ResponseUserDTO {
    private String username;
    private String password;
    private UserRole userRole;
    private String email;
}
