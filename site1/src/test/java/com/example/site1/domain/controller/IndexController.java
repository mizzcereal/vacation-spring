package com.example.site1.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.site1.domain.DTO.IndexDTO;
import com.example.site1.domain.service.IndexService;

@Controller
public class IndexController {
    
    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        
        List<IndexDTO> indexDTOList = indexService.getMaingPageData();
        modelAndView.addObject("indexDTOList", indexDTOList);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
