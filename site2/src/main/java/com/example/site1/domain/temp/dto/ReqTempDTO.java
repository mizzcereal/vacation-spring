package com.example.site1.domain.temp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter // Setter안만들시 데이터 안들어감 Setter를 꼭넣어라 Request값이들어감
public class ReqTempDTO {
    private String name;
    private Integer age;
}
