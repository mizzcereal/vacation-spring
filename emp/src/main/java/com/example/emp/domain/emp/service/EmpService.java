package com.example.emp.domain.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.domain.emp.DTO.EmpDetailDTO;
import com.example.emp.domain.emp.DTO.EmpTableDTO;
import com.example.emp.model.employees.entity.EmployeesEntity;
import com.example.emp.model.employees.repository.EmployeesRepository;

@Service
public class EmpService {
    
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<EmpTableDTO> getEmpTableData(){
        return EmpTableDTO.fromEntityList(employeesRepository.findAll()); //함수는 최대한 간결히 만들어라
    }

    public EmpDetailDTO getEmpDetailData(Integer employeeId){
        Optional<EmployeesEntity> employeesEntityOptional = employeesRepository.findByEmployeeId(employeeId);

        if(!employeesEntityOptional.isPresent()){
            throw new RuntimeException("잘못된 요청입니다");
        }
        return EmpDetailDTO.fromEntity(employeesEntityOptional.get());
    }
}
