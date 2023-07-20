package com.example.emp.domain.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.emp.domain.emp.DTO.EmpDetailDTO;
import com.example.emp.domain.emp.DTO.EmpTableDTO;
import com.example.emp.domain.emp.service.EmpService;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;
    
    @GetMapping("/emp") //주소가져옴 
    public ModelAndView EmpMainController(){
        ModelAndView modelAndView = new ModelAndView();
        List<EmpTableDTO> empTableDTOList = empService.getEmpTableData();
        modelAndView.addObject("empTableDTOList", empTableDTOList);
        modelAndView.setViewName("main/emp-list");
        return modelAndView;
    }

    @GetMapping("/emp/{employeeId}")
    public ModelAndView EmpDetailController(@PathVariable Integer employeeId){ //@PathVariable - 특정 경로변수를 가져옴

        System.out.println(employeeId);

        EmpDetailDTO empDetailDTO = empService.getEmpDetailData(employeeId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empDetailDTO", empDetailDTO);
        modelAndView.setViewName("main/emp-detail");
        return modelAndView;
    }
}
