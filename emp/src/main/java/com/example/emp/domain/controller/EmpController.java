package com.example.emp.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
    
    @GetMapping("/emp")
    public ModelAndView EmpController1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main/emp-list");
        return modelAndView;
    }

    @GetMapping("/emp-detail")
    public ModelAndView EmpController2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main/emp-detail");
        return modelAndView;
    }
}
