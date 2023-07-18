package com.example.emp.domain.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
    
    @GetMapping("/emp") //주소가져옴 
    public ModelAndView EmpMainController(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main/emp-list");
        return modelAndView;
    }

    @GetMapping("/emp/1")
    public ModelAndView EmpDetailController(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main/emp-detail");
        return modelAndView;
    }
}
