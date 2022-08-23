package com.example.code.services.UserService;

import com.example.code.model.dto.RequestUserInfoDTO;
import com.example.code.model.dto.ResponseUserDTO;
import com.example.code.model.dto.ResponseUserInfoDTO;
import com.example.code.model.entities.UserInfo;
import com.example.code.model.mappers.UserInfoMapper;
import com.example.code.model.mappers.UserMapper;
import com.example.code.model.modelUtils.UserRole;
import com.example.code.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserInfoServiceImplementation implements UserInfoService {
    private UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImplementation(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @Override
    public void register(RequestUserInfoDTO requestUserInfoDTO) {
        UserInfo userInfo = UserInfoMapper.INSTANCE.toEntity(requestUserInfoDTO);
        userInfo.setUserRole(UserRole.TYPICAL);
        userInfoRepository.save(userInfo);
    }

    @Override
    public Optional<ResponseUserInfoDTO> login(RequestUserInfoDTO requestUserInfoDTO) {
        UserInfo loginUserInfo = userInfoRepository.findUserInfoByUsername(requestUserInfoDTO.getUsername());

        if (loginUserInfo != null && loginUserInfo.getPassword().equals(requestUserInfoDTO.getPassword())) {
            return Optional.of(UserInfoMapper.INSTANCE.toResponseDTO(loginUserInfo));
        }

        return Optional.empty();
    }

    @Override
    public ResponseUserDTO getUserByID(UUID id) {
        return UserMapper.INSTANCE.toResponseDTO(userInfoRepository.findUserInfoById(id));
    }
}
