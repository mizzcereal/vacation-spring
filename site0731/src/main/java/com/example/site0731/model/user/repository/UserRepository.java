package com.example.site0731.model.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site0731.model.user.entity.UserEntity;
import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByIdx(Long idx);

    Optional<UserEntity> findByPassword(String password);

    Optional<UserEntity> findByIdxAndId(Long idx, String id);

    List<UserEntity> findByIdContaining(String id);
}
