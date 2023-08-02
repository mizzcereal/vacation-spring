package com.example.site0731.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.site0731.domain.main.dto.MainUserDTO;
import com.example.site0731.domain.main.dto.ResMainDTO;
import com.example.site0731.model.user.entity.UserEntity;
import com.example.site0731.model.user.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class MainService {
    
    @Autowired
    private UserRepository userRepository;

    public ResMainDTO getMainData(){

        //원두 가져오기
        List<UserEntity> userEntityList = userRepository.findAll();

        //아메리카노 컵 준비하기
        List<MainUserDTO> mainUserDTOList = new ArrayList<>();


        for (UserEntity userEntity : userEntityList) {
            //원두를 아메리카노로 만들기    
            MainUserDTO mainUserDTO = new MainUserDTO(userEntity.getIdx(), userEntity.getId());
            //아메리카노를 컵에 담기
            mainUserDTOList.add(mainUserDTO);
        }
        //캐리어에 아메리카노들 담고 컨트롤러한테 넘겨주기
        return new ResMainDTO(mainUserDTOList); //여기서 Return값인 ResMainDTO를 public void에서 publci ResMainDTO로 변경한다.
    }

}
