package com.example.site0731.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.site0731.domain.main.dto.ResMainDTO;
import com.example.site0731.domain.main.service.MainService;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String mainPage(Model model) {
        ResMainDTO dto = mainService.getMainData();
        model.addAttribute("dto", dto);
        return "main";
    }

    // @GetMapping("/")
    // public ModelAndView mainPage() {
    // ModelAndView modelAndView = new ModelAndView();
    // ResMainDTO dto = mainService.getMainData();
    // modelAndView.setViewName("main"); // setViewName 뒤에 변수에는 templates 안에 html
    // 이름을 집어넣음
    // modelAndView.addObject("dto", dto)
    // return modelAndView;
}
