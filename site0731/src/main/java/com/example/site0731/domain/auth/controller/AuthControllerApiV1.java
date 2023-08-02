package com.example.site0731.domain.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.site0731.domain.auth.dto.ReqJoinDTO;
import com.example.site0731.domain.auth.dto.ReqLoginDTO;
import com.example.site0731.domain.auth.service.AuthServiceApiV1;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {
    

    @Autowired
    private AuthServiceApiV1 authServiceApiV1;


    // 무조건 상태코드를 보낸다 상태코드를 보낼때는 ResponseEntity를 보내야한다. 응답상태코드 = ResponstEntity(상태코드를 보낼 수 있고 응답 데이터를 보낼 수 있다.)
    @PostMapping("/join")
    // 객체를 받을 때에는 RequestBody를 붙여야한다.
    // 원래는 public 뒤에 ResponseBody를 붙여야하지만 @RestCOntroller안에 @ResponseBody가 있어서 안 부ㅠㅌ혀도 된다.
    public ResponseEntity<?> join(@RequestBody ReqJoinDTO dto){
        ResponseEntity<?> responseEntity = authServiceApiV1.join(dto); //dto데이터를 줄테니 회원가입을 시켜줘

        return responseEntity;

    }
    // 아이디랑 비밀번호를 받는 DTO를 만들어야한다.(JoinUserDTO)

    @PostMapping("/login")

    // Http는 요청과 응답을 둘다 가지고있다. HttpSession을 통해 내 정보를 session에 담는 것
    public ResponseEntity<?> login(@RequestBody ReqLoginDTO dto, HttpSession session){
        return authServiceApiV1.login(dto, session);


    }
    


    // Postman을 사용하는 이유 : 크롬에서는 GET 밖에 되지 않아서 PostMan을 사용해서 Post를 사용한다.
}



// 요청이랑 응답을 받는 것이 @Controller
// 최전선에서 처리하는 것이 @Service
// 데이터베이스 소스를 받아오는 것이 @Repository
// 필요한 파일이 있을시 빌려올 것이 있을시 쓰는 것이 @Autowried

// Request는 이용자가 서버에 요청하는 것 ex(네이버 이용자가 네이버 서버에 요청하는 것) 이 때 주소랑 메서드를 필요함 
// RequestBody는 Json을 가져오기 위해서 사용한다.()
// RequestParam은 파라미터값


// HTTP MeTHOD GetMapping은 데이터조회 PostMapping은 데이터 삽입(데이터 받기), PutMapping은 데이터 수정, DeleteMapping은 데이터 삭제
// 위의 4개를 다 모은것이 RequestMapping이다.

// ResponseBody 응답을 json으로 보내준다.(응답은 서버가 유저에게 보내준다)
// RequestBody든 ResponseBody든 body가 있으면 json을 보낸다라고 생각

// ResponseEntity는 응답을 보내는 객체(서버의 응답을 보내고싶을때 (200이나 400, 500을 보내고 싶을때 받))