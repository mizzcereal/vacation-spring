package com.example.site1.domain.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Service에서 만든 DTO를 담을 공간(짜장면의 철가방이라 생각)

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResMainDTO {

    private List<User> userList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class User {
        // html에 main.user.id만 필요하기때문에 userid만 추출

        private String id;
    }

}
