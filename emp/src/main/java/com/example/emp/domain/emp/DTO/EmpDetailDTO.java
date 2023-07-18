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

public class EmpDetailDTO {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Double salary;

    public static EmpDetailDTO fromEntity(EmployeesEntity employeesEntity) {
        return EmpDetailDTO.builder()
                .employeeId(employeesEntity.getEmployeeId())
                .firstName(employeesEntity.getFirstName())
                .lastName(employeesEntity.getLastName())
                .salary(employeesEntity.getSalary())
                .build();
    }
}
