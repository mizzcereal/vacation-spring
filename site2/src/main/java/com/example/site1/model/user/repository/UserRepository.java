package com.example.site1.model.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.site1.model.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // 유저의 idx를 줄테니까 UserEntity를 해당 idx를 가진 UserEntity를 리턴해줘
    // UserEntity findbyIdx(Integer idx);

    // 유저의 id를 줄테니까 해당 id를 가진 UserEntity를 리턴해줘
    UserEntity findByid(String id);

    // 유저의 idx를 줄테니까 해당 idx를 가진 Optional<UserEntity>로 리턴해줘
    Optional<UserEntity> findByIdx(Integer idx);
}
