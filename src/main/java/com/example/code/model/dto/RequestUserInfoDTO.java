package com.example.code.model.dto;

import lombok.*;
import org.springframework.lang.NonNull;

@Data
public class RequestUserInfoDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;

    private String email;
}
