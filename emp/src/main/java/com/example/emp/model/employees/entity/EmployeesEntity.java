package com.example.emp.model.employees.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmployeesEntity {

    @Id
    @Column(name = "employee_id", nullable = false, unique = true)
    private Integer employeeId;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private LocalDateTime hireDate;

    @Column(name = "job_id", nullable = false)
    private String jobId;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "commission_pct", nullable = true)
    private Double commissionPct;

    @Column(name = "manager_id", nullable = true)
    private Integer managerId;

    @Column(name = "department_id", nullable = true)
    private Integer departmentId;

}
