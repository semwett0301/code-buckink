package com.example.code.api;

import com.example.code.model.dto.RequestUserInfoDTO;
import com.example.code.model.dto.ResponseUserDTO;
import com.example.code.model.dto.ResponseUserInfoDTO;
import com.example.code.services.UserService.UserInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@Data
public class UserController {
    private final UserInfoService userInfoService;

    @Autowired
    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    // server/users/registration  body: {username: abc, password: abc, email: abc}
    @PostMapping("/registration")
    public ResponseEntity registerNewUser(@RequestBody RequestUserInfoDTO requestUserInfoDTO) {
        userInfoService.register(requestUserInfoDTO);
        return ResponseEntity.ok().build();
    }

    // server/users/login  body: {username: abc, password: abc}
    @PostMapping("/login")
    public ResponseEntity<ResponseUserInfoDTO> loginUser(@RequestBody RequestUserInfoDTO requestUserInfoDTO) {
        Optional<ResponseUserInfoDTO> responseUserInfoDTO = userInfoService.login(requestUserInfoDTO);
        if (responseUserInfoDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(responseUserInfoDTO.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> getUserById(@PathVariable UUID id) {
        ResponseUserDTO result = userInfoService.getUserByID(id);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(result);
    }
}
