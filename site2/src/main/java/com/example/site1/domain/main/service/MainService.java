package com.example.site1.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.model.user.entity.UserEntity;
import com.example.site1.model.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {
    
    private final UserRepository userRepository; //내가 유저정보를 가져올 수 있는 애를 소개시켜줄게

    // 내가 유저정보를 가져올 수 있는 애를 소개했으니 유저정보를 가져와봐
    public ResMainDTO getMainData(){

        //userRepository에 있는 모든 유저 가져오기    
        List<UserEntity> userEntityList = userRepository.findAll();

        //DTO 만들기
        List<ResMainDTO.User> userDTOList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList){
            ResMainDTO.User user = new ResMainDTO.User(userEntity.getId()); //userDTO.java에서 id만 있기때문에 

            userDTOList.add(user);
        }

        ResMainDTO resMainDTO = new ResMainDTO(userDTOList);
        
        return resMainDTO;

        
    }

    
}
