package com.example.hr1.domain.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.domain.main.dto.ResUpdateMainDTO;
import com.example.hr1.domain.main.service.MainService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    // Mapping을 기반으로 함수를 실행 시키기 때문에
    // controller의 함수 이름은 중요하지 않다


    public ModelAndView mainPage(HttpServletRequest request){

        HttpSession session = request.getSession();

        session.setAttribute("name", "hong");


        ModelAndView modelAndView = new ModelAndView();
        List<ResMainDTO> resMainDTOList = mainService.getMainPageData();
        modelAndView.addObject("resMainDTOList", resMainDTOList);
        modelAndView.setViewName("main/main");
        return modelAndView;
    }

    @GetMapping("/main/update-page/{regionId}")
    public ModelAndView updatePage(@PathVariable Integer regionId, HttpServletRequest request){

        HttpSession session = request.getSession();
        
        System.out.println(session.getAttribute("name"));

        ModelAndView modelAndView = new ModelAndView();
        ResUpdateMainDTO resUpdateMainDTO = mainService.getUpdateMainPageData(regionId);
        modelAndView.addObject("resUpdateMainDTO", resUpdateMainDTO);
        modelAndView.setViewName("main/update");
        return modelAndView;
    }

    
}
