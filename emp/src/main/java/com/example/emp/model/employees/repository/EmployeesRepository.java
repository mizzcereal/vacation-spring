package com.example.emp.model.employees.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.model.employees.entity.EmployeesEntity;


public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {

    Optional<EmployeesEntity> findByEmployeeId(Integer employeeId);
}
