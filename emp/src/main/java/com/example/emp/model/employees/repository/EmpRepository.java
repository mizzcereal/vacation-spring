package com.example.emp.model.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.model.employees.entity.EmpEntity;

public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

}
