package com.example.site0731.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqJoinDTO {
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class User {
        private String id;
        private String password;
    }
}
// 회원가입 정보를 담은 곳을 보내기 위해 담는 곳이다.
// 커피로 치면 캐리어다 즉 커피를 담은 컵을 다시 캐리어에 담는것이다.
// 형식을 통일하기 위해서 담는 곳이다 aDTO, bDTO, cDTO등 여러 DTO등을 받을 수 있어 한번에 담는 곳(치킨여러 박스를 한
// 종이가방에 담는 것).
