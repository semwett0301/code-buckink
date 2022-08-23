package com.example.code.repositories;

import com.example.code.model.entities.UserInfo;
import com.example.code.model.mappers.UserInfoMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {
    UserInfo findUserInfoByUsername(String username);
    UserInfo findUserInfoById(UUID id);
}
