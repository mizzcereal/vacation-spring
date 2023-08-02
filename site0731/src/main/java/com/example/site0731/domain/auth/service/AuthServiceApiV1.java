package com.example.site0731.domain.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.site0731.domain.auth.dto.ReqJoinDTO;
import com.example.site0731.domain.auth.dto.ReqLoginDTO;
import com.example.site0731.model.user.entity.UserEntity;
import com.example.site0731.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
@Transactional(readOnly = true)
public class AuthServiceApiV1 {

    @Autowired
    private UserRepository userRepository; // 회원가입을 하기위해 의존하고 있는 repository가 필요하기 때문에 가져옴

    @Transactional // 데이터를 저장(save, 데이터를 데이터베이스에 넣을 때)할 때 Transactional을 넣는다.
    public ResponseEntity<?> join(ReqJoinDTO reqJoinDTO) {

        if (reqJoinDTO.getUser().getId() == null) {
            return new ResponseEntity<>(
                    "아이디를 입력해주세요",
                    HttpStatus.BAD_REQUEST);
        }

        if (reqJoinDTO.getUser().getId().length() < 3) {
            return new ResponseEntity<>(
                    "아이디를 세글자 이상 입력해주세요",
                    HttpStatus.BAD_REQUEST);
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(reqJoinDTO.getUser().getId());

        // isPresent() = 이미 존재할때
        if (userEntityOptional.isPresent()) {
            return new ResponseEntity<>(
                    "이미 사용중인 아이디입니다.",
                    HttpStatus.BAD_REQUEST);
        }

        // 새로운 userEntity를 생성하는데 idx는 자동증가라서 null, id와 password는 reqJoinDTO에서 값을
        // get으로가져온다
        UserEntity userEntity = new UserEntity(null, reqJoinDTO.getUser().getId(),
                reqJoinDTO.getUser().getPassword());

        // INSERT INTO user VALUES(...) 를 save가 대신 역할해준다.
        userRepository.save(userEntity);

        return new ResponseEntity<>(
                "회원가입에 성공했습니다",
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {

        //select * from user where id = "너가친거"
        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        if (userEntityOptional.isEmpty()) {
            return new ResponseEntity<>(
                    "아이디가 없습니다.",
                    HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = userEntityOptional.get();

        if (!userEntity.getPassword().equals(dto.getUser().getPassword())) {
            return new ResponseEntity<>(
                    "비밀번호를 잘못 입력하였습니다.",
                    HttpStatus.BAD_REQUEST);
        }

        session.setAttribute("idx", userEntity.getIdx());
        session.setAttribute("id", userEntity.getId());

        return new ResponseEntity<>(
                "로그인에 성공하였습니다",
                HttpStatus.OK);

    }
}
