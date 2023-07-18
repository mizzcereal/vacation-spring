package com.example.emp.model.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.model.employees.entity.EmployeesEntity;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {

}
