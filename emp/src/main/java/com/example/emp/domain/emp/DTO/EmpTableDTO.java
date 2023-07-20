package com.example.emp.domain.emp.DTO;

import java.util.List;

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

    public static List<EmpTableDTO> fromEntityList(List<EmployeesEntity> employeesEntityList) {

        return employeesEntityList
                .stream()
                .map((employeesEntity) -> fromEntity(employeesEntity)) //함수이므로 매개변수 이름은 아무거나 해도 상관없으니 entity로 하면 알아보기 쉽다.
                .toList();
    }
}
