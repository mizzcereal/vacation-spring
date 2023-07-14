package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// Component - IoC에 등록될 객체라고 알림
@Controller

public class TempController {

    // ~~Mapping 화면 주소를 설정하는 어노테이션
    @GetMapping("/hello") // 실행하기전에 붙혀주기
    public ModelAndView index() {

        // 화면에 출력될 화면과 데이터를 세팅하는 객체
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", Math.random());
        modelAndView.setViewName("first");

        return modelAndView;

    }

}

// 위의 코드들로 mvc 3개가 다모임
