package com.example.emp.model.employees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.model.employees.entity.EmployeesEntity;


public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {

    Optional<EmployeesEntity> findByEmployeeId(Integer employeeId);

    //EMP 테이블에서 firstName에 대소문자 구부없이 
    List<EmployeesEntity> findByFirstNameContainingIgnoreCase(String firstName);

    
}
