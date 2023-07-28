package com.example.site1.domain.second.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResSecondDTO {
    private List<Post> postList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    // DTO는 출력할 html에 필요한 데이터만 집어넣도록 한다.
    public static class Post { // 이너클래스를 만들땐 static을 붙혀라
        private String title;
        private String content;
        private User user;

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        public static class User {
            private Integer idx;
        }
    }
}
