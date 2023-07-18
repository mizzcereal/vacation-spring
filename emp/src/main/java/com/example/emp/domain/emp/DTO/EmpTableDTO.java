package com.example.emp.domain.emp.DTO;

import com.example.emp.model.employees.entity.EmployeesEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class EmpTableDTO {

    private Integer employeeId;
    private String firstName;

    public static EmpTableDTO fromEntity(EmployeesEntity employeesEntity) {
        return EmpTableDTO.builder()
                .employeeId(employeesEntity.getEmployeeId())
                .firstName(employeesEntity.getFirstName())
                .build();
    }
}
